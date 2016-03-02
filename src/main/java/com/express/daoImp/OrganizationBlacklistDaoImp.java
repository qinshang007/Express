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
			logger.error("��ȡ��������Ϣ�б����" +  ",errMsg=" + e.getMessage());
		}
		return blacklists; 
	}

	@Override
	public OrganizationBlacklist getByOrganizationName(String organizationname) {
		OrganizationBlacklist blacklist = null;
		try {
			blacklist = (OrganizationBlacklist) getSqlMapClientTemplate().queryForObject("getOrganizationByName",organizationname);
		} catch (Exception e) {
			logger.error("���ݵ������ƻ�ȡ��������Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		return blacklist;
	}

	@Override
	public OrganizationBlacklist getByOrganizationId(String organizationid) {
		OrganizationBlacklist blacklist = null;
		try {
			blacklist = (OrganizationBlacklist) getSqlMapClientTemplate().queryForObject("getOrganizationByUserid",organizationid);
		} catch (Exception e) {
			logger.error("����mercid��ȡ��������Ϣ����" +  ",errMsg=" + e.getMessage());
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
			logger.error("��Ӻ�������Ϣ����" +  ",errMsg=" + e.getMessage());
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
			logger.error("���º�������Ϣ����" +  ",errMsg=" + e.getMessage());
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
			logger.error("ɾ��ָ����������Ա����" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}
}
