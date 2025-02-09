package com.nbs.student.dao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;
import java.util.Date;


@MappedSuperclass
public abstract class AbstractPersistableEntity<T extends Serializable>
        implements Persistable<T> {

    @Transient
    private boolean isNew = true;

    @Getter
    @Column(name = "created_on")
    protected Date createdOn;

    @Getter
    @Column(name = "last_updated_on")
    protected Date lastUpdatedOn;

    @Override
    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }

    @PostLoad
    @PostPersist
    void markNotNew() {
        this.isNew = false;
    }
    @PrePersist
    void setCreatedOn(){
        createdOn = new Date(System.currentTimeMillis());
        lastUpdatedOn = new Date(System.currentTimeMillis());
    }
    @PreUpdate
    void setLastUpdatedOn(){
        lastUpdatedOn = new Date(System.currentTimeMillis());
    }

}
