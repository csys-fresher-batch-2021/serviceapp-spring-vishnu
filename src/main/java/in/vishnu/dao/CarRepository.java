package in.vishnu.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.vishnu.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {

}
