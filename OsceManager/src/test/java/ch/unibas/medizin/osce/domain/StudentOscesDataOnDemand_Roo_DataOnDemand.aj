// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.unibas.medizin.osce.domain;

import ch.unibas.medizin.osce.domain.Osce;
import ch.unibas.medizin.osce.domain.OsceDataOnDemand;
import ch.unibas.medizin.osce.domain.Student;
import ch.unibas.medizin.osce.domain.StudentDataOnDemand;
import ch.unibas.medizin.osce.domain.StudentOsces;
import java.lang.Boolean;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect StudentOscesDataOnDemand_Roo_DataOnDemand {
    
    declare @type: StudentOscesDataOnDemand: @Component;
    
    private Random StudentOscesDataOnDemand.rnd = new SecureRandom();
    
    private List<StudentOsces> StudentOscesDataOnDemand.data;
    
    @Autowired
    private OsceDataOnDemand StudentOscesDataOnDemand.osceDataOnDemand;
    
    @Autowired
    private StudentDataOnDemand StudentOscesDataOnDemand.studentDataOnDemand;
    
    public StudentOsces StudentOscesDataOnDemand.getNewTransientStudentOsces(int index) {
        StudentOsces obj = new StudentOsces();
        setIsEnrolled(obj, index);
        setOsce(obj, index);
        setStudent(obj, index);
        return obj;
    }
    
    public void StudentOscesDataOnDemand.setIsEnrolled(StudentOsces obj, int index) {
        Boolean isEnrolled = Boolean.TRUE;
        obj.setIsEnrolled(isEnrolled);
    }
    
    public void StudentOscesDataOnDemand.setOsce(StudentOsces obj, int index) {
        Osce osce = osceDataOnDemand.getRandomOsce();
        obj.setOsce(osce);
    }
    
    public void StudentOscesDataOnDemand.setStudent(StudentOsces obj, int index) {
        Student student = studentDataOnDemand.getRandomStudent();
        obj.setStudent(student);
    }
    
    public StudentOsces StudentOscesDataOnDemand.getSpecificStudentOsces(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size() - 1)) index = data.size() - 1;
        StudentOsces obj = data.get(index);
        return StudentOsces.findStudentOsces(obj.getId());
    }
    
    public StudentOsces StudentOscesDataOnDemand.getRandomStudentOsces() {
        init();
        StudentOsces obj = data.get(rnd.nextInt(data.size()));
        return StudentOsces.findStudentOsces(obj.getId());
    }
    
    public boolean StudentOscesDataOnDemand.modifyStudentOsces(StudentOsces obj) {
        return false;
    }
    
    public void StudentOscesDataOnDemand.init() {
        data = StudentOsces.findStudentOscesEntries(0, 10);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'StudentOsces' illegally returned null");
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<ch.unibas.medizin.osce.domain.StudentOsces>();
        for (int i = 0; i < 10; i++) {
            StudentOsces obj = getNewTransientStudentOsces(i);
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