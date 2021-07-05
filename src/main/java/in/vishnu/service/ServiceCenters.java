package in.vishnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.vishnu.dao.ServiceCentersRepository;
import in.vishnu.exception.ServiceException;
import in.vishnu.model.ServiceCenter;
import in.vishnu.validation.ServiceCenterValidation;
import in.vishnu.validation.NameValidation;

@Service
public class ServiceCenters {
	private ServiceCenters() {

	}

	@Autowired
	ServiceCentersRepository serviceCenterRepo;
	@Autowired
	ServiceCenterValidation serviceCenterValid;
	@Autowired
	NameValidation nameValidation;

	/**
	 * This method is used to get all service centers from database
	 * 
	 * @return
	 */
	public Iterable<ServiceCenter> getAllServiceCenters() {
		return serviceCenterRepo.findAll();
	}

	/**
	 * This method is used to add new service center
	 * 
	 * @param serviceCenter
	 */
	public void addServiceCenter(ServiceCenter serviceCenter) {
		try {
			if (serviceCenterValid.isServiceCenterNameValid(serviceCenter.getCenterName())
					&& nameValidation.isNameValid(serviceCenter.getLocation())) {
				serviceCenter.setCenterName(serviceCenter.getCenterName().toUpperCase());
				serviceCenter.setLocation(serviceCenter.getLocation().toUpperCase());
				serviceCenterRepo.save(serviceCenter);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
}
