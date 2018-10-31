/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.service;

import java.util.List;
import mg.akensync.fleetmanagement.model.UserType;
import mg.akensync.fleetmanagement.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author khemis_ratsimivony
 */
@Service
public class UserTypeService {

    @Autowired
    UserTypeRepository repo;

    public List<UserType> getAll() {
        return repo.findAll();
    }

    public void save(UserType entity) {
        repo.save(entity);
    }

    public void update(UserType entity) {
        repo.save(entity);
    }

    public UserType get(long id) {
        return repo.getOne(id);
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
