package in.vishnu.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table(value="services")
public class Services {

	@Id
	@Column("service_id")
	private int id;
	@Column("service_name")
	private String service;
	@Column("service_charge")
	private int serviceCharge;

}
