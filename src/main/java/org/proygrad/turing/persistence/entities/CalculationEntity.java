package org.proygrad.turing.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "CALCULATIONS")
public class CalculationEntity extends AbstractHibernateEntity<Long>{

    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long aLong) {
        this.id = aLong;
    }
}
