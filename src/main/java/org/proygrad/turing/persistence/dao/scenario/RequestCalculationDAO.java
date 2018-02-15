package org.proygrad.turing.persistence.dao.scenario;

import org.proygrad.turing.persistence.dao.AbstractHibernateEntityDAO;
import org.proygrad.turing.persistence.entities.request.RequestCalculationEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class RequestCalculationDAO  extends AbstractHibernateEntityDAO<RequestCalculationEntity,String> {


    private static final String REQUEST = "request";
    private static final String COMPLETE = "complete";


    public List<RequestCalculationEntity> getPendingRequest(int maxLimitQuery) {


        EntityManager em = getCurrentSession();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<RequestCalculationEntity> cq = cb.createQuery(RequestCalculationEntity.class);

        Root<RequestCalculationEntity> from = cq.from(RequestCalculationEntity.class);
        cq.select(from);

        Predicate c1 = cb.equal(from.get(REQUEST), false);
        Predicate c2 = cb.equal(from.get(COMPLETE), false);

        Predicate condition = cb.and(c1,c2);

        cq.where(condition);

        TypedQuery<RequestCalculationEntity> query = em.createQuery(cq);
        query.setFirstResult(0);
        query.setMaxResults(maxLimitQuery);
        return query.getResultList();
    }



}