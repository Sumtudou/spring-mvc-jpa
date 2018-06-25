package com.lemo.springDemo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lemo.springDemo.model.User;
import com.lemo.springDemo.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET) 
	public String login() {
		return "login";
	}
	@RequestMapping(method=RequestMethod.POST) 
	public String loginTo(HttpServletRequest request) {
		String username=request.getParameter("username");
        String pwd=request.getParameter("pwd");
        User user = userService.checkLoginUser(username, pwd);
        if(user!=null) {
        	request.getSession(true).setAttribute("user", user);
        	return "redirect:/hello/"+user.getUsername();
        }else {
        	return "login";
        }
	}
}
