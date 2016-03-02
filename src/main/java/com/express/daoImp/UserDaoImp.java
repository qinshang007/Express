package com.express.daoImp;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.express.bean.Company;
import com.express.bean.User;
import com.express.dao.BaseDao;
import com.express.dao.UserDao;
import com.express.query.UserQuery;

@Repository
public class UserDaoImp extends BaseDao implements UserDao {

	private static final Logger logger = Logger.getLogger(UserDaoImp.class);

	@SuppressWarnings("unchecked")
	public List<User> getUserList() {
		List<User> users = null;
		try {
			users = getSqlMapClientTemplate().queryForList("getUserList");
		} catch (Exception e) {
			logger.error("��ȡ�û���Ϣ�б����" + ",errMsg=" + e.getMessage());
		}
		return users;
	}

	public User getByUserName(String username) {
		User user = null;
		try {
			user = (User) getSqlMapClientTemplate().queryForObject(
					"getUserByUserName", username);
		} catch (Exception e) {
			logger.error("�����û�������ȡ�û���Ϣ����" + ",errMsg=" + e.getMessage());
		}
		return user;
	}

	public User getByUserId(String userid) {
		User user = null;
		try {
			user = (User) getSqlMapClientTemplate().queryForObject(
					"getUserByUserId", userid);
		} catch (Exception e) {
			logger.error("�����û�id��ȡ�û���Ϣ����" + ",errMsg=" + e.getMessage());
		}
		return user;
	}

	public boolean addUser(User user) {
		String object = null;
		boolean flag = false;
		try {
			object = (String) getSqlMapClientTemplate().insert("addUser", user);
		} catch (Exception e) {
			logger.error("����û���Ϣ����" + ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public boolean updateUser(User user) {
		Object object = null;
		boolean flag = false;
		try {
			object = (Integer) getSqlMapClientTemplate().update("updateUser",
					user);
		} catch (Exception e) {
			logger.error("�����û���Ϣ����" + ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	@SuppressWarnings({ "unchecked", "null" })
	public List<User> getMessageListbyUserId(String userid) {
		User user = getByUserId(userid);
		int level = user.getLevel();
		try {
			if (level == 0) {
				return null;
			} else if (level == 1) {
				return getSqlMapClientTemplate().queryForList("getMessageListbyCompId", user.getCompid());
			}else if (level == 2) {
				List<Company> compList = getSqlMapClientTemplate().queryForList("getSubcompanyListByCompId",user.getCompid());
				List<User> userList = null;
				for (Company company : compList) {
					List<User> subList = getSqlMapClientTemplate().queryForList("getMessageListbyCompId",company.getCompid());
					userList.addAll(subList);
				}
				return userList;
			}else if (level == 3) {
				List<User> userList = getSqlMapClientTemplate().queryForList("getUserList");
				return userList;
			}
		} catch (Exception e) {
			logger.error("��ȡ��ǰuserid����ӦȺ�������û��б����" + ",errMsg="
					+ e.getMessage());
		}
		return null;
	}

	public boolean deleteUser(String userid) {
		Object object = null;
		boolean flag = false;
		try {
			object = getSqlMapClientTemplate().delete("deleteUser", userid);
		} catch (Exception e) {
			logger.error("ɾ���û���Ϣ����" + ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public String getUserIdbyLogin(String username, String passwd) {
		String userid= null;
		UserQuery userQuery = new UserQuery();
		userQuery.setUsername(username);
		userQuery.setPasswd(passwd);
		try {
			userid = (String) getSqlMapClientTemplate().queryForObject("getUserIdbyLogin", userQuery);
		} catch (Exception e) {
			logger.error("�����û��������ȡuserid��Ϣ����" + ",errMsg=" + e.getMessage());
		}
		return userid;
	}

	public int getLevelByUserid(String userid) {
		int level = 0;
		try {
			level = (int) getSqlMapClientTemplate().queryForObject("getLevelByUserid", userid);
		} catch (Exception e) {
			logger.error("����userid��ȡ�û�Ȩ����Ϣ����" + ",errMsg=" + e.getMessage());
		}
		return level;
	}

}
