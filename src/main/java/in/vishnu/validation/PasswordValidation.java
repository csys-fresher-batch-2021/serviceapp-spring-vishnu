package in.vishnu.validation;

import org.springframework.stereotype.Component;

import in.vishnu.exception.ValidationException;

@Component
public class PasswordValidation {
	private PasswordValidation() {

	}

	/**
	 * returns true if password is valid
	 * 
	 * @param password
	 * @return boolean
	 */
	public boolean isPasswordStrong(String password) {
		boolean isStrong = false;
		int passwordLength = password.length();
		try {
			if (password.equals(password.replace(" ", "")) && passwordLength > 8 && passwordLength < 50) {
				isStrong = true;
			}
		} catch (Exception e) {
			throw new ValidationException("Password not Valid");
		}

		return isStrong;
	}
}
