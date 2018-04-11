package org.proygrad.turing.persistence.entities.material;

import org.hibernate.annotations.GenericGenerator;
import org.proygrad.turing.persistence.entities.AbstractHibernateEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MATERIAL")
public class MaterialEntity extends AbstractHibernateEntity<String> {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ID")
    private String id;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "NAME")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MATERIAL_ID")
    private List<PropertyEntity> properties;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PropertyEntity> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyEntity> properties) {
        this.properties = properties;
    }

}
