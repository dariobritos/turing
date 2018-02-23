package org.proygrad.turing.persistence.dao.scenario;

import org.proygrad.turing.persistence.dao.AbstractHibernateEntityDAO;
import org.proygrad.turing.persistence.entities.scenario.ScenarioEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public class ScenarioDAO extends AbstractHibernateEntityDAO<ScenarioEntity,String> {


    public static final int maxResults = 10;

    public List<ScenarioEntity> readByUserId(String userId) {

        EntityManager em = getCurrentSession();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<ScenarioEntity> cq = cb.createQuery(ScenarioEntity.class);

        Root<ScenarioEntity> from = cq.from(ScenarioEntity.class);
        cq.select(from);

        Predicate c1 = cb.equal(from.get("userId"), userId);

        Predicate condition = cb.and(c1);

        cq.where(condition);

        cq.orderBy(cb.desc(from.get("createDate")));
        List<ScenarioEntity> resultList = em.createQuery(cq).setMaxResults(maxResults).getResultList();

        return resultList;
    }


}
