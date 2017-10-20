package com.how2java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.mapper.UserMapper;
import com.how2java.pojo.User;
import com.how2java.service.UserService;

@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	UserMapper userMapper;

	
	public int login(User user) {
		// TODO Auto-generated method stub
		int count = userMapper.login(user);
		if(count!=0){
			return 1;
		}
		return 0;
	}
	
	
}
