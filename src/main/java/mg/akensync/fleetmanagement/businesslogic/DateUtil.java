/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.businesslogic;

import java.util.Date;
import java.util.List;
import mg.akensync.fleetmanagement.model.CarSchedule;
import org.springframework.stereotype.Service;

/**
 *
 * @author khemis_ratsimivony
 */
@Service
public class DateUtil {

    public boolean isDateBetween(Date target, Date start, Date end) {
//        System.out.println("===================");
//        System.out.println("Target: "+target);
//        System.out.println("start: "+start);
//        System.out.println("end: "+end);
//        if(!target.before(start) && !target.after(end)){
//            System.out.println("is between: return true\n");
//            return true;
//        }
        if (target.after(start) && target.before(end)) {
//            System.out.println("is between: return true\n");
            return true;
        }
//        System.out.println("is not between: return false\n ");
        return false;
    }

    public boolean isScheduleAvailable(CarSchedule a, CarSchedule b) {
        // CASE 01:
        if(a.getStartDate().before(b.getStartDate())){
            if(a.getEndDate().before(b.getStartDate())){
                return true;
            }
        }
        // CASE 02:
        if(a.getStartDate().before(b.getStartDate())){
            if( !a.getEndDate().after(b.getStartDate()) ){
                return true;
            }
        }
        // CASE 05:
        if(!a.getStartDate().before(b.getEndDate())){
            if(a.getEndDate().after(b.getEndDate()) ){
                return true;
            }
        }
        return false;
    }
//    public boolean isScheduleAvailable(CarSchedule newSchedule, CarSchedule existingSchedule) {
//        if (this.isDateBetween(
//                newSchedule.getStartDate(),
//                existingSchedule.getStartDate(),
//                existingSchedule.getEndDate())) {
//            return false;
//        }
//        if (this.isDateBetween(
//                newSchedule.getEndDate(),
//                existingSchedule.getStartDate(),
//                existingSchedule.getEndDate())) {
//            return false;
//        }
//        return true;
//    }
    
    public boolean isScheduleAvailable(CarSchedule a, List<CarSchedule> list){
        for(CarSchedule b : list){
            if( !isScheduleAvailable(a,b) ){
                return false;
            }
        }
        return true;
    }

}
