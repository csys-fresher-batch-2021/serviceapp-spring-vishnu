package in.vishnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.vishnu.dao.CarRepository;
import in.vishnu.exception.ServiceException;
import in.vishnu.model.Car;
import in.vishnu.validation.CarValidation;

@Service
public class Cars {
	private Cars() {

	}

	@Autowired
	CarRepository carRepo;
	@Autowired
	CarValidation carValidation;

	/**
	 * This method returns all cars from database
	 * 
	 * @return
	 */
	public Iterable<Car> getAllCars() {
		try {
			return carRepo.findAll();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * This method is used to add new car to database
	 * 
	 * @param newCar
	 */
	public void addNewCar(Car newCar) {
		try {
			if (carValidation.isCarNameValid(newCar.getCarName())) {
				newCar.setCarName(newCar.getCarName().toUpperCase());
				carRepo.save(newCar);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * This method is used to delete the car from database
	 * 
	 * @param id
	 */
	public void deleteCar(int id) {
		try {
			carRepo.deleteById(id);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
}
