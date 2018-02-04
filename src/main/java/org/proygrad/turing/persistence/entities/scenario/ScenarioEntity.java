package org.proygrad.turing.persistence.entities.scenario;

import org.hibernate.annotations.GenericGenerator;
import org.proygrad.turing.persistence.entities.AbstractHibernateEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SCENARIO")
public class ScenarioEntity extends AbstractHibernateEntity<String> {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ID")
    private String id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "UNIT_SYSTEM")
    private String unitSystem;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "SCENARIO_ID")
    private List<ParameterEntity> parameters;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "SCENARIO_CONFIGURATION_ID")
    private List<CommonItemEntity> configuration;

    @Column(name = "COMMENTS")
    private String comments;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "SCENARIO_OUTPUT_ID")
    private List<CommonItemEntity> output;

    public ScenarioEntity(){
        //this.setId(UUID.randomUUID().toString());
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnitSystem() {
        return unitSystem;
    }

    public void setUnitSystem(String unitSystem) {
        this.unitSystem = unitSystem;
    }

    public List<ParameterEntity> getParameters() {
        return parameters;
    }

    public void setParameters(List<ParameterEntity> parameters) {
        this.parameters = parameters;
    }

    public List<CommonItemEntity> getConfiguration() {
        return configuration;
    }

    public void setConfiguration(List<CommonItemEntity> configuration) {
        this.configuration = configuration;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<CommonItemEntity> getOutput() {
        return output;
    }

    public void setOutput(List<CommonItemEntity> output) {
        this.output = output;
    }

}
