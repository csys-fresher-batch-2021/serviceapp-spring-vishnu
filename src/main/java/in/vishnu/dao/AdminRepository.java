package in.vishnu.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import in.vishnu.model.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {

	/**
	 * This method is used for admin login
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	@Query("SELECT admin_email FROM admin_details a WHERE a.admin_email =:email AND a.admin_password=:password")
	String findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
