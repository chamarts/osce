// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.osce.client.managed.ui;

import ch.unibas.medizin.osce.client.managed.request.AdministratorProxy;
import ch.unibas.medizin.osce.client.managed.request.TaskProxy;
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

public abstract class TaskListView_Roo_Gwt extends AbstractProxyListView<TaskProxy> {

    @UiField
    CellTable<TaskProxy> table;

    protected Set<String> paths = new HashSet<String>();

    public void init() {
        paths.add("id");
        table.addColumn(new TextColumn<TaskProxy>() {

            Renderer<java.lang.Long> renderer = new AbstractRenderer<java.lang.Long>() {

                public String render(java.lang.Long obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(TaskProxy object) {
                return renderer.render(object.getId());
            }
        }, "Id");
        paths.add("version");
        table.addColumn(new TextColumn<TaskProxy>() {

            Renderer<java.lang.Integer> renderer = new AbstractRenderer<java.lang.Integer>() {

                public String render(java.lang.Integer obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(TaskProxy object) {
                return renderer.render(object.getVersion());
            }
        }, "Version");
        paths.add("name");
        table.addColumn(new TextColumn<TaskProxy>() {

            Renderer<java.lang.String> renderer = new AbstractRenderer<java.lang.String>() {

                public String render(java.lang.String obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(TaskProxy object) {
                return renderer.render(object.getName());
            }
        }, "Name");
        paths.add("deadline");
        table.addColumn(new TextColumn<TaskProxy>() {

            Renderer<java.util.Date> renderer = new DateTimeFormatRenderer(DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_MEDIUM));

            @Override
            public String getValue(TaskProxy object) {
                return renderer.render(object.getDeadline());
            }
        }, "Deadline");
        paths.add("isDone");
        table.addColumn(new TextColumn<TaskProxy>() {

            Renderer<java.lang.Boolean> renderer = new AbstractRenderer<java.lang.Boolean>() {

                public String render(java.lang.Boolean obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(TaskProxy object) {
                return renderer.render(object.getIsDone());
            }
        }, "Is Done");
        paths.add("osce");
        table.addColumn(new TextColumn<TaskProxy>() {

            Renderer<ch.unibas.medizin.osce.client.managed.request.TaskProxy> renderer = ch.unibas.medizin.osce.client.managed.ui.TaskProxyRenderer.instance();

            @Override
            public String getValue(TaskProxy object) {
                return renderer.render(object.getOsce());
            }
        }, "Osce");
        paths.add("administrator");
        table.addColumn(new TextColumn<TaskProxy>() {

            Renderer<ch.unibas.medizin.osce.client.managed.request.AdministratorProxy> renderer = ch.unibas.medizin.osce.client.managed.ui.AdministratorProxyRenderer.instance();

            @Override
            public String getValue(TaskProxy object) {
                return renderer.render(object.getAdministrator());
            }
        }, "Administrator");
    }
}