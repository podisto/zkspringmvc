package zkspringmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import zkspringmvc.domain.Login;
import zkspringmvc.domain.User;
import zkspringmvc.service.UserService;

@Controller
public class LoginController {

	@Autowired
	public UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showIndex(HttpServletRequest request, HttpServletResponse response) {
		return "zul/index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(HttpServletRequest request, HttpServletResponse response) {
		return "login";
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public String loginProcess(HttpServletRequest request, HttpSession session) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username: " +username+ " | password: " +password);
		
		Login login = new Login();
		login.setUsername(username);
		login.setPassword(password);
		User user = userService.validateUser(login);
		
		if(null != user) {
			session.setAttribute("logged", true);
			return "redirect:users";
		}
		
		return "login";
	}
}
