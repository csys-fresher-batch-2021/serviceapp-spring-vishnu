package in.vishnu.validation;

import org.springframework.stereotype.Component;

import in.vishnu.exception.ValidationException;

@Component
public class EmailValidation {
	private EmailValidation() {

	}

	/**
	 * returns true if email is valid
	 * 
	 * @param email
	 * @return boolean
	 */
	public boolean isEmailValid(String email) {
		boolean isValid = true;
		int indexOfAt = email.indexOf("@");
		int emailLength = email.trim().length();
		int frequencyOfAt = 0;
		try {
			for (int index = 0; index < emailLength; index++) {
				if (email.charAt(index) == '@') {
					frequencyOfAt++;
				}
			}
			if (emailLength == 0 || indexOfAt == 0 || indexOfAt == emailLength - 1 || frequencyOfAt > 1
					|| emailLength > 65 || email.charAt(indexOfAt + 1) == '.') {
				isValid = false;
			}
		} catch (Exception e) {
			throw new ValidationException("Email not valid");
		}
		return isValid;
	}

}
