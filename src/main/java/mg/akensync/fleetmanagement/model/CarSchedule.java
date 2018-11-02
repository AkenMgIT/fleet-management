/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author khemis_ratsimivony
 */
@Entity
@Table(name = "car_schedule")
public class CarSchedule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @ManyToOne(optional = true)
    private Car car;
    
    @ManyToOne(optional = true)
    private AppUser driver;

    @ManyToOne(optional = true)
    private AppUser owner;

    @Column(name = "start_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date startDate;

    @Column(name = "end_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date endDate;

    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date creationDate;

    public CarSchedule() {
        this.creationDate = new Date();
        this.startDate = new Date();
        this.endDate = new Date();
    }

    public CarSchedule(String description) {
        this();
        this.description = description;
    }

    public CarSchedule(String description, Car car, AppUser driver, AppUser owner) {
        this();
        this.description = description;
        this.car = car;
        this.driver = driver;
        this.owner = owner;
    }

    public CarSchedule(String description, Date startDate, Date endDate) {
        this();
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public AppUser getDriver() {
        return driver;
    }

    public void setDriver(AppUser driver) {
        this.driver = driver;
    }

    public AppUser getOwner() {
        return owner;
    }

    public void setOwner(AppUser owner) {
        this.owner = owner;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "CarActivity{" + "description=" + description + '}';
    }

    
}
