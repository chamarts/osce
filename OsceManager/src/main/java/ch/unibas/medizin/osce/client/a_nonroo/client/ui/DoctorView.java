package ch.unibas.medizin.osce.client.a_nonroo.client.ui;

import ch.unibas.medizin.osce.client.managed.request.DoctorProxy;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimplePanel;

public interface DoctorView  extends IsWidget{
	
    public interface Presenter {
        void goTo(Place place);
    }
	/**
	 * Implemented by the owner of the view.
	 */
	interface Delegate {
		void newClicked();
		
		void performSearch(String q);
		
		void changeFilterTitleShown(String selectedTitle);
	}

    CellTable<DoctorProxy> getTable();
    String[] getPaths();
    
    void setDelegate(Delegate delegate);
    
	SimplePanel getDetailsPanel();
    void setPresenter(Presenter systemStartActivity);
    
    //Module : 6
    ListBox getFilterTitle();
}
