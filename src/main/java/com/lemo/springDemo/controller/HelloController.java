package com.lemo.springDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lemo.springDemo.model.User;
import com.lemo.springDemo.repository.UserRepository;
import com.lemo.springDemo.service.UserService;

@Controller
public class HelloController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/hello/{word}") 
	public String Hello(Model model,@PathVariable String word) {
		model.addAttribute("word",word);
		return "hello";
	}
	
	@RequestMapping("/getUser/{id}") 
	@ResponseBody
	public String getUser(Model model,@PathVariable int id) {
		return userRepository.findOne(id).toString();
	}
	
	@RequestMapping("/updateUser/{id}/{username}") 
	@ResponseBody
	public String updateUser(Model model,@PathVariable int id,@PathVariable String username) {
		User user = userRepository.findOne(id);
		user.setUsername(username);
		userRepository.save(user);
		return "success";
	}
	
	@RequestMapping("/userList") 
	public String userList(Model model) {
		List<User> userlist = userService.findAll();
		model.addAttribute("userlist",userlist);
		return "userList";
		
	}
	
	@RequestMapping("/addUser") 
	public String addUser(User user) {
		userService.addUser(user);
		return "redirect:/userList";
	}
}
