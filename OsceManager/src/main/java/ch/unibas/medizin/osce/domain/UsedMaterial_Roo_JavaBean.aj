// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.unibas.medizin.osce.domain;

import ch.unibas.medizin.osce.domain.MaterialList;
import ch.unibas.medizin.osce.domain.StandardizedRole;
import ch.unibas.medizin.osce.shared.MaterialUsedFromTypes;
import java.lang.Integer;

privileged aspect UsedMaterial_Roo_JavaBean {
    
    public Integer UsedMaterial.getMaterialCount() {
        return this.materialCount;
    }
    
    public void UsedMaterial.setMaterialCount(Integer materialCount) {
        this.materialCount = materialCount;
    }
    
    public MaterialUsedFromTypes UsedMaterial.getUsed_from() {
        return this.used_from;
    }
    
    public void UsedMaterial.setUsed_from(MaterialUsedFromTypes used_from) {
        this.used_from = used_from;
    }
    
    public StandardizedRole UsedMaterial.getStandardizedRole() {
        return this.standardizedRole;
    }
    
    public void UsedMaterial.setStandardizedRole(StandardizedRole standardizedRole) {
        this.standardizedRole = standardizedRole;
    }
    
    public MaterialList UsedMaterial.getMaterialList() {
        return this.materialList;
    }
    
    public void UsedMaterial.setMaterialList(MaterialList materialList) {
        this.materialList = materialList;
    }
    
    public Integer UsedMaterial.getSort_order() {
        return this.sort_order;
    }
    
    public void UsedMaterial.setSort_order(Integer sort_order) {
        this.sort_order = sort_order;
    }
    
}