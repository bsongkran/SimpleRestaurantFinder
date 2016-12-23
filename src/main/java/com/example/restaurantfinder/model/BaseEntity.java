package com.example.restaurantfinder.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by BERM-PC on 23/12/2559.
 */


@MappedSuperclass
public abstract class BaseEntity {


    @Column(name = "CreatedDate", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column( name = "UpdatedDate", columnDefinition="DATETIME" )
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}