package com.express.daoImp;

import java.util.List;

import org.apache.log4j.Logger;

import com.express.bean.UserBlacklist;
import com.express.dao.BaseDao;
import com.express.dao.UserBlacklistDao;

public class UserBlacklistDaoImp extends BaseDao implements UserBlacklistDao {
	
	private static final Logger logger = Logger.getLogger(UserBlacklistDaoImp.class); 

	@SuppressWarnings("unchecked")
	public List<UserBlacklist> getBlackList() {
		List<UserBlacklist> blacklists = null;
		try {
			blacklists = getSqlMapClientTemplate().queryForList("getBlackList");
		} catch (Exception e) {
			logger.error("获取黑名单信息列表出错！" +  ",errMsg=" + e.getMessage());
		}
		return blacklists; 
	}

	public UserBlacklist getByName(String name) {
		UserBlacklist blacklist = null;
		try {
			blacklist = (UserBlacklist) getSqlMapClientTemplate().queryForObject("getByName",name);
		} catch (Exception e) {
			logger.error("根据姓名获取黑名单信息出错！" +  ",errMsg=" + e.getMessage());
		}
		return blacklist;
	}

	public boolean addBlackList(UserBlacklist blacklist) {
		String object = null;
		boolean flag = false;
		try {
			object =(String) getSqlMapClientTemplate().insert("addBlackList", blacklist);
		} catch (Exception e) {
			logger.error("添加黑名单信息出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public boolean updateBlackList(UserBlacklist blacklist) {
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("updateBlackList", blacklist);
		} catch (Exception e) {
			logger.error("更新黑名单信息出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean deleteBlacklist(String userid) {
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("deleteBlacklist", userid);
		} catch (Exception e) {
			logger.error("删除指定黑名单成员出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	@Override
	public UserBlacklist getByUserid(String userid) {
		UserBlacklist blacklist = null;
		try {
			blacklist = (UserBlacklist) getSqlMapClientTemplate().queryForObject("getByUserid",userid);
		} catch (Exception e) {
			logger.error("根据userid获取黑名单信息出错！" +  ",errMsg=" + e.getMessage());
		}
		return blacklist;
	}

}
