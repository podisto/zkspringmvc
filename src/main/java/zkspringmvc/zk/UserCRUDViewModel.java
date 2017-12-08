package zkspringmvc.zk;

import java.util.HashMap;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.zkoss.bind.annotation.ExecutionParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.SpringUtil;

import zkspringmvc.config.ApplicationConfig;
import zkspringmvc.domain.User;
import zkspringmvc.service.UserService;

/**
 * Responsible for user CRUD operations
 * 
 * @author podisto
 *
 */
public class UserCRUDViewModel {

	@WireVariable
	private UserService userService;

	private User selectedUser;
	private String recordMode;

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	public String getRecordMode() {
		return recordMode;
	}

	public void setRecordMode(String recordMode) {
		this.recordMode = recordMode;
	}

	@SuppressWarnings("resource")
	@Init
	public void init(@ExecutionParam("allmyvalues") HashMap<String, Object> allmyvalues) {
		User user;
		this.recordMode = (String) allmyvalues.get("recordMode");
		user = (User) allmyvalues.get("selectedRecord");
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        userService = (UserService) context.getBean("userService");
		
		if (recordMode.equals("NEW")) {
			this.selectedUser = new User();
			System.out.println(this.selectedUser);
		}
		
		if (recordMode.equals("EDIT"))
			this.selectedUser = user;
	}
}
