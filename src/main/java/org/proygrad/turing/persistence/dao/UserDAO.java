package org.proygrad.turing.persistence.dao;

import org.proygrad.turing.persistence.entities.scenario.ScenarioEntity;
import org.proygrad.turing.persistence.entities.user.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDAO extends AbstractHibernateEntityDAO<UserEntity,String> {

    public static final int maxResults = 10;

    public UserEntity getUserByEmail(String email){
        EntityManager em = getCurrentSession();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);

        Root<UserEntity> from = cq.from(UserEntity.class);
        cq.select(from);

        Predicate c1 = cb.equal(from.get("email"), email);

        Predicate condition = cb.and(c1);

        cq.where(condition);

        TypedQuery<UserEntity> createQuery = em.createQuery(cq);

        if (createQuery.getResultList().isEmpty()) {
            return null;
        }

        UserEntity user = createQuery.getSingleResult();
        return user;

    }

}
