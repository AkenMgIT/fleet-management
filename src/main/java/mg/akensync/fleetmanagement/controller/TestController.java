/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.controller;

import mg.akensync.fleetmanagement.model.AppUser;
import mg.akensync.fleetmanagement.model.Car;
import mg.akensync.fleetmanagement.model.CarActivity;
import mg.akensync.fleetmanagement.model.CarBrand;
import mg.akensync.fleetmanagement.model.UserType;
import mg.akensync.fleetmanagement.service.AppUserService;
import mg.akensync.fleetmanagement.service.CarActivityService;
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
    @Autowired
    AppUserService appUserService;
    @Autowired
    CarActivityService carActivityService;

    @RequestMapping("/find")
    public String find(Model model) {
//        System.out.println(typeService.findOneByTitle("Owner").toString());
        System.out.println(appUserService.findByuserType("Driver"));
        return "redirect:/home";
    }

    @RequestMapping("/insert-data")
    public String insertData(Model model) {
        brandService.save(new CarBrand("BMW", "random description"));
        brandService.save(new CarBrand("Audi", "random description"));
        brandService.save(new CarBrand("Mistubishi", "random description"));

        carService.save(new Car("Pajero", brandService.findOneByTitle("Mistubishi")));
        carService.save(new Car("A3", brandService.findOneByTitle("Audi")));

        typeService.save(new UserType("Owner", ""));
        typeService.save(new UserType("Driver", ""));

        appUserService.save(new AppUser("Khemis", typeService.findOneByTitle("Owner")));
        appUserService.save(new AppUser("Charle", typeService.findOneByTitle("Driver")));
        appUserService.save(new AppUser("Ledada", typeService.findOneByTitle("Driver")));

        carActivityService.save(new CarActivity("Beho to Analakely", carService.findOneByModel("Pajero"), appUserService.findOneByShortName("Charle"), appUserService.findOneByShortName("Khemis")));
        carActivityService.save(new CarActivity("Analakely to Beho", carService.findOneByModel("A3"), appUserService.findOneByShortName("Ledada"), appUserService.findOneByShortName("Khemis")));

        return "redirect:/home";
    }
}
