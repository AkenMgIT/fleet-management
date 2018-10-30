/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.repository;

import java.util.List;
import java.util.Objects;
import mg.akensync.fleetmanagement.mock.CarMock;
import mg.akensync.fleetmanagement.model.Car;

/**
 *
 * @author khemis_ratsimivony
 */
public class CarMockRepository {

    public List<Car> getAll() {
        return CarMock.cars;
    }

    public void save(Car car) {
        CarMock.cars.add(car);
    }

    public void update(Car entity) {
        Car result = null;
        for (int i = 0; i < CarMock.cars.size(); i++) {
            if (Objects.equals(CarMock.cars.get(i).getId(), entity.getId())) {
                CarMock.cars.set(i, entity);
            }
        }
    }

    public Car get(long id) {
        Car result = null;
        for (Car car : CarMock.cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return result;
    }

    public void delete(long id) {
        for (int i = 0; i < CarMock.cars.size(); i++) {
            if (CarMock.cars.get(i).getId() == id) {
                CarMock.cars.remove(i);
            }
        }
    }
}
