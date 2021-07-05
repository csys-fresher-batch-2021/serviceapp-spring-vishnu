package in.vishnu.validation;

import org.springframework.stereotype.Component;

import in.vishnu.exception.ValidationException;

@Component
public class ContactValidation {
	private ContactValidation() {

	}

	/**
	 * returns true if contact number is valid
	 * 
	 * @param contact
	 * @return boolean
	 */
	public boolean isValidContact(long contact) {
		boolean isValid = false;
		String contactString = String.valueOf(contact);
		int contactLength = contactString.length();
		if (contactLength == 10
				&& (contactString.startsWith("7") || contactString.startsWith("8") || contactString.startsWith("9"))) {
			isValid = true;
		} else {
			throw new ValidationException("Contact not valid");
		}
		return isValid;
	}
}
