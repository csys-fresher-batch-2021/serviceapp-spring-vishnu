package in.vishnu.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table(value="cars")
public class Car {
	
	@Column("available_cars")
	private String carName;
	@Id
	@Column("car_id")
	private int carId;
}
