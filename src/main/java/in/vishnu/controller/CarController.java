package in.vishnu.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.vishnu.dto.Message;
import in.vishnu.model.Car;
import in.vishnu.service.Cars;
import in.vishnu.validation.CarValidation;

@RestController
public class CarController {

	@Autowired
	Cars car;
	@Autowired
	CarValidation carValidation;

	@GetMapping("ListCars")
	public Iterable<Car> listAllCars() {
		return car.getAllCars();
	}

	@GetMapping("RemoveCar")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Message> removeCar(@Param("id") int id) {
		Message message = new Message();
		car.deleteCar(id);
		message.setInfoMessage("Car Removed");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@PostMapping("AddCar")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Message> addNewCar(@RequestBody Car newCar) {
		Message message = new Message();
		ArrayList<Car> newCarList = (ArrayList<Car>) car.getAllCars();
		if (!carValidation.isCarExists(newCarList, newCar)) {
			car.addNewCar(newCar);
			message.setInfoMessage("New car Added");
		}
		return new ResponseEntity<>(message, HttpStatus.OK);

	}

}
