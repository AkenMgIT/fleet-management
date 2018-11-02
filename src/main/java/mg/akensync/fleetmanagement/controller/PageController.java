/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author khemis_ratsimivony
 */
@Controller
public class PageController {

    @RequestMapping({"/", "/home"})
    public String home(Model model) {
        return "pages/home"; 
    }
    
    @GetMapping("schedule-calendar")
    public String scheduleCalendar(Model model) {
        return "pages/schedule_calendar"; 
    }
    
//    @RequestMapping("/greeting")
//    public String greeting(Model model) {
//        return "basic/greeting";
//    }
//    @RequestMapping("/side_menu")
//    public String sideMenu(Model model) {
//        return "basic/side_menu";
//    }
//    @RequestMapping("/layout")
//    public String layout(Model model) {
//        return "basic/layout";
//    }
//    @RequestMapping("/main-layout")
//    public String mainLayout(Model model) {
//        return "main_layout";
//    }
//    @RequestMapping("/table-data")
//    public String tableData(Model model) {
//        return "basic/table-data";
//    }

}
