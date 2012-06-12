// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.osce.client.managed.ui;

import ch.unibas.medizin.osce.client.managed.request.RoleTableItemProxy;
import ch.unibas.medizin.osce.client.managed.request.RoleTableItemValueProxy;
import ch.unibas.medizin.osce.client.managed.request.StandardizedRoleProxy;
import ch.unibas.medizin.osce.client.scaffold.place.AbstractProxyListView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.text.client.DateTimeFormatRenderer;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import java.util.HashSet;
import java.util.Set;

public abstract class RoleTableItemValueListView_Roo_Gwt extends AbstractProxyListView<RoleTableItemValueProxy> {

    @UiField
    CellTable<RoleTableItemValueProxy> table;

    protected Set<String> paths = new HashSet<String>();

    public void init() {
        paths.add("id");
        table.addColumn(new TextColumn<RoleTableItemValueProxy>() {

            Renderer<java.lang.Integer> renderer = new AbstractRenderer<java.lang.Integer>() {

                public String render(java.lang.Integer obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(RoleTableItemValueProxy object) {
                return renderer.render(object.getId());
            }
        }, "Id");
        paths.add("version");
        table.addColumn(new TextColumn<RoleTableItemValueProxy>() {

            Renderer<java.lang.Integer> renderer = new AbstractRenderer<java.lang.Integer>() {

                public String render(java.lang.Integer obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(RoleTableItemValueProxy object) {
                return renderer.render(object.getVersion());
            }
        }, "Version");
        paths.add("value");
        table.addColumn(new TextColumn<RoleTableItemValueProxy>() {

            Renderer<java.lang.String> renderer = new AbstractRenderer<java.lang.String>() {

                public String render(java.lang.String obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(RoleTableItemValueProxy object) {
                return renderer.render(object.getValue());
            }
        }, "Value");
        paths.add("roleTableItem");
        table.addColumn(new TextColumn<RoleTableItemValueProxy>() {

            Renderer<ch.unibas.medizin.osce.client.managed.request.RoleTableItemProxy> renderer = ch.unibas.medizin.osce.client.managed.ui.RoleTableItemProxyRenderer.instance();

            @Override
            public String getValue(RoleTableItemValueProxy object) {
                return renderer.render(object.getRoleTableItem());
            }
        }, "Role Table Item");
        paths.add("standardizedRole");
        table.addColumn(new TextColumn<RoleTableItemValueProxy>() {

            Renderer<ch.unibas.medizin.osce.client.managed.request.StandardizedRoleProxy> renderer = ch.unibas.medizin.osce.client.managed.ui.StandardizedRoleProxyRenderer.instance();

            @Override
            public String getValue(RoleTableItemValueProxy object) {
                return renderer.render(object.getStandardizedRole());
            }
        }, "Standardized Role");
    }
}
