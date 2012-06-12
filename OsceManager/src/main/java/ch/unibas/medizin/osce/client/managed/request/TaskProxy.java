// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.osce.client.managed.request;

import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.ProxyForName;
import java.util.Date;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;

@RooGwtMirroredFrom("ch.unibas.medizin.osce.domain.Task")
@ProxyForName("ch.unibas.medizin.osce.domain.Task")
public interface TaskProxy extends EntityProxy {

    abstract Long getId();

    abstract void setId(Long id);

    abstract Integer getVersion();

    abstract void setVersion(Integer version);

    abstract String getName();

    abstract void setName(String name);

    abstract Date getDeadline();

    abstract void setDeadline(Date deadline);

    abstract Boolean getIsDone();

    abstract void setIsDone(Boolean isDone);

    abstract OsceProxy getOsce();

    abstract void setOsce(OsceProxy osce);

    abstract AdministratorProxy getAdministrator();

    abstract void setAdministrator(AdministratorProxy administrator);
}
