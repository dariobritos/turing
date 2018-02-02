package org.proygrad.turing.persistence.dao;

import org.proygrad.turing.persistence.entities.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO extends AbstractHibernateEntityDAO<UserEntity,String> {

}
