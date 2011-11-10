// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.osce.client.managed.ui;

import ch.unibas.medizin.osce.client.managed.request.AnamnesisFormProxy;
import ch.unibas.medizin.osce.client.managed.request.BankaccountProxy;
import ch.unibas.medizin.osce.client.managed.request.DescriptionProxy;
import ch.unibas.medizin.osce.client.managed.request.LangSkillProxy;
import ch.unibas.medizin.osce.client.managed.request.NationalityProxy;
import ch.unibas.medizin.osce.client.managed.request.ProfessionProxy;
import ch.unibas.medizin.osce.client.managed.request.StandardizedPatientProxy;
import ch.unibas.medizin.osce.client.scaffold.place.AbstractProxyListView;
import ch.unibas.medizin.osce.shared.Gender;
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

public abstract class StandardizedPatientListView_Roo_Gwt extends AbstractProxyListView<StandardizedPatientProxy> {

    @UiField
    CellTable<StandardizedPatientProxy> table;

    protected Set<String> paths = new HashSet<String>();

    public void init() {
        paths.add("id");
        table.addColumn(new TextColumn<StandardizedPatientProxy>() {

            Renderer<java.lang.Long> renderer = new AbstractRenderer<java.lang.Long>() {

                public String render(java.lang.Long obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(StandardizedPatientProxy object) {
                return renderer.render(object.getId());
            }
        }, "Id");
        paths.add("version");
        table.addColumn(new TextColumn<StandardizedPatientProxy>() {

            Renderer<java.lang.Integer> renderer = new AbstractRenderer<java.lang.Integer>() {

                public String render(java.lang.Integer obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(StandardizedPatientProxy object) {
                return renderer.render(object.getVersion());
            }
        }, "Version");
        paths.add("gender");
        table.addColumn(new TextColumn<StandardizedPatientProxy>() {

            Renderer<ch.unibas.medizin.osce.shared.Gender> renderer = new AbstractRenderer<ch.unibas.medizin.osce.shared.Gender>() {

                public String render(ch.unibas.medizin.osce.shared.Gender obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(StandardizedPatientProxy object) {
                return renderer.render(object.getGender());
            }
        }, "Gender");
        paths.add("name");
        table.addColumn(new TextColumn<StandardizedPatientProxy>() {

            Renderer<java.lang.String> renderer = new AbstractRenderer<java.lang.String>() {

                public String render(java.lang.String obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(StandardizedPatientProxy object) {
                return renderer.render(object.getName());
            }
        }, "Name");
        paths.add("preName");
        table.addColumn(new TextColumn<StandardizedPatientProxy>() {

            Renderer<java.lang.String> renderer = new AbstractRenderer<java.lang.String>() {

                public String render(java.lang.String obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(StandardizedPatientProxy object) {
                return renderer.render(object.getPreName());
            }
        }, "Pre Name");
        paths.add("street");
        table.addColumn(new TextColumn<StandardizedPatientProxy>() {

            Renderer<java.lang.String> renderer = new AbstractRenderer<java.lang.String>() {

                public String render(java.lang.String obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(StandardizedPatientProxy object) {
                return renderer.render(object.getStreet());
            }
        }, "Street");
        paths.add("city");
        table.addColumn(new TextColumn<StandardizedPatientProxy>() {

            Renderer<java.lang.String> renderer = new AbstractRenderer<java.lang.String>() {

                public String render(java.lang.String obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(StandardizedPatientProxy object) {
                return renderer.render(object.getCity());
            }
        }, "City");
        paths.add("postalCode");
        table.addColumn(new TextColumn<StandardizedPatientProxy>() {

            Renderer<java.lang.Integer> renderer = new AbstractRenderer<java.lang.Integer>() {

                public String render(java.lang.Integer obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(StandardizedPatientProxy object) {
                return renderer.render(object.getPostalCode());
            }
        }, "Postal Code");
        paths.add("telephone");
        table.addColumn(new TextColumn<StandardizedPatientProxy>() {

            Renderer<java.lang.String> renderer = new AbstractRenderer<java.lang.String>() {

                public String render(java.lang.String obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(StandardizedPatientProxy object) {
                return renderer.render(object.getTelephone());
            }
        }, "Telephone");
        paths.add("telephone2");
        table.addColumn(new TextColumn<StandardizedPatientProxy>() {

            Renderer<java.lang.String> renderer = new AbstractRenderer<java.lang.String>() {

                public String render(java.lang.String obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(StandardizedPatientProxy object) {
                return renderer.render(object.getTelephone2());
            }
        }, "Telephone2");
        paths.add("mobile");
        table.addColumn(new TextColumn<StandardizedPatientProxy>() {

            Renderer<java.lang.String> renderer = new AbstractRenderer<java.lang.String>() {

                public String render(java.lang.String obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(StandardizedPatientProxy object) {
                return renderer.render(object.getMobile());
            }
        }, "Mobile");
        paths.add("birthday");
        table.addColumn(new TextColumn<StandardizedPatientProxy>() {

            Renderer<java.util.Date> renderer = new DateTimeFormatRenderer(DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_MEDIUM));

            @Override
            public String getValue(StandardizedPatientProxy object) {
                return renderer.render(object.getBirthday());
            }
        }, "Birthday");
        paths.add("email");
        table.addColumn(new TextColumn<StandardizedPatientProxy>() {

            Renderer<java.lang.String> renderer = new AbstractRenderer<java.lang.String>() {

                public String render(java.lang.String obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(StandardizedPatientProxy object) {
                return renderer.render(object.getEmail());
            }
        }, "Email");
        paths.add("descriptions");
        table.addColumn(new TextColumn<StandardizedPatientProxy>() {

            Renderer<ch.unibas.medizin.osce.client.managed.request.DescriptionProxy> renderer = ch.unibas.medizin.osce.client.managed.ui.DescriptionProxyRenderer.instance();

            @Override
            public String getValue(StandardizedPatientProxy object) {
                return renderer.render(object.getDescriptions());
            }
        }, "Descriptions");
        paths.add("bankAccount");
        table.addColumn(new TextColumn<StandardizedPatientProxy>() {

            Renderer<ch.unibas.medizin.osce.client.managed.request.BankaccountProxy> renderer = ch.unibas.medizin.osce.client.managed.ui.BankaccountProxyRenderer.instance();

            @Override
            public String getValue(StandardizedPatientProxy object) {
                return renderer.render(object.getBankAccount());
            }
        }, "Bank Account");
        paths.add("nationality");
        table.addColumn(new TextColumn<StandardizedPatientProxy>() {

            Renderer<ch.unibas.medizin.osce.client.managed.request.NationalityProxy> renderer = ch.unibas.medizin.osce.client.managed.ui.NationalityProxyRenderer.instance();

            @Override
            public String getValue(StandardizedPatientProxy object) {
                return renderer.render(object.getNationality());
            }
        }, "Nationality");
        paths.add("profession");
        table.addColumn(new TextColumn<StandardizedPatientProxy>() {

            Renderer<ch.unibas.medizin.osce.client.managed.request.ProfessionProxy> renderer = ch.unibas.medizin.osce.client.managed.ui.ProfessionProxyRenderer.instance();

            @Override
            public String getValue(StandardizedPatientProxy object) {
                return renderer.render(object.getProfession());
            }
        }, "Profession");
        paths.add("anamnesisForm");
        table.addColumn(new TextColumn<StandardizedPatientProxy>() {

            Renderer<ch.unibas.medizin.osce.client.managed.request.AnamnesisFormProxy> renderer = ch.unibas.medizin.osce.client.managed.ui.AnamnesisFormProxyRenderer.instance();

            @Override
            public String getValue(StandardizedPatientProxy object) {
                return renderer.render(object.getAnamnesisForm());
            }
        }, "Anamnesis Form");
        paths.add("langskills");
        table.addColumn(new TextColumn<StandardizedPatientProxy>() {

            Renderer<java.util.Set> renderer = ch.unibas.medizin.osce.client.scaffold.place.CollectionRenderer.of(ch.unibas.medizin.osce.client.managed.ui.LangSkillProxyRenderer.instance());

            @Override
            public String getValue(StandardizedPatientProxy object) {
                return renderer.render(object.getLangskills());
            }
        }, "Langskills");
    }
}
