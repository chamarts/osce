// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.osce.client.managed.ui;

import ch.unibas.medizin.osce.client.managed.request.CourseProxy;
import ch.unibas.medizin.osce.client.managed.request.OsceDayProxy;
import ch.unibas.medizin.osce.client.managed.request.OscePostProxy;
import ch.unibas.medizin.osce.client.managed.request.OsceSequenceProxy;
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
import java.util.Set;

public abstract class OsceSequenceMobileDetailsView_Roo_Gwt extends Composite implements ProxyDetailsView<OsceSequenceProxy> {

    @UiField
    Element id;

    @UiField
    Element version;

    @UiField
    Element numberRotation;

    @UiField
    Element label;

    @UiField
    Element osceDay;

    @UiField
    Element courses;

    @UiField
    Element oscePosts;

    OsceSequenceProxy proxy;

    public void setValue(OsceSequenceProxy proxy) {
        this.proxy = proxy;
        id.setInnerText(proxy.getId() == null ? "" : String.valueOf(proxy.getId()));
        version.setInnerText(proxy.getVersion() == null ? "" : String.valueOf(proxy.getVersion()));
        numberRotation.setInnerText(proxy.getNumberRotation() == null ? "" : String.valueOf(proxy.getNumberRotation()));
        label.setInnerText(proxy.getLabel() == null ? "" : String.valueOf(proxy.getLabel()));
        osceDay.setInnerText(proxy.getOsceDay() == null ? "" : ch.unibas.medizin.osce.client.managed.ui.OsceDayProxyRenderer.instance().render(proxy.getOsceDay()));
        courses.setInnerText(proxy.getCourses() == null ? "" : ch.unibas.medizin.osce.client.scaffold.place.CollectionRenderer.of(ch.unibas.medizin.osce.client.managed.ui.CourseProxyRenderer.instance()).render(proxy.getCourses()));
        oscePosts.setInnerText(proxy.getOscePosts() == null ? "" : ch.unibas.medizin.osce.client.scaffold.place.CollectionRenderer.of(ch.unibas.medizin.osce.client.managed.ui.OscePostProxyRenderer.instance()).render(proxy.getOscePosts()));
    }
}
