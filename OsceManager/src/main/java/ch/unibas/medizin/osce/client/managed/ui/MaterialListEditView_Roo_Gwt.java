// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.osce.client.managed.ui;

import ch.unibas.medizin.osce.client.managed.activity.MaterialListEditActivityWrapper;
import ch.unibas.medizin.osce.client.managed.activity.MaterialListEditActivityWrapper.View;
import ch.unibas.medizin.osce.client.managed.request.MaterialListProxy;
import ch.unibas.medizin.osce.client.managed.request.UsedMaterialProxy;
import ch.unibas.medizin.osce.client.scaffold.place.ProxyEditView;
import ch.unibas.medizin.osce.client.scaffold.ui.*;
import ch.unibas.medizin.osce.shared.MaterialType;
import ch.unibas.medizin.osce.shared.PriceType;
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

public abstract class MaterialListEditView_Roo_Gwt extends Composite implements View<MaterialListEditView> {

    @UiField
    TextBox name;

    @UiField(provided = true)
    ValueListBox<MaterialType> type = new ValueListBox<MaterialType>(new AbstractRenderer<ch.unibas.medizin.osce.shared.MaterialType>() {

        public String render(ch.unibas.medizin.osce.shared.MaterialType obj) {
            return obj == null ? "" : String.valueOf(obj);
        }
    });

    @UiField
    IntegerBox price;

    @UiField(provided = true)
    ValueListBox<PriceType> priceType = new ValueListBox<PriceType>(new AbstractRenderer<ch.unibas.medizin.osce.shared.PriceType>() {

        public String render(ch.unibas.medizin.osce.shared.PriceType obj) {
            return obj == null ? "" : String.valueOf(obj);
        }
    });

    @UiField
    UsedMaterialSetEditor usedMaterials;

    public void setPriceTypePickerValues(Collection<PriceType> values) {
        priceType.setAcceptableValues(values);
    }

    public void setUsedMaterialsPickerValues(Collection<UsedMaterialProxy> values) {
        usedMaterials.setAcceptableValues(values);
    }

    public void setTypePickerValues(Collection<MaterialType> values) {
        type.setAcceptableValues(values);
    }
}