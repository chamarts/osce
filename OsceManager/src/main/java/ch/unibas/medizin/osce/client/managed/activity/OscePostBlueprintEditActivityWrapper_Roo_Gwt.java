// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.osce.client.managed.activity;

import ch.unibas.medizin.osce.client.managed.activity.OscePostBlueprintEditActivityWrapper.View;
import ch.unibas.medizin.osce.client.managed.request.ApplicationRequestFactory;
import ch.unibas.medizin.osce.client.managed.request.OscePostBlueprintProxy;
import ch.unibas.medizin.osce.client.managed.request.OscePostProxy;
import ch.unibas.medizin.osce.client.managed.request.OsceProxy;
import ch.unibas.medizin.osce.client.managed.request.RoleTopicProxy;
import ch.unibas.medizin.osce.client.managed.request.SpecialisationProxy;
import ch.unibas.medizin.osce.client.managed.ui.OscePostSetEditor;
import ch.unibas.medizin.osce.client.scaffold.activity.IsScaffoldMobileActivity;
import ch.unibas.medizin.osce.client.scaffold.place.ProxyEditView;
import ch.unibas.medizin.osce.client.scaffold.place.ProxyListPlace;
import ch.unibas.medizin.osce.client.scaffold.place.ProxyPlace;
import ch.unibas.medizin.osce.shared.PostType;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public abstract class OscePostBlueprintEditActivityWrapper_Roo_Gwt implements Activity, IsScaffoldMobileActivity {

    protected Activity wrapped;

    protected View<?> view;

    protected ApplicationRequestFactory requests;

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        view.setPostTypePickerValues(Arrays.asList(PostType.values()));
        view.setRoleTopicPickerValues(Collections.<RoleTopicProxy>emptyList());
        requests.roleTopicRequest().findRoleTopicEntries(0, 50).with(ch.unibas.medizin.osce.client.managed.ui.RoleTopicProxyRenderer.instance().getPaths()).fire(new Receiver<List<RoleTopicProxy>>() {

            public void onSuccess(List<RoleTopicProxy> response) {
                List<RoleTopicProxy> values = new ArrayList<RoleTopicProxy>();
                values.add(null);
                values.addAll(response);
                view.setRoleTopicPickerValues(values);
            }
        });
        view.setOscePickerValues(Collections.<OsceProxy>emptyList());
        requests.osceRequest().findOsceEntries(0, 50).with(ch.unibas.medizin.osce.client.managed.ui.OsceProxyRenderer.instance().getPaths()).fire(new Receiver<List<OsceProxy>>() {

            public void onSuccess(List<OsceProxy> response) {
                List<OsceProxy> values = new ArrayList<OsceProxy>();
                values.add(null);
                values.addAll(response);
                view.setOscePickerValues(values);
            }
        });
        view.setOscePostsPickerValues(Collections.<OscePostProxy>emptyList());
        requests.oscePostRequest().findOscePostEntries(0, 50).with(ch.unibas.medizin.osce.client.managed.ui.OscePostProxyRenderer.instance().getPaths()).fire(new Receiver<List<OscePostProxy>>() {

            public void onSuccess(List<OscePostProxy> response) {
                List<OscePostProxy> values = new ArrayList<OscePostProxy>();
                values.add(null);
                values.addAll(response);
                view.setOscePostsPickerValues(values);
            }
        });
        view.setSpecialisationPickerValues(Collections.<SpecialisationProxy>emptyList());
        requests.specialisationRequest().findSpecialisationEntries(0, 50).with(ch.unibas.medizin.osce.client.managed.ui.SpecialisationProxyRenderer.instance().getPaths()).fire(new Receiver<List<SpecialisationProxy>>() {

            public void onSuccess(List<SpecialisationProxy> response) {
                List<SpecialisationProxy> values = new ArrayList<SpecialisationProxy>();
                values.add(null);
                values.addAll(response);
                view.setSpecialisationPickerValues(values);
            }
        });
        wrapped.start(display, eventBus);
    }

    public interface View_Roo_Gwt<V extends ch.unibas.medizin.osce.client.scaffold.place.ProxyEditView<ch.unibas.medizin.osce.client.managed.request.OscePostBlueprintProxy, V>> extends ProxyEditView<OscePostBlueprintProxy, V> {

        void setPostTypePickerValues(Collection<PostType> values);

        void setRoleTopicPickerValues(Collection<RoleTopicProxy> values);

        void setOscePickerValues(Collection<OsceProxy> values);

        void setOscePostsPickerValues(Collection<OscePostProxy> values);

        void setSpecialisationPickerValues(Collection<SpecialisationProxy> values);
    }
}
