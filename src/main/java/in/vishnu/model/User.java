package in.vishnu.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table(value = "user_details")
public class User {

	
	@Column("first_name")
	private String firstName;
	@Column("last_name")
	private String lastName;
	private long contact;
	private String email;
	private String password;
	@Id
	@Column("user_id")
	private int id; 

}
