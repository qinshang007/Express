package com.express.service;

import java.util.List;

import com.express.bean.User;

public interface UserService {
	
	/* ��ѯ���������û� */
    public List<User> getUserList();  
    
    /* ����username��ѯָ���û� */
    public User getByUserName(String username);  
    
    /* ����userid��ѯָ���û� */
    public User getByUserId(String userid); 
    
    /* ������û� */
    public boolean addUser(User user);
    
    /* �����û�*/
    public boolean updateUser(User user);  
    
    /* ɾ���û�*/
    public boolean deleteUser(String userid);
    
    /* ����userid��ȡ��ǰ�û�Ⱥ�������û��б�*/
    public List<User> getMessageListbyUserId(String userid);

    public String getUserIdbyLogin(String username, String passwd);
    
    public int getLevelByUserid(String userid);
}
