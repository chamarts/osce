package ch.unibas.medizin.osce.shared.scaffold;

import java.util.List;


import ch.unibas.medizin.osce.client.managed.request.OsceProxy;
import ch.unibas.medizin.osce.client.managed.request.SemesterProxy;
import ch.unibas.medizin.osce.domain.Osce;
import ch.unibas.medizin.osce.shared.Sorting;

import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;

@SuppressWarnings("deprecation")
@Service(Osce.class)
public interface OsceRequestNonRoo extends RequestContext{

	abstract Request<List<OsceProxy>> findAllOsceBySemster(Long id);
	
	abstract Request<OsceProxy> findMaxOsce();
	
	public abstract Request<List<OsceProxy>> findAllOsceOnSemesterId(Long id);
	
	public abstract Request<Boolean> generateOsceScaffold(Long osceId);

}
