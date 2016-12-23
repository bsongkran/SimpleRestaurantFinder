package com.example.restaurantfinder.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by BERM-PC on 23/12/2559.
 */

@Entity
@Table(name = "OpeningHour")
public class OpeningHour  implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OpeningHourId" )
    private long id;

    @Column(name = "Weekday")
    private String weekday;

    @Column(name = "IsOpen")
    private boolean isOpen;

    @ManyToOne
    @JoinColumn(name="RestaurantId")
    private Restaurant restaurant;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="OpeningHourPeriodId")
    private Set<OpeningHourPeriod> openingHourPeriods;


    @Column(name = "CreatedDate", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column( name = "UpdatedDate", columnDefinition="DATETIME" )
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Set<OpeningHourPeriod> getOpeningHourPeriods() {
        return openingHourPeriods;
    }

    public void setOpeningHourPeriods(Set<OpeningHourPeriod> openingHourPeriods) {
        this.openingHourPeriods = openingHourPeriods;
    }

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
