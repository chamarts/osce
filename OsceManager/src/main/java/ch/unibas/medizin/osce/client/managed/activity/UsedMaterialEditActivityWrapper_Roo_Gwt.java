// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.osce.client.managed.activity;

import ch.unibas.medizin.osce.client.managed.activity.UsedMaterialEditActivityWrapper.View;
import ch.unibas.medizin.osce.client.managed.request.ApplicationRequestFactory;
import ch.unibas.medizin.osce.client.managed.request.MaterialListProxy;
import ch.unibas.medizin.osce.client.managed.request.StandardizedRoleProxy;
import ch.unibas.medizin.osce.client.managed.request.UsedMaterialProxy;
import ch.unibas.medizin.osce.client.scaffold.activity.IsScaffoldMobileActivity;
import ch.unibas.medizin.osce.client.scaffold.place.ProxyEditView;
import ch.unibas.medizin.osce.client.scaffold.place.ProxyListPlace;
import ch.unibas.medizin.osce.client.scaffold.place.ProxyPlace;
import ch.unibas.medizin.osce.shared.MaterialUsedFromTypes;
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

public abstract class UsedMaterialEditActivityWrapper_Roo_Gwt implements Activity, IsScaffoldMobileActivity {

    protected Activity wrapped;

    protected View<?> view;

    protected ApplicationRequestFactory requests;

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        view.setUsed_fromPickerValues(Arrays.asList(MaterialUsedFromTypes.values()));
        view.setStandardizedRolePickerValues(Collections.<StandardizedRoleProxy>emptyList());
        requests.standardizedRoleRequest().findStandardizedRoleEntries(0, 50).with(ch.unibas.medizin.osce.client.managed.ui.StandardizedRoleProxyRenderer.instance().getPaths()).fire(new Receiver<List<StandardizedRoleProxy>>() {

            public void onSuccess(List<StandardizedRoleProxy> response) {
                List<StandardizedRoleProxy> values = new ArrayList<StandardizedRoleProxy>();
                values.add(null);
                values.addAll(response);
                view.setStandardizedRolePickerValues(values);
            }
        });
        view.setMaterialListPickerValues(Collections.<MaterialListProxy>emptyList());
        requests.materialListRequest().findMaterialListEntries(0, 50).with(ch.unibas.medizin.osce.client.managed.ui.MaterialListProxyRenderer.instance().getPaths()).fire(new Receiver<List<MaterialListProxy>>() {

            public void onSuccess(List<MaterialListProxy> response) {
                List<MaterialListProxy> values = new ArrayList<MaterialListProxy>();
                values.add(null);
                values.addAll(response);
                view.setMaterialListPickerValues(values);
            }
        });
        wrapped.start(display, eventBus);
    }

    public interface View_Roo_Gwt<V extends ch.unibas.medizin.osce.client.scaffold.place.ProxyEditView<ch.unibas.medizin.osce.client.managed.request.UsedMaterialProxy, V>> extends ProxyEditView<UsedMaterialProxy, V> {

        void setUsed_fromPickerValues(Collection<MaterialUsedFromTypes> values);

        void setStandardizedRolePickerValues(Collection<StandardizedRoleProxy> values);

        void setMaterialListPickerValues(Collection<MaterialListProxy> values);
    }
}
