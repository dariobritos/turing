package org.proygrad.turing.persistence.entities.material;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PROPERTY_DISTRIBUTION")
public class PropertyDistributionEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ID")
    private String id;

    @Column(name = "TYPE")
    private String type;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROPERTY_DISTRIBUTION_ID")
    private List<ParameterDistributionEntity> parameters;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ParameterDistributionEntity> getParameters() {
        return parameters;
    }

    public void setParameters(List<ParameterDistributionEntity> parameters) {
        this.parameters = parameters;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
