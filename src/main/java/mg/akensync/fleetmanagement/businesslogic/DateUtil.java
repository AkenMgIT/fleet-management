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
    
    public boolean isDateBetween(Date target, Date start, Date end){
        if(!target.before(start) && !target.after(end)){
            return true;
        }
        return false; 
    }
    
    public boolean isScheduleAvailable(CarSchedule newSchedule, CarSchedule existingSchedule){
        if(this.isDateBetween(
                    newSchedule.getStartDate(), 
                    existingSchedule.getStartDate(),
                    existingSchedule.getEndDate()) 
            ){
            return false;
        }
        if(this.isDateBetween(
                    newSchedule.getEndDate(), 
                    existingSchedule.getStartDate(),
                    existingSchedule.getEndDate()) 
            ){
            return false;
        }
        return true;
    }
    
}
