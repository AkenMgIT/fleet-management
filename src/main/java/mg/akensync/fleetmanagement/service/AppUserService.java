/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.service;

import java.util.List;
import mg.akensync.fleetmanagement.model.AppUser;
import mg.akensync.fleetmanagement.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author khemis_ratsimivony
 */
@Service
public class AppUserService {
    @Autowired
    AppUserRepository repo;

    public List<AppUser> getAll() {
        return repo.findAll();
    }

    public void save(AppUser entity) {
        repo.save(entity);
    }

    public void update(AppUser entity) {
        repo.save(entity);
    }

    public AppUser get(long id) {
        return repo.getOne(id);
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
    
    public List<AppUser> findByuserType(String type){
        return repo.findAllByUserTypeTitle(type);
    }
    
    public AppUser findOneByShortName(String shortName) {
        return repo.findOneByShortName(shortName);
    }
}
