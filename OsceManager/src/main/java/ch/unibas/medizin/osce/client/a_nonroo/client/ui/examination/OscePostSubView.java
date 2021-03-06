package ch.unibas.medizin.osce.client.a_nonroo.client.ui.examination;

import ch.unibas.medizin.osce.client.managed.request.OscePostProxy;
import ch.unibas.medizin.osce.client.style.widgets.IconButton;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;

public interface OscePostSubView extends IsWidget{
	
	
	interface Delegate {
		void findStandardizedRoles(OscePostSubView view);
		
		public void specializationEditClicked(OscePostSubViewImpl oscePostSubViewImpl);

		public void roleEditClicked(OscePostSubViewImpl oscePostSubViewImpl);

		public void saveSpecialisation(OscePostSubViewImpl oscePostSubViewImpl);

		public void saveRoleTopic(OscePostSubViewImpl oscePostSubViewImpl);
	}
	
	 void setDelegate(Delegate delegate);
	 
	 public void enableDisableforGeneratedStatus();
	 
	 public Label getSpecializationLbl();
	 
	 public Label getPostNameLbl() ;
	 
	 public Label getRoleTopicLbl();
	 
	 public Label getRoomLbl() ;
	 
	 public IconButton getSpecializationedit();
	 public Label getStandardizedRoleLbl() ;
	 public OscePostProxy getOscePostProxy();
	 public void setOscePostProxy(OscePostProxy oscePostProxy);
	 
	 
}
