/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.controller;

import java.util.ArrayList;
import java.util.List;
import mg.akensync.fleetmanagement.model.AppUser;
import mg.akensync.fleetmanagement.model.CarSchedule;
import mg.akensync.fleetmanagement.service.AppUserService;
import mg.akensync.fleetmanagement.service.CarScheduleService;
import mg.akensync.fleetmanagement.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author khemis_ratsimivony
 */
@Controller
@RequestMapping("/app-users")
public class AppUserController {

    @Autowired
    AppUserService service;

    @Autowired
    UserTypeService typeService;
    
    @Autowired
    CarScheduleService scheduleService;

    @GetMapping({"", "/"})
    public String list(Model model) {
        model.addAttribute("list", service.getAll());
        return "app_users/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("form", new AppUser());
        model.addAttribute("types", typeService.getAll());
        return "app_users/create";
    }

    @PostMapping("/create")
    public String createPost(Model model, @ModelAttribute AppUser form) {
        service.save(form);
        return "redirect:/app-users";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("form", service.get(id));
        model.addAttribute("types", typeService.getAll());
        return "app_users/edit";
    }

    @PostMapping("/edit")
    public String editPost(Model model, @ModelAttribute AppUser form) {
        service.update(form);
        return "redirect:/app-users";
    }

    @GetMapping("/{id}")
    public String get(Model model, @PathVariable("id") int id) {
        AppUser item = service.get(id);
        model.addAttribute("item", item);
        System.out.println("user is a : " + item.getUserType().getTitle());
        List<CarSchedule> schedules = new ArrayList<>() ;
        if(item.getUserType().getTitle().equals("Driver") ){
            System.out.println("is a driver");
            schedules = scheduleService.getByDriver(item);
        }else if(item.getUserType().getTitle().equals("Owner") ){
            System.out.println("is an owner");
            schedules = scheduleService.getByOwner(item);
        }
        model.addAttribute("list", schedules);
        return "app_users/details";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/app-users";
    }
}
