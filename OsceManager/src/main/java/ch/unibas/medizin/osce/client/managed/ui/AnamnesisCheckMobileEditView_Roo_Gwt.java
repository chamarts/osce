// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.osce.client.managed.ui;

import ch.unibas.medizin.osce.client.managed.activity.AnamnesisCheckEditActivityWrapper;
import ch.unibas.medizin.osce.client.managed.activity.AnamnesisCheckEditActivityWrapper.View;
import ch.unibas.medizin.osce.client.managed.request.AnamnesisCheckProxy;
import ch.unibas.medizin.osce.client.managed.request.AnamnesisChecksValueProxy;
import ch.unibas.medizin.osce.client.scaffold.place.ProxyEditView;
import ch.unibas.medizin.osce.client.scaffold.ui.*;
import ch.unibas.medizin.osce.shared.AnamnesisCheckTypes;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.requestfactory.client.RequestFactoryEditorDriver;
import com.google.gwt.requestfactory.shared.RequestFactory;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.LongBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.datepicker.client.DateBox;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public abstract class AnamnesisCheckMobileEditView_Roo_Gwt extends Composite implements View<AnamnesisCheckMobileEditView> {

    @UiField
    TextBox text;

    @UiField
    TextBox value;

    @UiField
    IntegerBox sort_order;

    @UiField(provided = true)
    ValueListBox<AnamnesisCheckTypes> type = new ValueListBox<AnamnesisCheckTypes>(new AbstractRenderer<ch.unibas.medizin.osce.shared.AnamnesisCheckTypes>() {

        public String render(ch.unibas.medizin.osce.shared.AnamnesisCheckTypes obj) {
            return obj == null ? "" : String.valueOf(obj);
        }
    });

    @UiField
    AnamnesisChecksValueSetEditor anamnesischecksvalues;

    @UiField(provided = true)
    ValueListBox<AnamnesisCheckProxy> title = new ValueListBox<AnamnesisCheckProxy>(ch.unibas.medizin.osce.client.managed.ui.AnamnesisCheckProxyRenderer.instance(), new com.google.gwt.requestfactory.ui.client.EntityProxyKeyProvider<ch.unibas.medizin.osce.client.managed.request.AnamnesisCheckProxy>());

    public void setTitlePickerValues(Collection<AnamnesisCheckProxy> values) {
        title.setAcceptableValues(values);
    }

    public void setAnamnesischecksvaluesPickerValues(Collection<AnamnesisChecksValueProxy> values) {
        anamnesischecksvalues.setAcceptableValues(values);
    }

    public void setTypePickerValues(Collection<AnamnesisCheckTypes> values) {
        type.setAcceptableValues(values);
    }
}
