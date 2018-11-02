/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.rest;

import java.util.List;
import mg.akensync.fleetmanagement.model.CalendarEvent;
import mg.akensync.fleetmanagement.model.CarSchedule;
import mg.akensync.fleetmanagement.service.CarScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author khemis_ratsimivony
 */
@RestController
@RequestMapping("rest")
public class ScheduleRestController {
    
    @Autowired
    CarScheduleService service;
    
//    @GetMapping("/schedules")
//    public List<CarSchedule> findAll() {
//        return service.getAll();
//    }
    @GetMapping("/schedules")
    public List<CalendarEvent> findAll() {
        List<CalendarEvent> result = service.getAllCalendarEvents();
        for(CalendarEvent ce : result){
            System.out.println(ce.toString());
        }
        return result;
    }
}
