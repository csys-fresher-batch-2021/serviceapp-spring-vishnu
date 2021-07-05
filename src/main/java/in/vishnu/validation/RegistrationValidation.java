package in.vishnu.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.vishnu.exception.AlreadyExistException;
import in.vishnu.exception.ValidationException;
import in.vishnu.model.User;

@Component
public class RegistrationValidation {
	private RegistrationValidation() {

	}
	
	@Autowired
	NameValidation nameValidation;
	@Autowired
	ContactValidation contactValidation;
	@Autowired
	EmailValidation emailValidation;
	@Autowired
	PasswordValidation passwordValidation;
	

	/**
	 * This method is to validate registration
	 * 
	 * @param user
	 * @return
	 */
	public boolean isRegistrationValid(User user) {
		boolean isValidRegistration = false;
		if (nameValidation.isNameValid(user.getFirstName()) && nameValidation.isNameValid(user.getLastName())
				&& contactValidation.isValidContact(user.getContact()) && emailValidation.isEmailValid(user.getEmail())
				&& passwordValidation.isPasswordStrong(user.getPassword())) {
			isValidRegistration = true;
		} else {
			throw new ValidationException("Incorrect details");
		}
		return isValidRegistration;
	}

	/**
	 * This method is used to check if an existing user
	 * 
	 * @param carList
	 * @param car
	 * @return
	 */
	public boolean isUserExists(List<User> userList, User user) {
		boolean isExists = false;
		for (User listItem : userList) {
			if (listItem.getContact() == user.getContact() && listItem.getEmail().equalsIgnoreCase(user.getEmail())) {
				throw new AlreadyExistException("User already exists");
			}
		}
		return isExists;
	}
}
