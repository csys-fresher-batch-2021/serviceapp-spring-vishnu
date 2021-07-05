package in.vishnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.vishnu.dao.ServicesRepository;
import in.vishnu.exception.ServiceException;
import in.vishnu.model.Services;
import in.vishnu.validation.ServiceValidaton;

@Service
public class CarServices {
	private CarServices() {

	}

	@Autowired
	ServicesRepository serviceRepo;
	@Autowired
	ServiceValidaton serviceValidation;

	/**
	 * This method is to get all service details from database
	 * 
	 * @return
	 */
	public Iterable<Services> getAllServices() {
		return serviceRepo.findAll();
	}

	/**
	 * This method is used to delete service
	 * 
	 * @param id
	 */
	public void deleteService(int id) {
		try {
			serviceRepo.deleteById(id);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * This method is used to add new service to database
	 * 
	 * @param service
	 */
	public void addService(Services service) {
		try {
			if (serviceValidation.serviceNameValidation(service.getService().toUpperCase())
					&& serviceValidation.serviceChargeValidation(service.getServiceCharge())) {
				service.setService(service.getService().toUpperCase());
				serviceRepo.save(service);
			}

		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
}
