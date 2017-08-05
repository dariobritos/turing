package org.proygrad.turing.persistence;

public interface HibernateEntity<ID> {

    ID getId();

    void setId(ID id);
}
