/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.repository;

import java.util.List;
import mg.akensync.fleetmanagement.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author khemis_ratsimivony
 */
public interface AppUserRepository extends JpaRepository<AppUser,Long>{
    public List<AppUser> findAllByUserTypeTitle(String title);
    public AppUser findOneByShortName(String shortName);
}
