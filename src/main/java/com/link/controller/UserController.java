package com.link.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.link.pojo.User;
import com.link.service.UserService;

@Controller
//这里用了@SessionAttributes，可以直接把model中的user(也就key)放入其中,这样保证了session中存在user这个对象
@SessionAttributes("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/*
	 * 正常访问login页面
	 */
	@RequestMapping("/login")
	public String login(){
		
		return "login";
	}
	
	@RequestMapping("/checkLogin")
	public String checkLogin(User user,Model model){
		user=userService.checkLogin(user.getUsername(), user.getPassword());
		//若有user则添加到model里并跳转到成功页面
		if(user != null){
			model.addAttribute("user", user);
			return "index";
		}
		return null;
		
	}
	
	/*
	 * 注册
	 */
	@RequestMapping("/regist")
    public String regist(){
        return "regist";
    }

    @RequestMapping("/doRegist")
    public String doRegist(User user,Model model){
        
        userService.regist(user);
        return "index";
    }
}
