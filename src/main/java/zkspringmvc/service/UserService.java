package zkspringmvc.service;

import zkspringmvc.domain.Login;
import zkspringmvc.domain.User;

public interface UserService {
	
	void register(User user);

	User validateUser(Login login);
}
