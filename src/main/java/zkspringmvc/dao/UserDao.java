package zkspringmvc.dao;

import java.util.List;

import zkspringmvc.domain.Login;
import zkspringmvc.domain.User;

public interface UserDao {
	
	List<User> findAll();

	void register(User user);

	User validateUser(Login login);
}
