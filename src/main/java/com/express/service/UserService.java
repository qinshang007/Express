package com.express.service;

import java.util.List;

import com.express.bean.User;

public interface UserService {
	
	/* 查询表中所有用户 */
    public List<User> getUserList();  
    
    /* 根据username查询指定用户 */
    public User getByUserName(String username);  
    
    /* 根据userid查询指定用户 */
    public User getByUserId(String userid); 
    
    /* 添加新用户 */
    public boolean addUser(User user);
    
    /* 更新用户*/
    public boolean updateUser(User user);  
    
    /* 删除用户*/
    public boolean deleteUser(String userid);
    
    /* 根据userid获取当前用户群发短信用户列表*/
    public List<User> getMessageListbyUserId(String userid);

    public String getUserIdbyLogin(String username, String passwd);
    
    public int getLevelByUserid(String userid);
}
