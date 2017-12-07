package zkspringmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import zkspringmvc.service.UserService;

@Controller
public class LoginController {

	@Autowired
	public UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showIndex(HttpServletRequest request, HttpServletResponse response) {
		return "index";
	}

	/*@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User user) {
		userService.register(user);
		return new ModelAndView("welcome", "firstname", user.getFirstname());
	}*/
}
