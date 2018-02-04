package org.proygrad.turing.persistence.entities.scenario;

import org.hibernate.annotations.GenericGenerator;
import org.proygrad.turing.persistence.entities.AbstractHibernateEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DISTRIBUTION")
public class DistributionEntity extends AbstractHibernateEntity<String> {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ID")
    private String id;

    @Column(name = "TYPE")
    private String type;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "DISTRIBUTION_ID")
    private List<CommonItemEntity> parameters;

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

    public List<CommonItemEntity> getParameters() {
        return parameters;
    }

    public void setParameters(List<CommonItemEntity> parameters) {
        this.parameters = parameters;
    }

}
