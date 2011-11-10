// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.unibas.medizin.osce.domain;

import ch.unibas.medizin.osce.domain.AnamnesisForm;
import ch.unibas.medizin.osce.domain.Bankaccount;
import ch.unibas.medizin.osce.domain.Description;
import ch.unibas.medizin.osce.domain.LangSkill;
import ch.unibas.medizin.osce.domain.Nationality;
import ch.unibas.medizin.osce.domain.Profession;
import ch.unibas.medizin.osce.shared.Gender;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.Set;

privileged aspect StandardizedPatient_Roo_JavaBean {
    
    public Gender StandardizedPatient.getGender() {
        return this.gender;
    }
    
    public void StandardizedPatient.setGender(Gender gender) {
        this.gender = gender;
    }
    
    public String StandardizedPatient.getName() {
        return this.name;
    }
    
    public void StandardizedPatient.setName(String name) {
        this.name = name;
    }
    
    public String StandardizedPatient.getPreName() {
        return this.preName;
    }
    
    public void StandardizedPatient.setPreName(String preName) {
        this.preName = preName;
    }
    
    public String StandardizedPatient.getStreet() {
        return this.street;
    }
    
    public void StandardizedPatient.setStreet(String street) {
        this.street = street;
    }
    
    public String StandardizedPatient.getCity() {
        return this.city;
    }
    
    public void StandardizedPatient.setCity(String city) {
        this.city = city;
    }
    
    public Integer StandardizedPatient.getPostalCode() {
        return this.postalCode;
    }
    
    public void StandardizedPatient.setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }
    
    public String StandardizedPatient.getTelephone() {
        return this.telephone;
    }
    
    public void StandardizedPatient.setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    public String StandardizedPatient.getTelephone2() {
        return this.telephone2;
    }
    
    public void StandardizedPatient.setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }
    
    public String StandardizedPatient.getMobile() {
        return this.mobile;
    }
    
    public void StandardizedPatient.setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public Date StandardizedPatient.getBirthday() {
        return this.birthday;
    }
    
    public void StandardizedPatient.setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    public String StandardizedPatient.getEmail() {
        return this.email;
    }
    
    public void StandardizedPatient.setEmail(String email) {
        this.email = email;
    }
    
    public Description StandardizedPatient.getDescriptions() {
        return this.descriptions;
    }
    
    public void StandardizedPatient.setDescriptions(Description descriptions) {
        this.descriptions = descriptions;
    }
    
    public Bankaccount StandardizedPatient.getBankAccount() {
        return this.bankAccount;
    }
    
    public void StandardizedPatient.setBankAccount(Bankaccount bankAccount) {
        this.bankAccount = bankAccount;
    }
    
    public Nationality StandardizedPatient.getNationality() {
        return this.nationality;
    }
    
    public void StandardizedPatient.setNationality(Nationality nationality) {
        this.nationality = nationality;
    }
    
    public Profession StandardizedPatient.getProfession() {
        return this.profession;
    }
    
    public void StandardizedPatient.setProfession(Profession profession) {
        this.profession = profession;
    }
    
    public AnamnesisForm StandardizedPatient.getAnamnesisForm() {
        return this.anamnesisForm;
    }
    
    public void StandardizedPatient.setAnamnesisForm(AnamnesisForm anamnesisForm) {
        this.anamnesisForm = anamnesisForm;
    }
    
    public Set<LangSkill> StandardizedPatient.getLangskills() {
        return this.langskills;
    }
    
    public void StandardizedPatient.setLangskills(Set<LangSkill> langskills) {
        this.langskills = langskills;
    }
    
}
