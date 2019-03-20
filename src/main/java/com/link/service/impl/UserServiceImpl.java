package com.link.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.link.dao.UserMapper;
import com.link.pojo.User;
import com.link.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User checkLogin(String username, String password) {
		User user=userMapper.findByUsername(username);
		if(user != null && user.getPassword().equals(password)){
			
			return user;
		}
		return null;
	}

	@Override
	public void regist(User user) {
		userMapper.register(user.getUsername(), user.getPassword());
		
	}

}
