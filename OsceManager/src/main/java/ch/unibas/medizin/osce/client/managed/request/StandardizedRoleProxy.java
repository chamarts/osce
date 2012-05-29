// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.medizin.osce.client.managed.request;

import ch.unibas.medizin.osce.shared.RoleTypes;
import ch.unibas.medizin.osce.shared.StudyYears;
import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.ProxyForName;
import java.util.Set;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;

@RooGwtMirroredFrom("ch.unibas.medizin.osce.domain.StandardizedRole")
@ProxyForName("ch.unibas.medizin.osce.domain.StandardizedRole")
public interface StandardizedRoleProxy extends EntityProxy {

    abstract Long getId();

    abstract void setId(Long id);

    abstract Integer getVersion();

    abstract void setVersion(Integer version);

    abstract String getShortName();

    abstract void setShortName(String shortName);

    abstract String getLongName();

    abstract void setLongName(String longName);

    abstract String getCaseDescription();

    abstract void setCaseDescription(String caseDescription);

    abstract String getRoleScript();

    abstract void setRoleScript(String roleScript);

    abstract RoleTypes getRoleType();

    abstract void setRoleType(RoleTypes roleType);

    abstract Boolean getActive();

    abstract void setActive(Boolean active);

    abstract RoleTopicProxy getRoleTopic();

    abstract void setRoleTopic(RoleTopicProxy roleTopic);

    abstract Set<ch.unibas.medizin.osce.client.managed.request.RoleParticipantProxy> getRoleParticipants();

    abstract void setRoleParticipants(Set<RoleParticipantProxy> roleParticipants);

    abstract ch.unibas.medizin.osce.client.managed.request.StandardizedRoleProxy getPreviousVersion();

    abstract void setPreviousVersion(ch.unibas.medizin.osce.client.managed.request.StandardizedRoleProxy previousVersion);

    abstract StudyYears getStudyYear();

    abstract void setStudyYear(StudyYears studyYear);

    abstract Integer getMainVersion();

    abstract void setMainVersion(Integer mainVersion);

    abstract Integer getSubVersion();

    abstract void setSubVersion(Integer subVersion);

    abstract Set<ch.unibas.medizin.osce.client.managed.request.KeywordProxy> getKeywords();

    abstract void setKeywords(Set<KeywordProxy> keywords);

    abstract Set<ch.unibas.medizin.osce.client.managed.request.AdvancedSearchCriteriaProxy> getAdvancedSearchCriteria();

    abstract void setAdvancedSearchCriteria(Set<AdvancedSearchCriteriaProxy> advancedSearchCriteria);

    abstract Set<ch.unibas.medizin.osce.client.managed.request.SimpleSearchCriteriaProxy> getSimpleSearchCriteria();

    abstract void setSimpleSearchCriteria(Set<SimpleSearchCriteriaProxy> simpleSearchCriteria);

    abstract CheckListProxy getCheckList();

    abstract void setCheckList(CheckListProxy checkList);
}
