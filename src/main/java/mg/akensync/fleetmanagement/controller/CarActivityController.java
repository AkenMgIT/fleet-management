/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.controller;

import mg.akensync.fleetmanagement.model.CarActivity;
import mg.akensync.fleetmanagement.service.AppUserService;
import mg.akensync.fleetmanagement.service.CarActivityService;
import mg.akensync.fleetmanagement.service.CarActivityService;
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
@RequestMapping("/car-activities")
public class CarActivityController {

    @Autowired
    AppUserService appUserService;
    @Autowired
    CarService carService;
    @Autowired
    CarActivityService service;

    @GetMapping({"", "/"})
    public String list(Model model) {
        model.addAttribute("list", service.getAll());
        return "car_activities/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("form", new CarActivity());
        model.addAttribute("cars", carService.getAll());
        model.addAttribute("drivers", appUserService.findByuserType("Driver"));
        model.addAttribute("owners", appUserService.findByuserType("Owner"));
        return "car_activities/create";
    }

    @PostMapping("/create")
    public String createPost(Model model, @ModelAttribute CarActivity form) {
        service.save(form);
        return "redirect:/car-activities";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("form", service.get(id));
        model.addAttribute("cars", carService.getAll());
        model.addAttribute("drivers", appUserService.findByuserType("Driver"));
        model.addAttribute("owners", appUserService.findByuserType("Owner"));
        return "car_activities/edit";
    }

    @PostMapping("/edit")
    public String editPost(Model model, @ModelAttribute CarActivity form) {
        service.update(form);
        return "redirect:/car-activities";
    }

    @GetMapping("/{id}")
    public String get(Model model, @PathVariable("id") int id) {
        model.addAttribute("item", service.get(id));
        return "car_activities/details";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/car-activities";
    }
}
