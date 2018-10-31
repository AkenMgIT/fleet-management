/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.service;

import java.util.List;
import mg.akensync.fleetmanagement.model.CarBrand;
import mg.akensync.fleetmanagement.repository.CarBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author khemis_ratsimivony
 */
@Service
public class CarBrandService {

    @Autowired
    CarBrandRepository repo;

    public List<CarBrand> getAll() {
        return repo.findAll();
    }

    public void save(CarBrand car) {
        repo.save(car);
    }

    public void update(CarBrand entity) {
        repo.save(entity);
    }

    public CarBrand get(long id) {
        return repo.getOne(id);
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
    
    public CarBrand findOneByTitle(String title) {
        return repo.findOneByTitle(title);
    }
}
