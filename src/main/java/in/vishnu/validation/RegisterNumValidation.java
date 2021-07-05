package in.vishnu.validation;

import org.springframework.stereotype.Component;

import in.vishnu.exception.ValidationException;

@Component
public class RegisterNumValidation {
	private RegisterNumValidation() {

	}

	/**
	 * returns true if the registration number id valid
	 * 
	 * @param registrationNumber
	 * @return boolean
	 */
	public boolean isRegistrationNumberValid(String registrationNumber) {
		boolean isValid = true;
		try {
			int length = registrationNumber.length();

			char[] charArray = registrationNumber.trim().toCharArray();

			String lastFourCharacters = new StringBuilder().append(charArray[length - 1]).append(charArray[length - 2])
					.append(charArray[length - 3]).append(charArray[length - 4]).toString();
			StringBuilder lastFourDigits = new StringBuilder();
			for (int i = 0; i < lastFourCharacters.length(); i++) {
				if (lastFourCharacters.charAt(i) >= '0' && lastFourCharacters.charAt(i) <= '9') {
					String string = Character.toString(lastFourCharacters.charAt(i));
					lastFourDigits.append(string);
				} else {
					isValid = false;
				}
			}
			if (lastFourDigits.length() == 4) {
				int lastFourDigitInt = Integer.parseInt(lastFourDigits.toString());
				if (length == 0 || charArray[0] < 65 || charArray[0] > 90 || charArray[1] < 65 || charArray[1] > 90
						|| charArray[3] < 48 || charArray[3] > 57 || charArray[4] < 48 || charArray[4] > 57
						|| lastFourDigitInt < 0 || lastFourDigitInt >= 10000) {
					isValid = false;
				}
			} else {
				isValid = false;
			}
		} catch (NumberFormatException e) {
			throw new ValidationException("Registration number validation Failed");
		}

		return isValid;
	}

}
