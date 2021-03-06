package ch.unibas.medizin.osce.client.a_nonroo.client.ui.roleAssignment;

import ch.unibas.medizin.osce.client.managed.request.PatientInRoleProxy;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;

public interface PatientInRoleSubView extends IsWidget{
	
	interface Delegate {
		 public void deletePatientInRole(PatientInRoleSubViewImpl view);
	}
	
	 void setDelegate(Delegate delegate);
	 
	 public Label getPatientInRoleLbl() ;
	 
	 public PatientInRoleProxy getPatientInRoleProxy();
	 
	 public void setPatientInRoleProxy(PatientInRoleProxy patientInRoleProxy);
	 
	 public RoleSubView getRoleSubView() ;
	 
	 public void setRoleSubView(RoleSubView roleSubView);
}
