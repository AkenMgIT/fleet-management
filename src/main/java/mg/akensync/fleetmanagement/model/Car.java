/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.model;

import java.util.Date;

/**
 *
 * @author khemis_ratsimivony
 */
public class Car {

    private int id;
    private String brand;
    private String model;
    private String description;
    private Date creationDate;

    public Car() {
        this.id = 0;
        this.brand = "";
        this.model = "";
        this.description = "";
        this.creationDate = new Date();
    }

    public Car(int id, String brand, String model, String description) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.description = description;
        this.creationDate = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", brand=" + brand + ", model=" + model + ", description=" + description + ", creationDate=" + creationDate + '}';
    }

}
