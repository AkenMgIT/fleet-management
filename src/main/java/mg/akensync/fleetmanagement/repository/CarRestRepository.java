/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.akensync.fleetmanagement.repository;

import java.util.List;
import mg.akensync.fleetmanagement.model.Car;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author khemis_ratsimivony
 */
@RepositoryRestResource(collectionResourceRel = "cars", path = "cars")
public interface CarRestRepository extends PagingAndSortingRepository<Car, Long> {
}
