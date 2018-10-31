/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.service;

import java.util.List;
import mg.akensync.fleetmanagement.model.CarActivity;
import mg.akensync.fleetmanagement.repository.CarActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author khemis_ratsimivony
 */
@Service
public class CarActivityService {

    @Autowired
    CarActivityRepository repo;

    public List<CarActivity> getAll() {
        return repo.findAll();
    }

    public void save(CarActivity entity) {
        repo.save(entity);
    }

    public void update(CarActivity entity) {
        repo.save(entity);
    }

    public CarActivity get(long id) {
        return repo.getOne(id);
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
