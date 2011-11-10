// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.unibas.medizin.osce.domain;

import ch.unibas.medizin.osce.domain.AnamnesisCheck;
import ch.unibas.medizin.osce.domain.AnamnesisCheckDataOnDemand;
import ch.unibas.medizin.osce.domain.AnamnesisChecksValue;
import ch.unibas.medizin.osce.domain.AnamnesisForm;
import ch.unibas.medizin.osce.domain.AnamnesisFormDataOnDemand;
import java.lang.Boolean;
import java.lang.String;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect AnamnesisChecksValueDataOnDemand_Roo_DataOnDemand {
    
    declare @type: AnamnesisChecksValueDataOnDemand: @Component;
    
    private Random AnamnesisChecksValueDataOnDemand.rnd = new SecureRandom();
    
    private List<AnamnesisChecksValue> AnamnesisChecksValueDataOnDemand.data;
    
    @Autowired
    private AnamnesisCheckDataOnDemand AnamnesisChecksValueDataOnDemand.anamnesisCheckDataOnDemand;
    
    @Autowired
    private AnamnesisFormDataOnDemand AnamnesisChecksValueDataOnDemand.anamnesisFormDataOnDemand;
    
    public AnamnesisChecksValue AnamnesisChecksValueDataOnDemand.getNewTransientAnamnesisChecksValue(int index) {
        AnamnesisChecksValue obj = new AnamnesisChecksValue();
        setAnamnesisChecksValue(obj, index);
        setAnamnesischeck(obj, index);
        setAnamnesisform(obj, index);
        setComment(obj, index);
        setTruth(obj, index);
        return obj;
    }
    
    public void AnamnesisChecksValueDataOnDemand.setAnamnesisChecksValue(AnamnesisChecksValue obj, int index) {
        String anamnesisChecksValue = "anamnesisChecksValue_" + index;
        if (anamnesisChecksValue.length() > 255) {
            anamnesisChecksValue = anamnesisChecksValue.substring(0, 255);
        }
        obj.setAnamnesisChecksValue(anamnesisChecksValue);
    }
    
    public void AnamnesisChecksValueDataOnDemand.setAnamnesischeck(AnamnesisChecksValue obj, int index) {
        AnamnesisCheck anamnesischeck = anamnesisCheckDataOnDemand.getRandomAnamnesisCheck();
        obj.setAnamnesischeck(anamnesischeck);
    }
    
    public void AnamnesisChecksValueDataOnDemand.setAnamnesisform(AnamnesisChecksValue obj, int index) {
        AnamnesisForm anamnesisform = anamnesisFormDataOnDemand.getRandomAnamnesisForm();
        obj.setAnamnesisform(anamnesisform);
    }
    
    public void AnamnesisChecksValueDataOnDemand.setComment(AnamnesisChecksValue obj, int index) {
        String comment = "comment_" + index;
        if (comment.length() > 255) {
            comment = comment.substring(0, 255);
        }
        obj.setComment(comment);
    }
    
    public void AnamnesisChecksValueDataOnDemand.setTruth(AnamnesisChecksValue obj, int index) {
        Boolean truth = Boolean.TRUE;
        obj.setTruth(truth);
    }
    
    public AnamnesisChecksValue AnamnesisChecksValueDataOnDemand.getSpecificAnamnesisChecksValue(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size() - 1)) index = data.size() - 1;
        AnamnesisChecksValue obj = data.get(index);
        return AnamnesisChecksValue.findAnamnesisChecksValue(obj.getId());
    }
    
    public AnamnesisChecksValue AnamnesisChecksValueDataOnDemand.getRandomAnamnesisChecksValue() {
        init();
        AnamnesisChecksValue obj = data.get(rnd.nextInt(data.size()));
        return AnamnesisChecksValue.findAnamnesisChecksValue(obj.getId());
    }
    
    public boolean AnamnesisChecksValueDataOnDemand.modifyAnamnesisChecksValue(AnamnesisChecksValue obj) {
        return false;
    }
    
    public void AnamnesisChecksValueDataOnDemand.init() {
        data = AnamnesisChecksValue.findAnamnesisChecksValueEntries(0, 10);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'AnamnesisChecksValue' illegally returned null");
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<ch.unibas.medizin.osce.domain.AnamnesisChecksValue>();
        for (int i = 0; i < 10; i++) {
            AnamnesisChecksValue obj = getNewTransientAnamnesisChecksValue(i);
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
