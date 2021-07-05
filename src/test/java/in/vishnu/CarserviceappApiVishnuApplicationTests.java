package in.vishnu;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import in.vishnu.validation.RegisterNumValidation;

@SpringBootTest
class CarserviceappApiVishnuApplicationTests {
	
	@Autowired
	RegisterNumValidation registerNumber;

	@Test
	void contextLoads() {
		boolean isValid = registerNumber.isRegistrationNumberValid("TN-90-PO-9089");
		assertTrue(isValid);
		
	}

}
