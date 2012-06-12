// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.unibas.medizin.osce.domain;

import ch.unibas.medizin.osce.domain.Administrator;
import ch.unibas.medizin.osce.domain.AdministratorDataOnDemand;
import ch.unibas.medizin.osce.domain.Osce;
import ch.unibas.medizin.osce.domain.OsceDataOnDemand;
import ch.unibas.medizin.osce.domain.Task;
import java.lang.Boolean;
import java.lang.String;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect TaskDataOnDemand_Roo_DataOnDemand {
    
    declare @type: TaskDataOnDemand: @Component;
    
    private Random TaskDataOnDemand.rnd = new SecureRandom();
    
    private List<Task> TaskDataOnDemand.data;
    
    @Autowired
    private AdministratorDataOnDemand TaskDataOnDemand.administratorDataOnDemand;
    
    @Autowired
    private OsceDataOnDemand TaskDataOnDemand.osceDataOnDemand;
    
    public Task TaskDataOnDemand.getNewTransientTask(int index) {
        Task obj = new Task();
        setAdministrator(obj, index);
        setDeadline(obj, index);
        setIsDone(obj, index);
        setName(obj, index);
        setOsce(obj, index);
        return obj;
    }
    
    public void TaskDataOnDemand.setAdministrator(Task obj, int index) {
        Administrator administrator = administratorDataOnDemand.getRandomAdministrator();
        obj.setAdministrator(administrator);
    }
    
    public void TaskDataOnDemand.setDeadline(Task obj, int index) {
        Date deadline = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setDeadline(deadline);
    }
    
    public void TaskDataOnDemand.setIsDone(Task obj, int index) {
        Boolean isDone = Boolean.TRUE;
        obj.setIsDone(isDone);
    }
    
    public void TaskDataOnDemand.setName(Task obj, int index) {
        String name = "name_" + index;
        if (name.length() > 255) {
            name = name.substring(0, 255);
        }
        obj.setName(name);
    }
    
    public void TaskDataOnDemand.setOsce(Task obj, int index) {
        Osce osce = osceDataOnDemand.getRandomOsce();
        obj.setOsce(osce);
    }
    
    public Task TaskDataOnDemand.getSpecificTask(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size() - 1)) index = data.size() - 1;
        Task obj = data.get(index);
        return Task.findTask(obj.getId());
    }
    
    public Task TaskDataOnDemand.getRandomTask() {
        init();
        Task obj = data.get(rnd.nextInt(data.size()));
        return Task.findTask(obj.getId());
    }
    
    public boolean TaskDataOnDemand.modifyTask(Task obj) {
        return false;
    }
    
    public void TaskDataOnDemand.init() {
        data = Task.findTaskEntries(0, 10);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'Task' illegally returned null");
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<ch.unibas.medizin.osce.domain.Task>();
        for (int i = 0; i < 10; i++) {
            Task obj = getNewTransientTask(i);
            try {
                obj.persist();
            } catch (ConstraintViolationException e) {
                StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> it = e.getConstraintViolations().iterator(); it.hasNext();) {
                    ConstraintViolation<?> cv = it.next();
                    msg.append("[").append(cv.getConstraintDescriptor()).append(":").append(cv.getMessage()).append("=").append(cv.getInvalidValue()).append("]");
                }
                throw new RuntimeException(msg.toString(), e);
            }
            obj.flush();
            data.add(obj);
        }
    }
    
}
