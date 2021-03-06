package ch.unibas.medizin.osce.client.a_nonroo.client.ui.role;

import ch.unibas.medizin.osce.client.a_nonroo.client.ui.examination.MessageConfirmationDialogBox;
import ch.unibas.medizin.osce.client.i18n.OsceConstants;
import ch.unibas.medizin.osce.client.managed.request.ChecklistOptionProxy;
import ch.unibas.medizin.osce.client.style.widgets.IconButton;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class RoleDetailsChecklistSubViewChecklistOptionItemViewImpl extends Composite implements RoleDetailsChecklistSubViewChecklistOptionItemView{

	private static final Binder BINDER = GWT.create(Binder.class);
	
	private Delegate delegate;
	
	private RoleDetailsChecklistSubViewChecklistOptionItemViewImpl roleDetailsChecklistSubViewChecklistOptionItemViewImpl;
	
	private final OsceConstants constants = GWT.create(OsceConstants.class);
	
	@UiField
	Label optionLbl;
	
	public Label getOptionLbl() {
		return optionLbl;
	}

	public void setOptionLbl(Label optionLbl) {
		this.optionLbl = optionLbl;
	}

	public Label getOptionValueLbl() {
		return optionValueLbl;
	}

	public void setOptionValueLbl(Label optionValueLbl) {
		this.optionValueLbl = optionValueLbl;
	}

	@UiField
	Label optionValueLbl;
	
	@UiField
	IconButton deleteBtn;
	
	
	ChecklistOptionProxy proxy;
	
	public ChecklistOptionProxy getProxy() {
		return proxy;
	}

	public void setProxy(ChecklistOptionProxy proxy) {
		this.proxy = proxy;
	}

	public RoleDetailsChecklistSubViewChecklistOptionItemViewImpl() {
		initWidget(BINDER.createAndBindUi(this));
		this.roleDetailsChecklistSubViewChecklistOptionItemViewImpl=this;
	}
	
	public void setDelegate(Delegate delegate) {
		this.delegate = delegate;
	}
	
	interface Binder extends UiBinder<Widget, RoleDetailsChecklistSubViewChecklistOptionItemViewImpl> {
	}
	
	@UiHandler("deleteBtn")
	public void deleteOption(ClickEvent event)
	{
	/*	if(Window.confirm("are you sure you want to delete this option?"))*/
		// Issue Role
				 final MessageConfirmationDialogBox dialogBox=new MessageConfirmationDialogBox("Warning");
				 dialogBox.showYesNoDialog("are you sure you want to delete this option?");
				 dialogBox.getYesBtn().addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							dialogBox.hide();
							Log.info("Yes click");
							delegate.deleteOption(roleDetailsChecklistSubViewChecklistOptionItemViewImpl);
							return;
							
						}
					});
					
						dialogBox.getNoBtnl().addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							dialogBox.hide();
							Log.info("no click");
							return;
							
						}
					});
				// E: Issue Role
	}
	
}
