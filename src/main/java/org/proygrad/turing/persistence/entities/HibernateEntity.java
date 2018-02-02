package org.proygrad.turing.persistence.entities;

public interface HibernateEntity<ID> {

    ID getId();

    void setId(ID id);
}
