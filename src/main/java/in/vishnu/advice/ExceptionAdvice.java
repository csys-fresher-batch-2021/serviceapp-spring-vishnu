package in.vishnu.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import in.vishnu.dto.Message;
import in.vishnu.exception.AlreadyExistException;
import in.vishnu.exception.ServiceException;
import in.vishnu.exception.ValidationException;

@ControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(value = AlreadyExistException.class)
	public ResponseEntity<Message> alreadyExistException(AlreadyExistException exception) {
		Message message = new Message();
		message.setInfoMessage(exception.getMessage());
		return new ResponseEntity<>(message, HttpStatus.ALREADY_REPORTED);
	}

	@ExceptionHandler(value = ValidationException.class)
	public ResponseEntity<Message> validationException(ValidationException exception) {
		Message message = new Message();
		message.setErrorMessage(exception.getMessage());
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = ServiceException.class)
	public ResponseEntity<Message> serviceException(ServiceException exception) {
		Message message = new Message();
		message.setErrorMessage(exception.getMessage());
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}

}
