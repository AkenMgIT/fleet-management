/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    CarScheduleService carScheduleService;

    @Autowired
    DateUtil dateUtil;

    @RequestMapping("/find")
    public String find(Model model) {
//        System.out.println(typeService.findOneByTitle("Owner").toString());
//        System.out.println(appUserService.findByuserType("Driver"));
//        System.out.println(carScheduleService.getByCar(carService.findOneByModel("Pajero")));
        System.out.println(carScheduleService.getByOwner(appUserService.findOneByShortName("Constance")));
        return "redirect:/home";
    }

    @RequestMapping("/is-date-beetween")
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

//    @RequestMapping("/is-schedule-available")
//    public String isAvailable(Model model) {
//        CarSchedule target = new CarSchedule("target");
//        CarSchedule existing = new CarSchedule("existing");
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        try {
////            target.setStartDate(sdf.parse("010/02/2000 08:00"));
////            target.setEndDate(sdf.parse("010/02/2000 08:30"));
////            
////            System.out.println("TARGET:");
////            System.out.println("\tstart: " + target.getStartDate());
////            System.out.println("\tend: " + target.getEndDate());
////            
////            existing.setStartDate(sdf.parse("010/02/2000 09:00"));
////            existing.setEndDate(sdf.parse("010/02/2000 10:00"));
////            
////            System.out.println("EXISTING:");
////            System.out.println("\tstart: " + existing.getStartDate());
////            System.out.println("\tend: " + existing.getEndDate());
////            
////            System.out.println("is schedule available: " + dateUtil.isScheduleAvailable(target, existing));
//            existing.setStartDate(sdf.parse("010/02/2000 09:00"));
//            existing.setEndDate(sdf.parse("010/02/2000 10:00"));
//
//            target.setStartDate(sdf.parse("010/02/2000 08:00"));
//            target.setEndDate(sdf.parse("010/02/2000 08:30"));
//            System.out.println(target.getStartDate() + "|----|" + target.getEndDate());
//            System.out.println("01 is schedule available: " + dateUtil.isScheduleAvailable(target, existing) + "\n");
//
//            target.setStartDate(sdf.parse("010/02/2000 08:00"));
//            target.setEndDate(sdf.parse("010/02/2000 09:00"));
//            System.out.println(target.getStartDate() + "|----|" + target.getEndDate());
//            System.out.println("02 is schedule available: " + dateUtil.isScheduleAvailable(target, existing) + "\n");
//
//            target.setStartDate(sdf.parse("010/02/2000 08:00"));
//            target.setEndDate(sdf.parse("010/02/2000 09:30"));
//            System.out.println(target.getStartDate() + "|----|" + target.getEndDate());
//            System.out.println("03 is schedule available: " + dateUtil.isScheduleAvailable(target, existing) + "\n");
//
//            target.setStartDate(sdf.parse("010/02/2000 09:30"));
//            target.setEndDate(sdf.parse("010/02/2000 11:00"));
//            System.out.println(target.getStartDate() + "|----|" + target.getEndDate());
//            System.out.println("04 is schedule available: " + dateUtil.isScheduleAvailable(target, existing) + "\n");
//
//            target.setStartDate(sdf.parse("010/02/2000 10:00"));
//            target.setEndDate(sdf.parse("010/02/2000 11:00"));
//            System.out.println(target.getStartDate() + "|----|" + target.getEndDate());
//            System.out.println("05 is schedule available: " + dateUtil.isScheduleAvailable(target, existing) + "\n");
//
//            target.setStartDate(sdf.parse("010/02/2000 10:30"));
//            target.setEndDate(sdf.parse("010/02/2000 11:00"));
//            System.out.println(target.getStartDate() + "|----|" + target.getEndDate());
//            System.out.println("05 is schedule available: " + dateUtil.isScheduleAvailable(target, existing) + "\n");
//        } catch (Exception e) {
//        }
//
//        return "redirect:/home";
//    }
    @RequestMapping("/is-schedule-available")
    public String isAvailable(Model model) {
        System.out.println("======IS SCHEDULE AVAILABLE======");
        CarSchedule target = new CarSchedule("target");
        List<CarSchedule> existing = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            target.setStartDate(sdf.parse("010/02/2000 08:45"));
            target.setEndDate(sdf.parse("010/02/2000 09:00"));
            existing.add(new CarSchedule("01", sdf.parse("10/02/2000 08:00"), sdf.parse("10/02/2000 08:30")));
            existing.add(new CarSchedule("02", sdf.parse("10/02/2000 09:15"), sdf.parse("10/02/2000 09:45")));
            existing.add(new CarSchedule("03", sdf.parse("10/02/2000 10:00"), sdf.parse("10/02/2000 11:00")));
            existing.add(new CarSchedule("06", sdf.parse("10/02/2000 13:00"), sdf.parse("10/02/2000 14:00")));

            System.out.println("===========================");
            for (CarSchedule schedule : existing) {
                System.out.println(schedule.getStartDate() + " |=====| " + schedule.getEndDate());
            }
            System.out.println("===========================");
            System.out.println("IS SCHEDULE AVAILABLE 0700-0730: " + dateUtil.isScheduleAvailable(
                    new CarSchedule("01", sdf.parse("10/02/2000 07:00"), sdf.parse("10/02/2000 07:30")), existing));
            System.out.println("IS SCHEDULE AVAILABLE 0730-0800: " + dateUtil.isScheduleAvailable(
                    new CarSchedule("01", sdf.parse("10/02/2000 07:30"), sdf.parse("10/02/2000 08:00")), existing));
            System.out.println("IS SCHEDULE AVAILABLE 0800-0830: " + dateUtil.isScheduleAvailable(
                    new CarSchedule("01", sdf.parse("10/02/2000 08:00"), sdf.parse("10/02/2000 08:30")), existing));
            System.out.println("IS SCHEDULE AVAILABLE 0830-0900: " + dateUtil.isScheduleAvailable(
                    new CarSchedule("01", sdf.parse("10/02/2000 08:30"), sdf.parse("10/02/2000 09:00")), existing));
            System.out.println("IS SCHEDULE AVAILABLE 0900-0930: " + dateUtil.isScheduleAvailable(
                    new CarSchedule("01", sdf.parse("10/02/2000 09:00"), sdf.parse("10/02/2000 09:30")), existing));
            System.out.println("IS SCHEDULE AVAILABLE 0930-1000: " + dateUtil.isScheduleAvailable(
                    new CarSchedule("01", sdf.parse("10/02/2000 09:30"), sdf.parse("10/02/2000 10:00")), existing));
            System.out.println("IS SCHEDULE AVAILABLE 1000-1030: " + dateUtil.isScheduleAvailable(
                    new CarSchedule("01", sdf.parse("10/02/2000 10:00"), sdf.parse("10/02/2000 10:30")), existing));
            System.out.println("IS SCHEDULE AVAILABLE 1030-1100: " + dateUtil.isScheduleAvailable(
                    new CarSchedule("01", sdf.parse("10/02/2000 10:30"), sdf.parse("10/02/2000 11:00")), existing));
            System.out.println("IS SCHEDULE AVAILABLE 1100-1130: " + dateUtil.isScheduleAvailable(
                    new CarSchedule("01", sdf.parse("10/02/2000 11:00"), sdf.parse("10/02/2000 11:30")), existing));
            System.out.println("IS SCHEDULE AVAILABLE 1130-1200: " + dateUtil.isScheduleAvailable(
                    new CarSchedule("01", sdf.parse("10/02/2000 11:30"), sdf.parse("10/02/2000 12:00")), existing));
        } catch (Exception e) {

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

        carScheduleService.save(new CarSchedule("Beho to Analakely", carService.findOneByModel("Pajero"), appUserService.findOneByShortName("Joseph"), appUserService.findOneByShortName("Constance")));
        carScheduleService.save(new CarSchedule("Analakely to Beho", carService.findOneByModel("A3"), appUserService.findOneByShortName("Phillips"), appUserService.findOneByShortName("Constance")));

        return "redirect:/home";
    }
}
