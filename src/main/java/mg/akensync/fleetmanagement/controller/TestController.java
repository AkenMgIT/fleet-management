/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.controller;

import mg.akensync.fleetmanagement.model.Car;
import mg.akensync.fleetmanagement.model.CarBrand;
import mg.akensync.fleetmanagement.model.UserType;
import mg.akensync.fleetmanagement.service.CarBrandService;
import mg.akensync.fleetmanagement.service.CarService;
import mg.akensync.fleetmanagement.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author khemis_ratsimivony
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    CarBrandService brandService;
    @Autowired
    CarService carService;
    @Autowired
    UserTypeService typeService;

    @RequestMapping("/insert-data")
    public String insertData(Model model) {
        brandService.save(new CarBrand("BMW", "random description"));
        brandService.save(new CarBrand("Audi", "random description"));

        carService.save(new Car("TT", ""));
        typeService.save(new UserType("Owner", ""));
        typeService.save(new UserType("Driver", ""));

        return "redirect:/home";
    }
}
