package org.proygrad.turing.persistence.entities.scenario;

import org.hibernate.annotations.GenericGenerator;
import org.proygrad.turing.persistence.entities.AbstractHibernateEntity;

import javax.persistence.*;

@Entity
@Table(name = "PARAMETER")
public class ParameterEntity extends AbstractHibernateEntity<String> {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ID")
    private String id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "VALUE")
    private Double value;

    @Column(name = "TYPE")
    private String type;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "DISTRIBUTION_ID")
    private DistributionEntity distribution;

    @Column(name = "MAGNITUDE")
    private String magnitude;

    @Column(name = "UNIT")
    private String unit;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

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

    public DistributionEntity getDistribution() {
        return distribution;
    }

    public void setDistribution(DistributionEntity distribution) {
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

}
