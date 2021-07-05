package in.vishnu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.vishnu.dto.Message;
import in.vishnu.exception.ServiceException;
import in.vishnu.model.Admin;
import in.vishnu.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	AdminService adminService;

	@PostMapping("AdminLogin")
	public ResponseEntity<Message> adminLogin(@RequestBody Admin admin, HttpServletRequest request) {
		HttpStatus httpStatus;
		Message message = new Message();
		HttpSession session = request.getSession();
		String adminSession = adminService.adminLogin(admin.getEmail(), admin.getPassword());
		try {
			if (adminSession != null) {
				session.setAttribute("Role", "ADMIN");
				session.setAttribute("adminEmail", adminSession);				
				message.setInfoMessage("Admin Login SuccessFull");
				httpStatus = HttpStatus.OK;
			} else {
				message.setErrorMessage("Login Failed");
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} catch (ServiceException e) {
			message.setInfoMessage("Login Unsuccesfull");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(message, httpStatus);
	}
}
