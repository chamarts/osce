/**
 * 
 */
package ch.unibas.medizin.osce.client.a_nonroo.client.ui;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ch.unibas.medizin.osce.client.a_nonroo.client.OsMaConstant;
import ch.unibas.medizin.osce.client.i18n.OsceConstants;
import ch.unibas.medizin.osce.client.managed.request.AnamnesisCheckProxy;
import ch.unibas.medizin.osce.client.managed.request.AnamnesisCheckTitleProxy;
import ch.unibas.medizin.osce.client.style.widgets.IconButton;
import ch.unibas.medizin.osce.client.style.widgets.QuickSearchBox;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

/**
 * @author dk
 * 
 */
public class AnamnesisCheckViewImpl extends Composite implements
		AnamnesisCheckView {

	// private AnamnesisCheckPlace place = null;

	private static SystemStartViewUiBinder uiBinder = GWT
			.create(SystemStartViewUiBinder.class);

	interface SystemStartViewUiBinder extends
			UiBinder<Widget, AnamnesisCheckViewImpl> {
	}

//	private final UiIcons uiIcons = GWT.create(UiIcons.class);
	private final OsceConstants constants = GWT.create(OsceConstants.class);
	private Delegate delegate;

	@UiField
	SplitLayoutPanel splitLayoutPanel;

	@UiField(provided = true)
	QuickSearchBox searchBox;

	@UiField
	Button newButton;

	@UiField
	SimplePanel detailsPanel;
	
	@UiField
	ListBox filterTitle;
	
	@UiField
	IconButton refreshButton;
	
	@UiField
    VerticalPanel anamnesisCheckPanel;
	
	@UiField
	DivElement loadingImageContainer;
	
	@UiField
	TextBox newTitleText;
	
	@UiHandler("newTitleText")
	public void enterButtonPressed(KeyUpEvent event) {
		if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
			delegate.addNewTitleClicked(newTitleText.getText());
		}
	}

	@UiHandler("refreshButton")
	public void refreshButtonClicked(ClickEvent event) {
		delegate.performSearch();
	}

	@UiHandler("filterTitle")
	public void filterTitleChangeHandler(ChangeEvent event) {

		delegate.changeFilterTitleShown(filterTitle.getItemText(filterTitle
				.getSelectedIndex()));

	}

//	@UiHandler("rangeNum")
//	public void rangeNumChangeHandler(ChangeEvent event) {
//		delegate.changeNumRowShown(rangeNum.getItemText(rangeNum
//				.getSelectedIndex()));
//
//	}

