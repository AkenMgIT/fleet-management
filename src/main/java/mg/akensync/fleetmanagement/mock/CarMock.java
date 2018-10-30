/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.mock;

import java.util.ArrayList;
import java.util.List;
import mg.akensync.fleetmanagement.model.Car;

/**
 *
 * @author khemis_ratsimivony
 */
public class CarMock {
    public static List<Car> cars = new ArrayList<>();
    static {
        cars.add(new Car(new Long(1), "bmw", "m3", ""));
        cars.add(new Car(new Long(2), "audi", "a3", ""));
        cars.add(new Car(new Long(3), "volks", "polo", ""));
    }
}
