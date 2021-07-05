package in.vishnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.vishnu.dto.Message;
import in.vishnu.dto.QuickBookDTO;
import in.vishnu.exception.ValidationException;
import in.vishnu.validation.RegisterNumValidation;

@RestController
public class QuickBookController {
	
	@Autowired
	RegisterNumValidation registrationNumber;
	
	@PostMapping("QuickBookAction")
	public ResponseEntity<Message> quickBook(@RequestBody QuickBookDTO userSelection){
		HttpStatus httpStatus = null;
		Message message = new Message();
		boolean isValid = registrationNumber.isRegistrationNumberValid(userSelection.getRegistrationNumber());
		try {
			if(isValid) {
				message.setInfoMessage("Choose your Service Center");
				httpStatus = HttpStatus.OK;
			}
			else {
				message.setErrorMessage("Invalid Registration Number");
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} catch (ValidationException e) {
			message.setErrorMessage("Bad Request");
			httpStatus = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(message, httpStatus);
	}

}
