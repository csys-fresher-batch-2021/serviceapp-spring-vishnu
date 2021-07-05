package in.vishnu.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.vishnu.model.Services;

@Repository
public interface ServicesRepository extends CrudRepository<Services, Integer> {

}
