package in.vishnu.validation;

import org.springframework.stereotype.Component;

import in.vishnu.exception.ValidationException;

@Component
public class NameValidation {

	private NameValidation() {
		// Default Constructor
	}

	/**
	 * returns true if name is valid
	 * 
	 * @param name
	 * @return boolean
	 */
	public boolean isNameValid(String name) {
		boolean isValid = false;
		if (name.length() > 3 && name.length() < 20) {
			isValid = true;
		}
		if (isValid) {
			for (int index = 0; index < name.length(); index++) {
				if ((name.charAt(index) >= 65 && name.charAt(index) <= 90)
						|| (name.charAt(index) >= 97 && name.charAt(index) <= 122)) {
					isValid = true;
				} else {
					isValid = false;
				}
			}
		} else {
			throw new ValidationException("Name not valid");
		}

		return isValid;
	}

}