// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.unibas.medizin.osce.domain;

import ch.unibas.medizin.osce.domain.AnamnesisCheck;
import ch.unibas.medizin.osce.shared.AnamnesisCheckTypes;
import java.lang.Integer;
import java.lang.String;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.stereotype.Component;

privileged aspect AnamnesisCheckDataOnDemand_Roo_DataOnDemand {
    
    declare @type: AnamnesisCheckDataOnDemand: @Component;
    
    private Random AnamnesisCheckDataOnDemand.rnd = new SecureRandom();
    
    private List<AnamnesisCheck> AnamnesisCheckDataOnDemand.data;
    
    public AnamnesisCheck AnamnesisCheckDataOnDemand.getNewTransientAnamnesisCheck(int index) {
        AnamnesisCheck obj = new AnamnesisCheck();
        setSort_order(obj, index);
        setText(obj, index);
        setTitle(obj, index);
        setType(obj, index);
        setValue(obj, index);
        return obj;
    }
    
    public void AnamnesisCheckDataOnDemand.setSort_order(AnamnesisCheck obj, int index) {
        Integer sort_order = new Integer(index);
        obj.setSort_order(sort_order);
    }
    
    public void AnamnesisCheckDataOnDemand.setText(AnamnesisCheck obj, int index) {
        String text = "text_" + index;
        if (text.length() > 255) {
            text = text.substring(0, 255);
        }
        obj.setText(text);
    }
    
    public void AnamnesisCheckDataOnDemand.setTitle(AnamnesisCheck obj, int index) {
        AnamnesisCheck title = obj;
        obj.setTitle(title);
    }
    
    public void AnamnesisCheckDataOnDemand.setType(AnamnesisCheck obj, int index) {
        AnamnesisCheckTypes type = AnamnesisCheckTypes.class.getEnumConstants()[0];
        obj.setType(type);
    }
    
    public void AnamnesisCheckDataOnDemand.setValue(AnamnesisCheck obj, int index) {
        String value = "value_" + index;
        if (value.length() > 255) {
            value = value.substring(0, 255);
        }
        obj.setValue(value);
    }
    
    public AnamnesisCheck AnamnesisCheckDataOnDemand.getSpecificAnamnesisCheck(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size() - 1)) index = data.size() - 1;
        AnamnesisCheck obj = data.get(index);
        return AnamnesisCheck.findAnamnesisCheck(obj.getId());
    }
    
    public AnamnesisCheck AnamnesisCheckDataOnDemand.getRandomAnamnesisCheck() {
        init();
        AnamnesisCheck obj = data.get(rnd.nextInt(data.size()));
        return AnamnesisCheck.findAnamnesisCheck(obj.getId());
    }
    
    public boolean AnamnesisCheckDataOnDemand.modifyAnamnesisCheck(AnamnesisCheck obj) {
        return false;
    }
    
    public void AnamnesisCheckDataOnDemand.init() {
        data = AnamnesisCheck.findAnamnesisCheckEntries(0, 10);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'AnamnesisCheck' illegally returned null");
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<ch.unibas.medizin.osce.domain.AnamnesisCheck>();
        for (int i = 0; i < 10; i++) {
            AnamnesisCheck obj = getNewTransientAnamnesisCheck(i);
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
