package com.lemo.springDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lemo.springDemo.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByUsernameAndPwd(String username,String pwd);
}
