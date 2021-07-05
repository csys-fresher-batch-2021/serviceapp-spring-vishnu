package in.vishnu.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table(value="service_centers")
public class ServiceCenter {
	@Id
	@Column("id")
	private int centerId;
	@Column("center_name")
	private String centerName;
	@Column("location")
	private String location;

	
}
