/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.service;

import java.util.List;
import mg.akensync.fleetmanagement.model.CarSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mg.akensync.fleetmanagement.repository.CarScheduleRepository;

/**
 *
 * @author khemis_ratsimivony
 */
@Service
public class CarScheduleService {

    @Autowired
    CarScheduleRepository repo;

    public List<CarSchedule> getAll() {
        return repo.findAll();
    }

    public void save(CarSchedule entity) {
        repo.save(entity);
    }

    public void update(CarSchedule entity) {
        repo.save(entity);
    }

    public CarSchedule get(long id) {
        return repo.getOne(id);
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