//	public void initList() {
//
//		for (VisibleRange range : VisibleRange.values()) {
//			rangeNum.addItem(range.getName(), range.getName());
//		}
//		rangeNum.setItemSelected(1, true);
//	}

	protected Set<String> paths = new HashSet<String>();

	private Presenter presenter;

	@UiHandler("newButton")
	public void newButtonClicked(ClickEvent event) {
		delegate.addNewTitleClicked(newTitleText.getText());
	}

	/**
	 * Because this class has a default constructor, it can be used as a binder
	 * template. In other words, it can be used in other *.ui.xml files as
	 * follows: <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
	 * xmlns:g="urn:import:**user's package**">
	 * <g:**UserClassName**>Hello!</g:**UserClassName> </ui:UiBinder> Note that
	 * depending on the widget that is used, it may be necessary to implement
	 * HasHTML instead of HasText.
	 */
	public AnamnesisCheckViewImpl() {
		searchBox = new QuickSearchBox(new QuickSearchBox.Delegate() {
			@Override
			public void performAction() {
				delegate.performSearch();
			}
		});

		initWidget(uiBinder.createAndBindUi(this));
		init();
//		initList();
	}

	public String[] getPaths() {
		return paths.toArray(new String[paths.size()]);
	}

	public void init() {
		// bugfix to avoid hiding of all panels (maybe there is a better
		// solution...?!)
		splitLayoutPanel.setWidgetMinSize(splitLayoutPanel.getWidget(0),
				OsMaConstant.SPLIT_PANEL_MINWIDTH);
		newButton.setText(constants.addTitle());
		DOM.setElementAttribute(splitLayoutPanel.getElement(), "style",
				"position: absolute; left: 0px; top: 0px; right: 5px; bottom: 0px;");
	}

	@Override
	public void setDelegate(Delegate delegate) {
		this.delegate = delegate;
	}

	@Override
	public SimplePanel getDetailsPanel() {
		return detailsPanel;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

//	@Override
//	public void setListBoxItem(String length) {
//		int index = 0;
//		int selectedIndex = 0;
//		for (VisibleRange range : VisibleRange.values()) {
//			if (range.getName().equals(length)) {
//				selectedIndex = index;
//
//			}
//			index++;
//		}
//
//		rangeNum.setItemSelected(selectedIndex, true);
//	}

	@Override
	public void setSearchBoxShown(String selectedValue) {

		searchBox.setText(selectedValue);
	}

	@Override
	public String getSearchBoxShown() {

		return searchBox.getValue();
	}

	@Override
	public void setSearchFocus(boolean focused) {
		searchBox.setFocus(focused);
	}

	@Override
	public ListBox getFilterTitle() {
		return filterTitle;
	}

	@Override
	public QuickSearchBox getSearchBox() {
		return searchBox;
	}
	
	private HorizontalPanel getHeaderPanelForTitle(final AnamnesisCheckTitleProxy title, final DisclosurePanel disclosurePanel) {
		HorizontalPanel panel = new HorizontalPanel();
		panel.setSpacing(2);
		panel.setWidth("100%");
		panel.setVerticalAlignment(VerticalPanel.ALIGN_MIDDLE);
		panel.setHorizontalAlignment(HorizontalPanel.ALIGN_LEFT);

		Label label = new Label(title.getText());
		label.setWidth("150px");
		final HorizontalPanel iconImagePanel = new HorizontalPanel();
		iconImagePanel.setWidth("15px");
		IconButton addBtnButton = new IconButton(constants.addQuestion());
		addBtnButton.setIcon("plusthick");
		addBtnButton.addDomHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				event.stopPropagation();
				//TODO go to detail , add detail
				if (!disclosurePanel.isOpen()) {
					disclosurePanel.setOpen(true);
				}
				delegate.newDetailClicked(String.valueOf(title.getId()));
			}
			
		}, ClickEvent.getType());
		
		final IconButton editTitleButton = new IconButton();
		editTitleButton.setIcon("pencil");
		editTitleButton.addDomHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				event.stopPropagation();
				delegate.editTitle(title, editTitleButton);
			}
		}, ClickEvent.getType());
		
		IconButton deleteTitleButton = new IconButton();
		deleteTitleButton.setIcon("trash");
		deleteTitleButton.addDomHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				event.stopPropagation();
				delegate.deleteTitle(title);
			}
		}, ClickEvent.getType());

		HorizontalPanel moveUpPanel = new HorizontalPanel();
		moveUpPanel.addStyleName("upIcon");
		moveUpPanel.addDomHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				event.stopPropagation();
				
				int index = anamnesisCheckPanel.getWidgetIndex(disclosurePanel);
				if (index == 0) {
					return;
				}
				
				anamnesisCheckPanel.remove(index);
				anamnesisCheckPanel.insert(disclosurePanel, index-1);
				
				delegate.moveUpTitle(title);
			}
			
		}, ClickEvent.getType());
		HorizontalPanel moveDownPanel = new HorizontalPanel();
		moveDownPanel.addStyleName("downIcon");
		moveDownPanel.addDomHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				event.stopPropagation();
				
				int index = anamnesisCheckPanel.getWidgetIndex(disclosurePanel);
				if (index == anamnesisCheckPanel.getWidgetCount() - 1) {
					return;
				}
				
				anamnesisCheckPanel.remove(index);
				anamnesisCheckPanel.insert(disclosurePanel, index + 1);
				
				delegate.moveDownTitle(title);
			}
			
		}, ClickEvent.getType());
		
		panel.add(iconImagePanel);
		panel.add(label);
		panel.add(editTitleButton);
		panel.add(deleteTitleButton);
		panel.add(addBtnButton);
		panel.add(moveUpPanel);
		panel.add(moveDownPanel);
		
		OpenHandler<DisclosurePanel> openHandler = new OpenHandler<DisclosurePanel>() {
			@Override
			public void onOpen(OpenEvent<DisclosurePanel> event) {
				iconImagePanel.removeStyleName("rightIcon");
				iconImagePanel.addStyleName("downIcon");
				// TODO fix... request may already be runnint? in which case?
				delegate.setQuestionTableData(title);
			}
		}; 

		CloseHandler<DisclosurePanel> closeHandler = new CloseHandler<DisclosurePanel>() {
			
			@Override
			public void onClose(CloseEvent<DisclosurePanel> event) {
				iconImagePanel.removeStyleName("downIcon");
				iconImagePanel.addStyleName("rightIcon");
			}
		};
		
		//when open DisclosurePanel,add data to table
		disclosurePanel.addOpenHandler(openHandler);			
		disclosurePanel.addCloseHandler(closeHandler);

		closeHandler.onClose(null);
		return panel;
	}
	
	public void addAnamnesisCheckTitle(final AnamnesisCheckTitleProxy title, boolean isOpen) {
		Log.debug("addAnamnesisCheckTitle(): " + title.getText());
		AnamnesisCheckTable anamnesisCheckTable = new AnamnesisCheckTable(title);
		final ListDataProvider<AnamnesisCheckProxy> dataProvider = new ListDataProvider<AnamnesisCheckProxy>();
		final SingleSelectionModel<AnamnesisCheckProxy> selectionModel = new SingleSelectionModel<AnamnesisCheckProxy>();
		anamnesisCheckTable.setDataProvider(dataProvider);
		anamnesisCheckTable.setSelectionModel(selectionModel);
		anamnesisCheckTable.setDelegate(delegate);
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler(){
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				AnamnesisCheckProxy selectedObject = selectionModel.getSelectedObject();
				if (selectedObject != null) {						
					delegate.showDetails(selectedObject);
				}
			}
		});
		CellTable<AnamnesisCheckProxy> cellTable = anamnesisCheckTable.initTable();
		DisclosurePanel advancedDisclosure = new DisclosurePanel();
		HorizontalPanel headerPanel = getHeaderPanelForTitle(title, advancedDisclosure);
		advancedDisclosure.setHeader(headerPanel);
		advancedDisclosure.setAnimationEnabled(true);
		advancedDisclosure.ensureDebugId("cwDisclosurePanel");
		
		//Add table to DisclosurePanel
		advancedDisclosure.setContent(cellTable);
		advancedDisclosure.setWidth("100%");
		delegate.addDataProvider(title, dataProvider);

		anamnesisCheckPanel.add(advancedDisclosure);
		if (loadingImageContainer.hasParentElement()) {
			loadingImageContainer.removeFromParent();
		}

		advancedDisclosure.setOpen(isOpen);
	}

	@Override
	public void loadAnamnesisCheckPanel(List<AnamnesisCheckTitleProxy> anamnesisCheckTitleList, boolean isOpen) {
		anamnesisCheckPanel.clear();
		for(final AnamnesisCheckTitleProxy anamnesisCheckTitleProxy : anamnesisCheckTitleList){
			addAnamnesisCheckTitle(anamnesisCheckTitleProxy, isOpen);
		}
	}

	@Override
	public VerticalPanel getAnamnesisCheckPanel() {
		return anamnesisCheckPanel;
	}
	
	interface Style extends CssResource {
		String hilight();
	}
	
	@UiField
	Style style;
	
	@Override
	public void filterTitle(AnamnesisCheckTitleProxy title) {
		if (title == null) {
			filterTitle.setSelectedIndex(0);
		} else {		
			for (int i=0; i < filterTitle.getItemCount(); i++) {
				if (filterTitle.getValue(i).equals(title.getId().toString())) {
					filterTitle.setSelectedIndex(i);
					break;
				}
			}
		}
		
		filterTitle.addStyleName(style.hilight());
		Timer timer = new Timer() {
			
			@Override
			public void run() {
				filterTitle.removeStyleName(style.hilight());
			}
		};
		timer.schedule(2500);
	}
}

