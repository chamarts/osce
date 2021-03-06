package ch.unibas.medizin.osce.client.a_nonroo.client.ui.roleAssignment;

import java.util.Iterator;
import java.util.List;

import ch.unibas.medizin.osce.client.managed.request.StandardizedPatientProxy;
import ch.unibas.medizin.osce.client.style.widgets.IconButton;
import ch.unibas.medizin.osce.client.style.widgets.ProxySuggestOracle;
import ch.unibas.medizin.osce.shared.StandardizedPatientStatus;
import ch.unibas.medizin.osce.shared.i18n.OsceConstants;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.Widget;

public class ManualStandardizedPatientInSemesterAssignmentPopupViewImpl extends
		DialogBox implements
		ManualStandardizedPatientInSemesterAssignmentPopupView {

	interface Binder
			extends
			UiBinder<Widget, ManualStandardizedPatientInSemesterAssignmentPopupViewImpl> {
	}

	private static final Binder BINDER = GWT.create(Binder.class);
	// private static ManualStandardizedPatientInSemesterAssignmentPopupViewImpl
	// manualStdPatientInSemesterAssignmentPopupViewImpl;

	private final OsceConstants constants = GWT.create(OsceConstants.class);
	// public static MultiWordSuggestOracle stdPatientMultiWordSuggestOracle =
	// new MultiWordSuggestOracle();
	private Delegate delegate;
	private StandardizedPatientProxy standardizedPatientProxy;
	private List<StandardizedPatientProxy> standardizedPatientProxies;

	@UiField(provided = true)
	SuggestBox standardizedPatientSugestionBox = new SuggestBox(
			new ProxySuggestOracle<StandardizedPatientProxy>(
					new AbstractRenderer<StandardizedPatientProxy>() {
						@Override
						public String render(StandardizedPatientProxy object) {
							return object.getName() + " " + object.getPreName();
						}
					}// ));
					, ",;:. \t?!_-/\\"));

	@UiField
	IconButton standardizedPatientAddButton;

	@UiField
	IconButton addAllButton;

	@UiField
	IconButton closeBoxButton;

	@UiHandler("closeBoxButton")
	public void closeBoxButtonClicked(ClickEvent e) {
		hide();
	}

	//MODULE 3 : TACK B
	@UiHandler("addAllButton")
	public void addAllButtonClicked(ClickEvent e) {
		Log.info("standardizedPatientProxies.size()" +standardizedPatientProxies.size());
		if (standardizedPatientProxies.size() > 0 && isActivePatientAvailable()) {
			delegate.onAddAllActive(standardizedPatientProxies);
		} else {
			suggestionBoxLbl.setText(constants.patientIsNotAvailable());
		}
	}

	private boolean isActivePatientAvailable(){
		for (Iterator<StandardizedPatientProxy> iterator = standardizedPatientProxies.iterator(); iterator.hasNext();) {
			StandardizedPatientProxy standardizedPatientProxy = (StandardizedPatientProxy) iterator.next();
			if(standardizedPatientProxy.getStatus() == StandardizedPatientStatus.ACTIVE)
				return true;
		}
		return false;
	}	
	//MODULE 3 : TACK B
	
	@UiField
	Label suggestionBoxLbl;

	public ManualStandardizedPatientInSemesterAssignmentPopupViewImpl() {
		setWidget(BINDER.createAndBindUi(this));

		this.standardizedPatientAddButton.setText(constants.addPatient());
		this.setGlassEnabled(true);
		this.setAnimationEnabled(true);
		this.setAutoHideEnabled(true);
		this.setText(constants.addManually());
		this.closeBoxButton.setText(constants.close());
		this.addAllButton.setText(constants.addAllActive());

		initSuggestBox();

		this.center();
	}

	@UiHandler("standardizedPatientAddButton")
	public void onClickEvent(ClickEvent clickEvent) {
		if (standardizedPatientSugestionBox.getValue().trim().compareTo("") != 0) {
			if (this.delegate != null) {
				if (standardizedPatientProxy != null) {
					Log.info("delegate is avilable");
					this.delegate
							.onStandizedPatientAddBtnClick(standardizedPatientProxy);
				} else {
					suggestionBoxLbl.setText(constants.enterPatient());
					standardizedPatientSugestionBox.setText(constants
							.enterPatient());

				}
			} else {
				Log.info("delegate Value is NULL");
			}
			// showPatientAssignmentPopup(false);
		} else {
			Log.info("Suggest Box Value is NULL");
		}

	}

	public void setDetails(
			List<StandardizedPatientProxy> standardizedPatientProxies,
			Delegate delegate, Button parentButton) {

		this.setDelegate(delegate);
		this.setStandizedPatientAutocompleteValue(standardizedPatientProxies);
		this.standardizedPatientProxies = standardizedPatientProxies;

		this.setPopupPosition(parentButton.getAbsoluteLeft(),
				parentButton.getAbsoluteTop() - getOffsetHeight() / 2 - 6);
		this.show();

	}

	// public void showPatientAssignmentPopup(boolean show) {
	// if (show) {
	// if (!this.isShowing()) {
	// this.standardizedPatientSugestionBox.getTextBox().setText(
	// constants.enterPatient());
	// this.show();
	// }
	// } else if (this != null) {
	// this.hide();
	// }
	// }

	private void initSuggestBox() {

		// standardizedPatientSugestionBox

		standardizedPatientSugestionBox.setText(constants.enterPatient());
		standardizedPatientSugestionBox.getTextBox().addFocusHandler(
				new FocusHandler() {
					@Override
					public void onFocus(FocusEvent event) {
						if (standardizedPatientSugestionBox.getText().equals(
								constants.enterPatient())) {
							standardizedPatientSugestionBox.setText("");
							suggestionBoxLbl.setText("");
						}
					}
				});
		standardizedPatientSugestionBox.getTextBox().addBlurHandler(
				new BlurHandler() {
					@Override
					public void onBlur(BlurEvent event) {
						if (standardizedPatientSugestionBox.getText()
								.equals("")) {
							standardizedPatientSugestionBox.setText(constants
									.enterPatient());
							suggestionBoxLbl.setText("");
						}
					}
				});

		standardizedPatientSugestionBox
				.addSelectionHandler(new SelectionHandler<SuggestOracle.Suggestion>() {

					@Override
					public void onSelection(SelectionEvent<Suggestion> event) {
						// TODO Auto-generated method stub
						System.out.println("on Selection");
						standardizedPatientSugestionBox.setValue(event
								.getSelectedItem().getReplacementString());

						standardizedPatientProxy = (StandardizedPatientProxy) ((ProxySuggestOracle<StandardizedPatientProxy>.ProxySuggestion) event
								.getSelectedItem()).getProxy();
					}

				});

		standardizedPatientSugestionBox.addChangeListener(new ChangeListener() {
			@Override
			public void onChange(Widget sender) {
				// TODO Auto-generated method stub
				System.out.println("on Change");
				standardizedPatientSugestionBox.setValue(((SuggestBox) sender)
						.getTextBox().getValue());
				suggestionBoxLbl.setText("");
			}
		});
	}

	@Override
	public void setDelegate(Delegate delegate) {
		this.delegate = delegate;
		Log.info("Delegate set .. ");

	}

	@Override
	public void setStandizedPatientAutocompleteValue(
			List<StandardizedPatientProxy> values) {

		// Log.info("List of Values of SP is: " + values.size());

		((ProxySuggestOracle<StandardizedPatientProxy>) standardizedPatientSugestionBox
				.getSuggestOracle()).addAll(values);

		// for (int i = 0; i < values.size(); i++) {
		// if (values.get(i) != null) {
		// try {
		// ((ProxySuggestOracle<StandardizedPatientProxy>)
		// standardizedPatientSugestionBox
		// .getSuggestOracle()).add(values.get(i));
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// }

	}

	public SuggestBox getStandardizedPatientSugestionBox() {
		return standardizedPatientSugestionBox;
	}

	public Delegate getDelegate() {
		return delegate;
	}

}
