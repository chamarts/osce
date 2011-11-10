// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.osce.client.managed.ui;

import ch.unibas.medizin.osce.client.managed.request.AnamnesisFormProxy;
import ch.unibas.medizin.osce.client.managed.request.ScarProxy;
import ch.unibas.medizin.osce.client.scaffold.place.AbstractProxyListView;
import ch.unibas.medizin.osce.shared.TraitTypes;
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

public abstract class ScarListView_Roo_Gwt extends AbstractProxyListView<ScarProxy> {

    @UiField
    CellTable<ScarProxy> table;

    protected Set<String> paths = new HashSet<String>();

    public void init() {
        paths.add("id");
        table.addColumn(new TextColumn<ScarProxy>() {

            Renderer<java.lang.Long> renderer = new AbstractRenderer<java.lang.Long>() {

                public String render(java.lang.Long obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(ScarProxy object) {
                return renderer.render(object.getId());
            }
        }, "Id");
        paths.add("version");
        table.addColumn(new TextColumn<ScarProxy>() {

            Renderer<java.lang.Integer> renderer = new AbstractRenderer<java.lang.Integer>() {

                public String render(java.lang.Integer obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(ScarProxy object) {
                return renderer.render(object.getVersion());
            }
        }, "Version");
        paths.add("bodypart");
        table.addColumn(new TextColumn<ScarProxy>() {

            Renderer<java.lang.String> renderer = new AbstractRenderer<java.lang.String>() {

                public String render(java.lang.String obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(ScarProxy object) {
                return renderer.render(object.getBodypart());
            }
        }, "Bodypart");
        paths.add("type");
        table.addColumn(new TextColumn<ScarProxy>() {

            Renderer<ch.unibas.medizin.osce.shared.TraitTypes> renderer = new AbstractRenderer<ch.unibas.medizin.osce.shared.TraitTypes>() {

                public String render(ch.unibas.medizin.osce.shared.TraitTypes obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(ScarProxy object) {
                return renderer.render(object.getType());
            }
        }, "Type");
        paths.add("anamnesisForms");
        table.addColumn(new TextColumn<ScarProxy>() {

            Renderer<java.util.Set> renderer = ch.unibas.medizin.osce.client.scaffold.place.CollectionRenderer.of(ch.unibas.medizin.osce.client.managed.ui.AnamnesisFormProxyRenderer.instance());

            @Override
            public String getValue(ScarProxy object) {
                return renderer.render(object.getAnamnesisForms());
            }
        }, "Anamnesis Forms");
    }
}
