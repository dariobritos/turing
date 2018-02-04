package org.proygrad.turing.persistence.entities.user;


import org.proygrad.turing.persistence.entities.AbstractHibernateEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_PREFERENCE")
public class UserPreferencesEntity extends AbstractHibernateEntity<String> {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "UNIT_SYSTEM")
    private String unitSystem;

    @Column(name = "LANGUAGE")
    private String language;

    @Column(name = "FAST_SCENARIO")
    private String fastScenario;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getUnitSystem() {
        return unitSystem;
    }

    public void setUnitSystem(String unitSystem) {
        this.unitSystem = unitSystem;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFastScenario() {
        return fastScenario;
    }

    public void setFastScenario(String fastScenario) {
        this.fastScenario = fastScenario;
    }

}
