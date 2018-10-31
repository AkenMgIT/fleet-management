/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.repository;

import java.util.List;
import mg.akensync.fleetmanagement.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author khemis_ratsimivony
 */
public interface UserTypeRepository extends JpaRepository<UserType,Long>{
    public List<UserType> findByTitle(String title);
    public UserType findOneByTitle(String title);
}
