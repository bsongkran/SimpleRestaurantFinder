package com.example.restaurantfinder.model;

import com.vividsolutions.jts.geom.Geometry;
import org.joda.time.DateTime;
import org.springframework.data.geo.Point;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by BERM-PC on 22/12/2559.
 */

@Entity
@Table(name = "Restaurant")
public class Restaurant  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RestaurantId" )
    private long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Latitude")
    private double latitude;

    @Column(name = "Longitude")
    private double longitude;

    @Column(name = "Geometry")
    private Geometry geometry;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="OpeningHourId")
    private Set<OpeningHour> openingHours ;


    @Column(name = "CreatedDate", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column( name = "UpdatedDate", columnDefinition="DATETIME" )
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;


    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Set<OpeningHour> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(Set<OpeningHour> openingHours) {
        this.openingHours = openingHours;
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
