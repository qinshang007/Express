package com.express.daoImp;

import java.util.List;

import org.apache.log4j.Logger;

import com.express.bean.OrganizationBlacklist;
import com.express.dao.BaseDao;
import com.express.dao.OrganizationBlacklistDao;

public class OrganizationBlacklistDaoImp extends BaseDao implements OrganizationBlacklistDao{
	
	private static final Logger logger = Logger.getLogger(OrganizationBlacklistDaoImp.class);

	@SuppressWarnings("unchecked")
	public List<OrganizationBlacklist> getBlackList() {
		List<OrganizationBlacklist> blacklists = null;
		try {
			blacklists = getSqlMapClientTemplate().queryForList("getOrganizationBlackList");
		} catch (Exception e) {
			logger.error("获取黑名单信息列表出错！" +  ",errMsg=" + e.getMessage());
		}
		return blacklists; 
	}

	@Override
	public OrganizationBlacklist getByOrganizationName(String organizationname) {
		OrganizationBlacklist blacklist = null;
		try {
			blacklist = (OrganizationBlacklist) getSqlMapClientTemplate().queryForObject("getOrganizationByName",organizationname);
		} catch (Exception e) {
			logger.error("根据电商名称获取黑名单信息出错！" +  ",errMsg=" + e.getMessage());
		}
		return blacklist;
	}

	@Override
	public OrganizationBlacklist getByOrganizationId(String organizationid) {
		OrganizationBlacklist blacklist = null;
		try {
			blacklist = (OrganizationBlacklist) getSqlMapClientTemplate().queryForObject("getOrganizationByUserid",organizationid);
		} catch (Exception e) {
			logger.error("根据mercid获取黑名单信息出错！" +  ",errMsg=" + e.getMessage());
		}
		return blacklist;
	}

	@Override
	public boolean addBlackList(OrganizationBlacklist blacklist) {
		String object = null;
		boolean flag = false;
		try {
			object =(String) getSqlMapClientTemplate().insert("addOrganizationBlackList", blacklist);
		} catch (Exception e) {
			logger.error("添加黑名单信息出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updateBlackList(OrganizationBlacklist blacklist) {
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("updateOrganizationBlackList", blacklist);
		} catch (Exception e) {
			logger.error("更新黑名单信息出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean deleteBlacklist(String organizationid) {
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("deleteOrganizationBlacklist", organizationid);
		} catch (Exception e) {
			logger.error("删除指定黑名单成员出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}
}
