package zkspringmvc.service;

import java.util.List;

import zkspringmvc.domain.Login;
import zkspringmvc.domain.User;

public interface UserService {
	
	List<User> findAll();
	
	void register(User user);

	User validateUser(Login login);

}
