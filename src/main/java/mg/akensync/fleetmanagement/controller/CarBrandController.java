/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.controller;

import mg.akensync.fleetmanagement.model.CarBrand;
import mg.akensync.fleetmanagement.service.CarBrandService;
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
@RequestMapping("/carBrands")
public class CarBrandController {

    @Autowired
    CarBrandService service;

    @GetMapping({"", "/"})
    public String carBrands(Model model) {
        model.addAttribute("list", service.getAll());
        return "carBrands/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("form", new CarBrand());
        return "carBrands/create";
    }

    @PostMapping("/create")
    public String createPost(Model model, @ModelAttribute CarBrand form) {
        service.save(form);
        return "redirect:/carBrands";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("form", service.get(id));
        return "carBrands/edit";
    }

    @PostMapping("/edit")
    public String editPost(Model model, @ModelAttribute CarBrand form) {
        service.update(form);
        return "redirect:/carBrands";
    }

    @GetMapping("/{id}")
    public String get(Model model, @PathVariable("id") int id) {
        model.addAttribute("brand", service.get(id));
        return "carBrands/details";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/carBrands";
    }

}