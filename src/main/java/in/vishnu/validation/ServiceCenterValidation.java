package in.vishnu.validation;

import java.util.List;

import org.springframework.stereotype.Component;

import in.vishnu.exception.AlreadyExistException;
import in.vishnu.exception.ValidationException;
import in.vishnu.model.ServiceCenter;

@Component
public class ServiceCenterValidation {
	private ServiceCenterValidation() {

	}

	/**
	 * returns true if service center name is valid
	 * 
	 * @param serviceCenterName
	 * @return boolean
	 */
	public boolean isServiceCenterNameValid(String serviceCenterName) {
		boolean isValid = true;
		if (serviceCenterName.trim().equals("") || serviceCenterName.length() < 3 || serviceCenterName.length() > 100) {
			throw new ValidationException("Center name not valid");
		}
		return isValid;
	}

	/**
	 * This method checks if service center already exists
	 * 
	 * @param list
	 * @param serviceCenter
	 * @return
	 */
	public boolean isServiceCenterExists(List<ServiceCenter> list, ServiceCenter serviceCenter) {
		boolean isExist = false;

		for (ServiceCenter listItem : list) {
			if (listItem.getCenterName().equalsIgnoreCase(serviceCenter.getCenterName())
					&& listItem.getLocation().equalsIgnoreCase(serviceCenter.getLocation())) {
				throw new AlreadyExistException("Service center already exists");
			}
		}

		return isExist;

	}
}
