package com.link.dao;

import org.apache.ibatis.annotations.Param;

import com.link.pojo.User;

public interface UserMapper {

	/*
	 * 登陆用户名，查找用户名和密码
	 */
	User findByUsername(String name);
	
	/*
	 * 注册用户
	 */
	void register(@Param("username")String username,@Param("password")String password);
}
