package org.proygrad.turing.persistence.dao;

import org.proygrad.turing.persistence.entities.ScenarioEntity;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public class ScenarioDAO extends AbstractHibernateEntityDAO<ScenarioEntity,String> {


}
