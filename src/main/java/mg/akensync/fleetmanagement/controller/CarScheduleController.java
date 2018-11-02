/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.controller;

import mg.akensync.fleetmanagement.model.CarSchedule;
import mg.akensync.fleetmanagement.service.AppUserService;
import mg.akensync.fleetmanagement.service.CarScheduleService;
import mg.akensync.fleetmanagement.service.CarScheduleService;
import mg.akensync.fleetmanagement.service.CarService;
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
@RequestMapping("/car-schedules")
public class CarScheduleController {

    @Autowired
    AppUserService appUserService;
    @Autowired
    CarService carService;
    @Autowired
    CarScheduleService service;

    @GetMapping({"", "/"})
    public String list(Model model) {
        model.addAttribute("list", service.getAll());
        return "car_schedules/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("form", new CarSchedule());
        model.addAttribute("cars", carService.getAll());
        model.addAttribute("drivers", appUserService.findByuserType("Driver"));
        model.addAttribute("owners", appUserService.findByuserType("Owner"));
        return "car_schedules/create";
    }

    @PostMapping("/create")
    public String createPost(Model model, @ModelAttribute CarSchedule form) {
        service.save(form);
        return "redirect:/car-schedules";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("form", service.get(id));
        model.addAttribute("cars", carService.getAll());
        model.addAttribute("drivers", appUserService.findByuserType("Driver"));
        model.addAttribute("owners", appUserService.findByuserType("Owner"));
        return "car_schedules/edit";
    }

    @PostMapping("/edit")
    public String editPost(Model model, @ModelAttribute CarSchedule form) {
        service.update(form);
        return "redirect:/car-schedules";
    }

    @GetMapping("/{id}")
    public String get(Model model, @PathVariable("id") int id) {
        model.addAttribute("item", service.get(id));
        return "car_schedules/details";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/car-schedules";
    }
}
