package in.vishnu.validation;

import java.util.List;

import org.springframework.stereotype.Component;

import in.vishnu.exception.AlreadyExistException;
import in.vishnu.exception.ValidationException;
import in.vishnu.model.Car;

@Component
public class CarValidation {
	private CarValidation() {

	}

	/**
	 * returns true if name is valid
	 * 
	 * @param name
	 * @return boolean
	 */
	public boolean isCarNameValid(String name) {
		boolean isValid = false;
		if (name.length() > 3 && name.length() < 20) {
			isValid = true;
		}
		if (isValid) {
			for (int index = 0; index < name.length(); index++) {
				if ((name.charAt(index) >= 65 && name.charAt(index) <= 90)
						|| (name.charAt(index) >= 97 && name.charAt(index) <= 122)
						|| (name.charAt(index) >= 48 && name.charAt(index) <= 57)) {
					isValid = true;
				} else {
					isValid = false;
				}
			}
		} else {
			throw new ValidationException("Car name not valid");
		}

		return isValid;
	}

	/**
	 * This method checks if car already exists
	 * 
	 * @param carList
	 * @param car
	 * @return
	 */
	public boolean isCarExists(List<Car> carList, Car car) {
		boolean isExists = false;
		for (Car listItem : carList) {
			if (listItem.getCarName().equalsIgnoreCase(car.getCarName())) {
				throw new AlreadyExistException("Car already exists");
			}
		}
		return isExists;
	}

}
