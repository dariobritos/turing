package org.proygrad.turing.persistence.entities.material;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "PROPERTY")
public class PropertyEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ID")
    private String id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "VALUE")
    private Double value;

    @Column(name = "UNIT")
    private String unit;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "DISTRIBUTION")
    private PropertyDistributionEntity distribution;

    @Column(name = "MAGNITUDE")
    private String magnitude;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PropertyDistributionEntity getDistribution() {
        return distribution;
    }

    public void setDistribution(PropertyDistributionEntity distribution) {
        this.distribution = distribution;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
