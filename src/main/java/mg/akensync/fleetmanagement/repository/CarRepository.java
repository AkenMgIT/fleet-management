/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.repository;

import mg.akensync.fleetmanagement.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author khemis_ratsimivony
 */

public interface CarRepository extends JpaRepository<Car,Long> {
    
}
