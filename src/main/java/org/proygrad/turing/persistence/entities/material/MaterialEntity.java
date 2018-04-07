package org.proygrad.turing.persistence.entities.material;

import org.hibernate.annotations.GenericGenerator;
import org.proygrad.turing.persistence.entities.AbstractHibernateEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

//@Entity
//@Table(name = "MATERIAL")
public class MaterialEntity extends AbstractHibernateEntity<String> {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ID")
    private String id;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PROPERTIES")
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PropertyEntity> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyEntity> properties) {
        this.properties = properties;
    }

}
