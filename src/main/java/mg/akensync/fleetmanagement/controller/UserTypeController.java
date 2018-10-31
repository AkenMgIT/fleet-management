/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.controller;

import mg.akensync.fleetmanagement.model.UserType;
import mg.akensync.fleetmanagement.service.UserTypeService;
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
@RequestMapping("/user-types")
public class UserTypeController {
    @Autowired
    UserTypeService service;
    
    @GetMapping({"", "/"})
    public String list(Model model) {
        model.addAttribute("list", service.getAll());
        return "user_types/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("form", new UserType());
        return "user_types/create";
    }

    @PostMapping("/create")
    public String createPost(Model model, @ModelAttribute UserType form) {
        service.save(form);
        return "redirect:/user-types";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("form", service.get(id));
        return "user_types/edit";
    }

    @PostMapping("/edit")
    public String editPost(Model model, @ModelAttribute UserType form) {
        service.update(form);
        return "redirect:/user-types";
    }

    @GetMapping("/{id}")
    public String get(Model model, @PathVariable("id") int id) {
        model.addAttribute("item", service.get(id));
        return "user_types/details";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/user_types";
    }
}
