package com.express.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.express.bean.User;
import com.express.service.BaseService;
import com.express.service.UserService;

@Service
public class UserServiceImp extends BaseService implements UserService{

	public List<User> getUserList() {
		return getUserDao().getUserList();
	}

	public User getByUserName(String username) {
		return getUserDao().getByUserName(username);
	}

	public User getByUserId(String userid) {
		return getUserDao().getByUserId(userid);
	}

	public boolean addUser(User user) {
		return getUserDao().addUser(user);
	}

	public boolean updateUser(User user) {
		return getUserDao().updateUser(user);
	}

	public List<User> getMessageListbyUserId(String userid) {
		return getUserDao().getMessageListbyUserId(userid);
	}

	public boolean deleteUser(String userid) {
		return getUserDao().deleteUser(userid);
	}
	
	public String getUserIdbyLogin(String username, String passwd) {
		return getUserDao().getUserIdbyLogin(username, passwd);
	}

	@Override
	public int getLevelByUserid(String userid) {
		return getUserDao().getLevelByUserid(userid);
	}

}
