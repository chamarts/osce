// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.unibas.medizin.osce.domain;

import ch.unibas.medizin.osce.domain.AnamnesisForm;
import ch.unibas.medizin.osce.shared.TraitTypes;
import java.lang.String;
import java.util.Set;

privileged aspect Scar_Roo_JavaBean {
    
    public String Scar.getBodypart() {
        return this.bodypart;
    }
    
    public void Scar.setBodypart(String bodypart) {
        this.bodypart = bodypart;
    }
    
    public TraitTypes Scar.getType() {
        return this.type;
    }
    
    public void Scar.setType(TraitTypes type) {
        this.type = type;
    }
    
    public Set<AnamnesisForm> Scar.getAnamnesisForms() {
        return this.anamnesisForms;
    }
    
    public void Scar.setAnamnesisForms(Set<AnamnesisForm> anamnesisForms) {
        this.anamnesisForms = anamnesisForms;
    }
    
}
