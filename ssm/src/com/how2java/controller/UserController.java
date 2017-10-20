package com.how2java.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.how2java.pojo.User;
import com.how2java.service.UserService;
import com.how2java.util.MsgForAjax;

@Controller
@RequestMapping("User")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/index")
	public String index(){
		
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/login")
	public Map<String, Object> login(HttpServletRequest req, HttpServletResponse res){
		
		//设置响应头
	    res.setHeader("Access-Control-Allow-Origin", "*");
	    //告诉浏览器编码方式  
	    res.setHeader("Content-Type","text/html;charset=UTF-8" ); 
		String username=req.getParameter("userName");
	    String pwd=req.getParameter("passWord");
	    User user = new User();
	    user.setUserName(username);
	    user.setPassWord(pwd);
	    int count = userService.login(user);

	    if(1==count){
	         req.getSession().setAttribute("user",user.getUserName());
//	         String data = user.getUserName();
	         return MsgForAjax.sendData(user);
	    }else 
	    	return MsgForAjax.sendFail();
	 
		
	}
}























