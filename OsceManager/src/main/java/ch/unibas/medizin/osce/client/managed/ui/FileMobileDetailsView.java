package ch.unibas.medizin.osce.client.managed.ui;

import ch.unibas.medizin.osce.client.managed.request.FileProxy;
import ch.unibas.medizin.osce.client.managed.request.StandardizedRoleProxy;
import ch.unibas.medizin.osce.client.managed.ui.FileMobileDetailsView.Binder;
import ch.unibas.medizin.osce.client.scaffold.place.ProxyDetailsView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class FileMobileDetailsView extends FileMobileDetailsView_Roo_Gwt {

    private static final Binder BINDER = GWT.create(Binder.class);

    private static ch.unibas.medizin.osce.client.managed.ui.FileMobileDetailsView instance;

    @UiField
    HasClickHandlers delete;

    private Delegate delegate;

    public FileMobileDetailsView() {
        initWidget(BINDER.createAndBindUi(this));
    }

    public static ch.unibas.medizin.osce.client.managed.ui.FileMobileDetailsView instance() {
        if (instance == null) {
            instance = new FileMobileDetailsView();
        }
        return instance;
    }

    public Widget asWidget() {
        return this;
    }

    public boolean confirm(String msg) {
        return Window.confirm(msg);
    }

    public FileProxy getValue() {
        return proxy;
    }

    @UiHandler("delete")
    public void onDeleteClicked(ClickEvent e) {
        delegate.deleteClicked();
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    interface Binder extends UiBinder<HTMLPanel, FileMobileDetailsView> {
    }
}
