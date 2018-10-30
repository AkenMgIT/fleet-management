/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.controller;

import mg.akensync.fleetmanagement.model.Car;
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
@RequestMapping("/cars")
public class CarController {
    
    @Autowired
    CarService service;
    
    @GetMapping({"","/"})
    public String cars(Model model) {
        model.addAttribute("cars", service.getAll());
        return "cars/list"; 
    }
    
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("form", new Car());
        return "cars/create"; 
    }
    
    @PostMapping("/create")
    public String createPost(Model model, @ModelAttribute Car form) {
        System.out.println(form.toString());
        service.save(form);
        model.addAttribute("data", "Success");
        return "redirect:/cars"; 
    }
    
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("form", service.get(id));
        return "cars/edit"; 
    }
//    
    @PostMapping("/edit")
    public String editPost(Model model, @ModelAttribute Car form) {
        System.out.println(form.toString());
        service.update(form);
        model.addAttribute("data", "Success");
        return "redirect:/cars"; 
    }
    
    @GetMapping("/{id}")
    public String get(Model model, @PathVariable("id") int id) {
        model.addAttribute("car", service.get(id));
        return "cars/details"; 
    }
    @GetMapping("/{id}/delete")
    public String delete(Model model, @PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/cars";
    }
    
}
