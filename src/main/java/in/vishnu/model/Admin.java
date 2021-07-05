package in.vishnu.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("admin_details")
public class Admin {
	
	@Id
	@Column("s_no")
	private int adminId;
	
	@Column("admin_email")
	private String email;
	
	@Column("admin_password")
	private String password;
	
	

}
