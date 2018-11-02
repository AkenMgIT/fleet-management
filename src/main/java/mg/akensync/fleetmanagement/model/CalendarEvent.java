/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author khemis_ratsimivony
 */
public class CalendarEvent implements Serializable{

    private String title;
    private String description;
    private String driver;
    private String owner;
    private String car;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Europe/Moscow")
    private Date start;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Europe/Moscow")
    private Date end;

    public CalendarEvent() {
    }

    public CalendarEvent(CarSchedule schedule) {
        this.description = schedule.getDescription();
        this.driver = schedule.getDriver().getShortName();
        this.owner = schedule.getOwner().getShortName();
        this.start = schedule.getStartDate();
        this.end = schedule.getEndDate();
        this.car = schedule.getCar().getCarBrand().getTitle() + "-" + schedule.getCar().getModel();
        this.title = this.owner + "/" + this.driver + "/" + this.car;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "CalendarEvent{" + "description=" + description + ", start=" + start + ", end=" + end + '}';
    }

}
