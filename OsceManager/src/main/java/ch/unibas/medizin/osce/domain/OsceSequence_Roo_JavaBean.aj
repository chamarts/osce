// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.unibas.medizin.osce.domain;

import ch.unibas.medizin.osce.domain.Course;
import ch.unibas.medizin.osce.domain.OsceDay;
import ch.unibas.medizin.osce.domain.OscePost;
import java.lang.Integer;
import java.lang.String;
import java.util.Set;

privileged aspect OsceSequence_Roo_JavaBean {
    
    public Integer OsceSequence.getNumberRotation() {
        return this.numberRotation;
    }
    
    public void OsceSequence.setNumberRotation(Integer numberRotation) {
        this.numberRotation = numberRotation;
    }
    
    public String OsceSequence.getLabel() {
        return this.label;
    }
    
    public void OsceSequence.setLabel(String label) {
        this.label = label;
    }
    
    public OsceDay OsceSequence.getOsceDay() {
        return this.osceDay;
    }
    
    public void OsceSequence.setOsceDay(OsceDay osceDay) {
        this.osceDay = osceDay;
    }
    
    public Set<Course> OsceSequence.getCourses() {
        return this.courses;
    }
    
    public void OsceSequence.setCourses(Set<Course> courses) {
        this.courses = courses;
    }
    
    public Set<OscePost> OsceSequence.getOscePosts() {
        return this.oscePosts;
    }
    
    public void OsceSequence.setOscePosts(Set<OscePost> oscePosts) {
        this.oscePosts = oscePosts;
    }
    
}