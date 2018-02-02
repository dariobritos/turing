package org.proygrad.turing.persistence.entities;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

// @Entity
// @Table(name = "USER_PREFERENCE")
public class UserPreferencesEntity extends AbstractHibernateEntity<String>{

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "ID")
    private String id;

    @Column(name = "UNIT_SYSTEM")
    private String unitSystem;

    @Column(name = "LANGUAGE")
    private String language;

    @Column(name = "FAST_SCENARIO")
    private String fastScenario;

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

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String s) {

    }
}
