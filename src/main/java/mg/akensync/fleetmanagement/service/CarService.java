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
import mg.akensync.fleetmanagement.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author khemis_ratsimivony
 */
@Service
public class CarService {

    @Autowired
    CarRepository repo;

    public List<Car> getAll() {
        return repo.findAllByOrderByCreationDateDesc();
    }

    public void save(Car car) {
        repo.save(car);
    }

    public void update(Car entity) {
        repo.save(entity);
    }

    public Car get(long id) {
        return repo.getOne(id);
    }

    public void delete(long id) {
        repo.deleteById(id);
    }

    public Car findOneByModel(String model) {
        return repo.findOneByModel(model);
    }
}
