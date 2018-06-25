package com.lemo.springDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lemo.springDemo.model.User;
import com.lemo.springDemo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User checkLoginUser(String username,String pwd) {
		User user = userRepository.findByUsernameAndPwd(username,pwd);
		if(user!=null) {
			return user;
		}
		return null;
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	@Transactional
	public void addUser(User user) {
//		userRepository.save(new User(1,"admin","11111")); //测试事物
		userRepository.save(user);
	}
}
