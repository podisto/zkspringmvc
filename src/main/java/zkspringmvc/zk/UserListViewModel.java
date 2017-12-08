package zkspringmvc.zk;

import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;

import zkspringmvc.domain.User;

/**
 * Responsible for show users list
 * @author podisto
 *
 */
public class UserListViewModel {
	
	private List<User> userList = null;
	
	@Init
	public void init(@ExecutionParam("userList") List<User> userList) {
		this.userList = userList;
	}

	public List<User> getUserList() {
		return userList;
	}
}
