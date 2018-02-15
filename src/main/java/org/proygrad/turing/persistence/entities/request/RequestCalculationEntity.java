package org.proygrad.turing.persistence.entities.request;

import org.proygrad.turing.persistence.entities.AbstractHibernateEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "REQUEST_CALCULATION")
public class RequestCalculationEntity extends AbstractHibernateEntity<String> {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "REQUEST_ID")
    private String requestId;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "REQUEST")
    private boolean request;

    @Column(name = "COMPLETE")
    private boolean complete;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isRequest() {
        return request;
    }

    public void setRequest(boolean request) {
        this.request = request;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
