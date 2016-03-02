package com.express.daoImp;

import java.util.List;

import org.apache.log4j.Logger;

import com.express.bean.MercBlacklist;
import com.express.dao.BaseDao;
import com.express.dao.MercBlacklistDao;

public class MercBlacklistDaoImp extends BaseDao implements MercBlacklistDao{
	
	private static final Logger logger = Logger.getLogger(MercBlacklistDaoImp.class);

	@SuppressWarnings("unchecked")
	public List<MercBlacklist> getBlackList() {
		List<MercBlacklist> blacklists = null;
		try {
			blacklists = getSqlMapClientTemplate().queryForList("getMercBlackList");
		} catch (Exception e) {
			logger.error("获取黑名单信息列表出错！" +  ",errMsg=" + e.getMessage());
		}
		return blacklists; 
	}

	public MercBlacklist getByMercName(String mercname) {
		MercBlacklist blacklist = null;
		try {
			blacklist = (MercBlacklist) getSqlMapClientTemplate().queryForObject("getMercByName",mercname);
		} catch (Exception e) {
			logger.error("根据电商名称获取黑名单信息出错！" +  ",errMsg=" + e.getMessage());
		}
		return blacklist;
	}

	public MercBlacklist getByMercId(String mercid) {
		MercBlacklist blacklist = null;
		try {
			blacklist = (MercBlacklist) getSqlMapClientTemplate().queryForObject("getMercByUserid",mercid);
		} catch (Exception e) {
			logger.error("根据mercid获取黑名单信息出错！" +  ",errMsg=" + e.getMessage());
		}
		return blacklist;
	}

	public boolean addBlackList(MercBlacklist blacklist) {
		String object = null;
		boolean flag = false;
		try {
			object =(String) getSqlMapClientTemplate().insert("addMercBlackList", blacklist);
		} catch (Exception e) {
			logger.error("添加黑名单信息出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public boolean updateBlackList(MercBlacklist blacklist) {
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("updateMercBlackList", blacklist);
		} catch (Exception e) {
			logger.error("更新黑名单信息出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public boolean deleteBlacklist(String mercid) {
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("deleteMercBlacklist", mercid);
		} catch (Exception e) {
			logger.error("删除指定黑名单成员出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	} 


}
