package in.vishnu.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.vishnu.dto.Message;
import in.vishnu.exception.ServiceException;
import in.vishnu.model.User;
import in.vishnu.service.UserService;
import in.vishnu.validation.RegistrationValidation;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	RegistrationValidation registerValidation;

	@PostMapping("/RegistrationServlet")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Message> register(@RequestBody User user) {
		Message message = new Message();
		HttpStatus httpStatus;
		ArrayList<User> newUserList = (ArrayList<User>) userService.getAllUsers();
		if (!registerValidation.isUserExists(newUserList, user)) {
			userService.addUser(user);
			message.setInfoMessage("Registration SuccessFull");
			httpStatus = HttpStatus.OK;
		} else {
			message.setErrorMessage("Registration Failed");
			httpStatus = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(message, httpStatus);

	}

	@GetMapping("/GetAllUser")
	public Iterable<User> findAll() {
		return userService.getAllUsers();
	}

	@PostMapping("UserLoginServlet")
	public ResponseEntity<Message> userLogin(@RequestBody User user, HttpServletRequest request) {
		HttpStatus httpStatus;
		Message message = new Message();
		try {
			HttpSession session = request.getSession();
			String sessionEmail = userService.userLogin(user.getEmail(), user.getPassword());
			if (sessionEmail != null) {
				session.setAttribute("Role", "USER");
				session.setAttribute("userEmail", sessionEmail);
				message.setInfoMessage("Login Successfull");
				httpStatus = HttpStatus.OK;
			} else {
				message.setErrorMessage("Login Failed");
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} catch (ServiceException e) {
			message.setErrorMessage("Login Failed");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

		}
		return new ResponseEntity<>(message, httpStatus);
	}

}
