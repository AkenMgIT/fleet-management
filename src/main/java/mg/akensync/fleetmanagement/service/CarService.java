/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.service;

import java.util.ArrayList;
import java.util.List;
import mg.akensync.fleetmanagement.mock.CarMock;
import mg.akensync.fleetmanagement.model.Car;
import org.springframework.stereotype.Service;

/**
 *
 * @author khemis_ratsimivony
 */
@Service
public class CarService {

    public List<Car> getAll() {
        return CarMock.cars; 
    }
    
    public void save(Car car){
        CarMock.cars.add(car);
    }
    
    public void update(Car entity){
        Car result = null;
        for(int i = 0 ; i < CarMock.cars.size() ; i++){
            if(CarMock.cars.get(i).getId()==entity.getId()){
               CarMock.cars.set(i, entity); 
            }
        }
    }
    
    public Car get(int id){
        Car result = null;
        for(Car car : CarMock.cars){
            if(car.getId()==id){
                return car;
            }
        }
        return result;
    }
    public void delete(int id){
        for(int i = 0 ; i < CarMock.cars.size() ; i++){
            if(CarMock.cars.get(i).getId()==id){
               CarMock.cars.remove(i); 
            }
        }
    }
}
