package in.vishnu.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.vishnu.model.ServiceCenter;

@Repository
public interface ServiceCentersRepository extends CrudRepository<ServiceCenter, Integer> {

}
