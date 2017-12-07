package zkspringmvc.dao;

import zkspringmvc.domain.Login;
import zkspringmvc.domain.User;

public interface UserDao {

	void register(User user);

	User validateUser(Login login);
}
