package in.vishnu.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.vishnu.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	/**
	 * This method is used for user login
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	@Query("SELECT email FROM user_details u WHERE u.email=:email AND u.password=:password")
	String findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
