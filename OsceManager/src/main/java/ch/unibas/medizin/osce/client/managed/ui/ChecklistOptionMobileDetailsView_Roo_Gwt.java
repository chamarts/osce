// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.osce.client.managed.ui;

import ch.unibas.medizin.osce.client.managed.request.ChecklistOptionProxy;
import ch.unibas.medizin.osce.client.managed.request.ChecklistQuestionProxy;
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

public abstract class ChecklistOptionMobileDetailsView_Roo_Gwt extends Composite implements ProxyDetailsView<ChecklistOptionProxy> {

    @UiField
    Element id;

    @UiField
    Element version;

    @UiField
    Element optionName;

    @UiField
    Element name;

    @UiField
    Element checklistQuestion;

    @UiField
    Element value;

    ChecklistOptionProxy proxy;

    public void setValue(ChecklistOptionProxy proxy) {
        this.proxy = proxy;
        id.setInnerText(proxy.getId() == null ? "" : String.valueOf(proxy.getId()));
        version.setInnerText(proxy.getVersion() == null ? "" : String.valueOf(proxy.getVersion()));
        optionName.setInnerText(proxy.getOptionName() == null ? "" : String.valueOf(proxy.getOptionName()));
        name.setInnerText(proxy.getName() == null ? "" : String.valueOf(proxy.getName()));
        checklistQuestion.setInnerText(proxy.getChecklistQuestion() == null ? "" : ch.unibas.medizin.osce.client.managed.ui.ChecklistQuestionProxyRenderer.instance().render(proxy.getChecklistQuestion()));
        value.setInnerText(proxy.getValue() == null ? "" : String.valueOf(proxy.getValue()));
    }
}