// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.osce.client.managed.request;

import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.ProxyForName;
import java.util.List;
import java.util.Set;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;

@RooGwtMirroredFrom("ch.unibas.medizin.osce.domain.OsceSequence")
@ProxyForName("ch.unibas.medizin.osce.domain.OsceSequence")
public interface OsceSequenceProxy extends EntityProxy {

    abstract Long getId();

    abstract void setId(Long id);

    abstract Integer getVersion();

    abstract void setVersion(Integer version);

    abstract Integer getNumberRotation();

    abstract void setNumberRotation(Integer numberRotation);

    abstract String getLabel();

    abstract void setLabel(String label);

    abstract OsceDayProxy getOsceDay();

    abstract void setOsceDay(OsceDayProxy osceDay);

    abstract Set<ch.unibas.medizin.osce.client.managed.request.CourseProxy> getCourses();

    abstract void setCourses(Set<CourseProxy> courses);

    abstract List<ch.unibas.medizin.osce.client.managed.request.OscePostProxy> getOscePosts();

    abstract void setOscePosts(List<OscePostProxy> oscePosts);
}
