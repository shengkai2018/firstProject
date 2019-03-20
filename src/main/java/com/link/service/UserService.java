package com.link.service;

import com.link.pojo.User;

public interface UserService {

	/*
	 * 校验用户名与密码
	 */
	User checkLogin(String username,String password);
	
	/*
	 * 注册
	 */
	void regist(User user);
}
