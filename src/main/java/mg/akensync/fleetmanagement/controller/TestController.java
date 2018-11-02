/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import mg.akensync.fleetmanagement.businesslogic.DateUtil;
import mg.akensync.fleetmanagement.model.AppUser;
import mg.akensync.fleetmanagement.model.Car;
import mg.akensync.fleetmanagement.model.CarSchedule;
import mg.akensync.fleetmanagement.model.CarBrand;
import mg.akensync.fleetmanagement.model.UserType;
import mg.akensync.fleetmanagement.service.AppUserService;
import mg.akensync.fleetmanagement.service.CarScheduleService;
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
    CarScheduleService carActivityService;

    @Autowired
    DateUtil dateUtil;

    @RequestMapping("/find")
    public String find(Model model) {
//        System.out.println(typeService.findOneByTitle("Owner").toString());
        System.out.println(appUserService.findByuserType("Driver"));
        return "redirect:/home";
    }

    @RequestMapping("/date-calculation")
    public String dateCalculation(Model model) {
        System.out.println("DATE CALCULATION");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date target;
        Date start;
        Date end;
        try {
            target = sdf.parse("010/02/2000 09:00");
            start = sdf.parse("010/02/2000 10:00");
            end = sdf.parse("020/02/2000 10:00");

            System.out.println("Target = " + target);
            System.out.println("start = " + start);
            System.out.println("end = " + end);

            System.out.println("is target between = " + dateUtil.isDateBetween(target, start, end));
        } catch (Exception e) {
            e.printStackTrace();
        }
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

        appUserService.save(new AppUser("Constance", typeService.findOneByTitle("Owner")));
        appUserService.save(new AppUser("Joseph", typeService.findOneByTitle("Driver")));
        appUserService.save(new AppUser("Phillips", typeService.findOneByTitle("Driver")));

        carActivityService.save(new CarSchedule("Beho to Analakely", carService.findOneByModel("Pajero"), appUserService.findOneByShortName("Charle"), appUserService.findOneByShortName("Khemis")));
        carActivityService.save(new CarSchedule("Analakely to Beho", carService.findOneByModel("A3"), appUserService.findOneByShortName("Ledada"), appUserService.findOneByShortName("Khemis")));

        return "redirect:/home";
    }
}
