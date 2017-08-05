package org.proygrad.turing.persistence.dao;

import org.proygrad.turing.persistence.AbstractHibernateEntityDAO;
import org.proygrad.turing.persistence.entities.CalculationEntity;
import org.springframework.stereotype.Repository;


@Repository
public class CalculationDao extends AbstractHibernateEntityDAO<CalculationEntity,Long> {
}
