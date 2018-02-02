package org.proygrad.turing.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Id;

// @Entity
//@Table(name = "SCENARIO")
public class ScenarioEntity extends AbstractHibernateEntity<String>{

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "UNIT")
    private String unit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
