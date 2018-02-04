package org.proygrad.turing.persistence.entities.user;

import org.proygrad.turing.persistence.entities.AbstractHibernateEntity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "USER")
public class UserEntity extends AbstractHibernateEntity<String> {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "EMAIL")
    private String email;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name ="USER_PREFERENCE_ID")
    private UserPreferencesEntity preferences;

    //@OneToMany(mappedBy = "SCENARIO_ID")
    //private List<ScenarioEntity> scenarios;

    public UserEntity(){
        this.setId(UUID.randomUUID().toString());
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   public UserPreferencesEntity getPreferences() {
        return preferences;
    }

    public void setPreferences(UserPreferencesEntity preferences) {
        this.preferences = preferences;
    }/*
    public List<ScenarioEntity> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<ScenarioEntity> scenarios) {
        this.scenarios = scenarios;
    }*/
}
