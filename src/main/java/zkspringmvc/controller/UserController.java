package zkspringmvc.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import zkspringmvc.dao.UserDao;
import zkspringmvc.domain.User;

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
	
	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public String showFormUser(ModelMap map) {
		final HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("selectedRecord", null);
		hashMap.put("recordMode", "NEW");
		map.addAttribute("allmyvalues", hashMap);
		return "usercrud";
	}
	
	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public String registerProcess(Model model) {
		System.out.println("register...");
		return "usercrud";
	}
	
	private boolean isLogged(HttpSession session) {
		return session.getAttribute("logged") != null;
	}
}
