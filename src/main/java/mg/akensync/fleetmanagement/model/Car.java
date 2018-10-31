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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author khemis_ratsimivony
 */
@Entity
@Table(name = "car")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(optional = true)
    private CarBrand carBrand;

    @Column(name = "model")
    private String model;

    @Column(name = "description")
    private String description;

    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date creationDate;
    
    public Car() {
        this.creationDate = new Date();
    }

    public Car(String model, String description) {
        this();
        this.model = model;
        this.description = description;
    }

    public Car(String model, CarBrand carBrand) {
        this();
        this.carBrand = carBrand;
        this.model = model;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", carBrand=" + carBrand.getTitle() + ", model=" + model + ", description=" + description + ", creationDate=" + creationDate + '}';
    }

    
}
