package in.vishnu.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.vishnu.dto.Message;
import in.vishnu.model.ServiceCenter;
import in.vishnu.service.ServiceCenters;
import in.vishnu.validation.ServiceCenterValidation;

@RestController
public class ServiceCenterController {

	@Autowired
	ServiceCenters center;
	@Autowired
	ServiceCenterValidation serviceCenterValid;

	@PostMapping("AddServiceCenter")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Message> addServiceCenter(@RequestBody ServiceCenter serviceCenter) {
		Message message = new Message();
		ArrayList<ServiceCenter> serviceCenterList = (ArrayList<ServiceCenter>) center.getAllServiceCenters();
		if (!serviceCenterValid.isServiceCenterExists(serviceCenterList, serviceCenter)) {
			center.addServiceCenter(serviceCenter);
			message.setInfoMessage("Service Center added");
		}
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
