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
@Table(name = "app_user")
public class AppUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "short_name")
    private String shortName;

    @ManyToOne(optional = true)
    private UserType userType;

    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date creationDate;

    public AppUser() {
        this.creationDate = new Date();
    }

    public AppUser(String shortName) {
        this();
        this.shortName = shortName;
    }

    public AppUser(String shortName, UserType userType) {
        this();
        this.shortName = shortName;
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "AppUser{" + "id=" + id + ", shortName=" + shortName + ", useType=" + userType.getTitle() + ", creationDate=" + creationDate + '}';
    }

}
