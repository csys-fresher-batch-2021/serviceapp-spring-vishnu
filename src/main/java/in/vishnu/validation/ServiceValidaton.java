package in.vishnu.validation;

import java.util.List;

import org.springframework.stereotype.Component;

import in.vishnu.exception.AlreadyExistException;
import in.vishnu.exception.ValidationException;
import in.vishnu.model.Services;

@Component
public class ServiceValidaton {

	private ServiceValidaton() {

	}

	/**
	 * validates the service name
	 * 
	 * @param serviceName
	 * @return
	 */
	public boolean serviceNameValidation(String serviceName) {
		boolean isValid = true;
		if (serviceName.length() == 0 || serviceName.trim().equals("")) {
			throw new ValidationException("Service name not valid");
		}
		for (int index = 0; index < serviceName.length(); index++) {
			if (serviceName.charAt(index) >= '0' && serviceName.charAt(index) <= '9') {
				throw new ValidationException("Service name not valid");
			}
		}
		return isValid;
	}

	/**
	 * This method verifies service charge
	 * 
	 * @param charge
	 * @return
	 */
	public boolean serviceChargeValidation(int charge) {
		boolean isValid = false;
		if (charge >= 0 && charge <= 100000) {
			isValid = true;
		} else {
			throw new ValidationException("Service charge not valid");
		}
		return isValid;
	}

	/**
	 * This method checks if the service already exist
	 * 
	 * @param list
	 * @param service
	 * @return
	 */
	public boolean isServiceExists(List<Services> list, Services service) {
		boolean isExist = false;
		for (Services listItem : list) {
			if (listItem.getService().equalsIgnoreCase(service.getService())) {
				throw new AlreadyExistException("Service Already Exists");
			}

		}
		return isExist;
	}
}
