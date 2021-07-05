package in.vishnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.vishnu.dao.UserRepository;
import in.vishnu.exception.ServiceException;
import in.vishnu.exception.ValidationException;
import in.vishnu.model.User;
import in.vishnu.validation.EmailValidation;
import in.vishnu.validation.PasswordValidation;
import in.vishnu.validation.RegistrationValidation;

@Service
public class UserService {
	private UserService() {

	}

	@Autowired
	UserRepository userRepo;
	@Autowired
	RegistrationValidation registrationValid;
	@Autowired
	EmailValidation emailValid;
	@Autowired
	PasswordValidation passwordValid;

	/**
	 * This method is used to register new user
	 * 
	 * @param user
	 */
	public void addUser(User user) {

		try {
			if (registrationValid.isRegistrationValid(user)) {
				userRepo.save(user);
			}
		} catch (ValidationException e) {
			throw new ServiceException("Registration Failed");
		}
	}

	/**
	 * This method is to get all users from database
	 * 
	 * @return
	 */
	public Iterable<User> getAllUsers() {
		return userRepo.findAll();
	}

	/**
	 * This method is used for user login
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public String userLogin(String email, String password) {
		String sessionEmail = null;
		try {
			if (emailValid.isEmailValid(email) && passwordValid.isPasswordStrong(password)) {
				sessionEmail = userRepo.findByEmailAndPassword(email, password);
			}
		} catch (ValidationException e) {
			throw new ServiceException("Credentials not valid");
		}
		return sessionEmail;
	}

}
