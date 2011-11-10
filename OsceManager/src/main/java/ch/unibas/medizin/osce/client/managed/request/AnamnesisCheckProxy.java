// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.osce.client.managed.request;

import ch.unibas.medizin.osce.shared.AnamnesisCheckTypes;
import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.ProxyForName;
import java.util.Set;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;

@RooGwtMirroredFrom("ch.unibas.medizin.osce.domain.AnamnesisCheck")
@ProxyForName("ch.unibas.medizin.osce.domain.AnamnesisCheck")
public interface AnamnesisCheckProxy extends EntityProxy {

    abstract Long getId();

    abstract void setId(Long id);

    abstract Integer getVersion();

    abstract void setVersion(Integer version);

    abstract String getText();

    abstract void setText(String text);

    abstract String getValue();

    abstract void setValue(String value);

    abstract Integer getSort_order();

    abstract void setSort_order(Integer sort_order);

    abstract AnamnesisCheckTypes getType();

    abstract void setType(AnamnesisCheckTypes type);

    abstract Set<ch.unibas.medizin.osce.client.managed.request.AnamnesisChecksValueProxy> getAnamnesischecksvalues();

    abstract void setAnamnesischecksvalues(Set<AnamnesisChecksValueProxy> anamnesischecksvalues);
}
