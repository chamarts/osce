// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.unibas.medizin.osce.domain;

import ch.unibas.medizin.osce.domain.RoleTemplate;
import java.lang.Integer;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;

privileged aspect RoleTemplate_Roo_Entity {
    
    declare @type: RoleTemplate: @Entity;
    
    declare @type: RoleTemplate: @Table(name = "role_template");
    
    @PersistenceContext
    transient EntityManager RoleTemplate.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer RoleTemplate.id;
    
    @Version
    @Column(name = "version")
    private Integer RoleTemplate.version;
    
    public Integer RoleTemplate.getId() {
        return this.id;
    }
    
    public void RoleTemplate.setId(Integer id) {
        this.id = id;
    }
    
    public Integer RoleTemplate.getVersion() {
        return this.version;
    }
    
    public void RoleTemplate.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void RoleTemplate.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void RoleTemplate.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            RoleTemplate attached = RoleTemplate.findRoleTemplate(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void RoleTemplate.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void RoleTemplate.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public RoleTemplate RoleTemplate.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        RoleTemplate merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager RoleTemplate.entityManager() {
        EntityManager em = new RoleTemplate().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long RoleTemplate.countRoleTemplates() {
        return entityManager().createQuery("SELECT COUNT(o) FROM RoleTemplate o", Long.class).getSingleResult();
    }
    
    public static List<RoleTemplate> RoleTemplate.findAllRoleTemplates() {
        return entityManager().createQuery("SELECT o FROM RoleTemplate o", RoleTemplate.class).getResultList();
    }
    
    public static RoleTemplate RoleTemplate.findRoleTemplate(Integer id) {
        if (id == null) return null;
        return entityManager().find(RoleTemplate.class, id);
    }
    
    public static List<RoleTemplate> RoleTemplate.findRoleTemplateEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM RoleTemplate o", RoleTemplate.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}