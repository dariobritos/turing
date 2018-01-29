package org.proygrad.turing.persistence.dao;

import org.proygrad.turing.persistence.AbstractHibernateEntityDAO;
import org.proygrad.turing.persistence.entities.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserDAO extends AbstractHibernateEntityDAO<UserEntity,String> {

}
