package zkspringmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import zkspringmvc.dao.UserDao;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * ModelMap give us the ability to pass a collection of values
	 * @param map
	 * @param session
	 * @return
	 */
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String showIndex(ModelMap map, HttpSession session) {
		if (isLogged(session)) {
			map.addAttribute("userList", userDao.findAll());
			return "userlist";
		}
		return "redirect:login";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String showTest(Model model) {
		model.addAttribute("appname", "ZK");
		return "test";
	}
	
	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public String showFormUser(Model model) {
		return "usercrud";
	}
	
	
	private boolean isLogged(HttpSession session) {
		return session.getAttribute("logged") != null;
	}
}
