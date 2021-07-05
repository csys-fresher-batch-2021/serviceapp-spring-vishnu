package in.vishnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.vishnu.dao.AdminRepository;
import in.vishnu.exception.ServiceException;
import in.vishnu.exception.ValidationException;
import in.vishnu.validation.EmailValidation;
import in.vishnu.validation.PasswordValidation;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepo;
	@Autowired
	EmailValidation emailValidation;
	@Autowired
	PasswordValidation passwordValidation;

	/**
	 * This method is used for admin login
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public String adminLogin(String email, String password) {
		String result = null;
		try {
			if (emailValidation.isEmailValid(email) && passwordValidation.isPasswordStrong(password)) {
				result = adminRepo.findByEmailAndPassword(email, password);
			}
		} catch (ValidationException e) {
			throw new ServiceException("Credential verification failed");
		}
		return result;
	}
}
