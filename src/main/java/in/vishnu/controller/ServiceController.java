package in.vishnu.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.vishnu.dto.Message;

import in.vishnu.model.Services;
import in.vishnu.service.CarServices;
import in.vishnu.validation.ServiceValidaton;

@RestController
public class ServiceController {

	@Autowired
	CarServices carService;
	@Autowired
	ServiceValidaton serviceValidation;

	@GetMapping("ListServices")
	public Iterable<Services> listAllServices() {
		return carService.getAllServices();

	}

	@GetMapping("RemoveService")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Message> removeService(@RequestParam("id") int id) {
		carService.deleteService(id);
		Message message = new Message();
		message.setInfoMessage("Deleted");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@PostMapping("AddService")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Message> addService(@RequestBody Services service) {
		Message message = new Message();
		ArrayList<Services> serviceList = (ArrayList<Services>) carService.getAllServices();

		if (!serviceValidation.isServiceExists(serviceList, service)) {
			carService.addService(service);
			message.setInfoMessage("Service added");
		}
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
