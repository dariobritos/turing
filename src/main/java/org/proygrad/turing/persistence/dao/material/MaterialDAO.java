package org.proygrad.turing.persistence.dao.material;

import org.proygrad.turing.persistence.dao.AbstractHibernateEntityDAO;
import org.proygrad.turing.persistence.entities.material.MaterialEntity;
import org.proygrad.turing.persistence.entities.scenario.ScenarioEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class MaterialDAO extends AbstractHibernateEntityDAO<MaterialEntity,String> {

    public static final int maxResults = 10;

    public List<MaterialEntity> readByUserIdAndProperties(String userId, List<String> properties){

        EntityManager em = getCurrentSession();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<MaterialEntity> cq = cb.createQuery(MaterialEntity.class);

        Root<MaterialEntity> from = cq.from(MaterialEntity.class);
        cq.select(from);

        //TODO: ajustar predicados en base a existencia de parametros
        Predicate c1 = cb.equal(from.get("userId"), userId);

        Predicate condition = cb.and(c1);

        cq.where(condition);

        cq.orderBy(cb.desc(from.get("createDate")));
        List<MaterialEntity> resultList = em.createQuery(cq).setMaxResults(maxResults).getResultList();

        return resultList;
    }
}
