package com.how2java.mapper;
 
import com.how2java.pojo.User;
 
public interface UserMapper {
 
    /**
     * 登录
     * @param user
     * @return
     */
    public int login(User user);  
       
    
}