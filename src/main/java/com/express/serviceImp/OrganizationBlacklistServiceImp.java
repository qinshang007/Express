package com.express.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.express.bean.OrganizationBlacklist;
import com.express.service.BaseService;
import com.express.service.OrganizationBlacklistService;

@Service
public class OrganizationBlacklistServiceImp extends BaseService implements OrganizationBlacklistService{

	@Override
	public List<OrganizationBlacklist> getBlackList() {
		return getOrganizationBlacklistDao().getBlackList();
	}

	@Override
	public OrganizationBlacklist getByOrganizationName(String organizationname) {
		return getOrganizationBlacklistDao().getByOrganizationName(organizationname);
	}

	@Override
	public OrganizationBlacklist getByOrganizationId(String organizationid) {
		return getOrganizationBlacklistDao().getByOrganizationId(organizationid);
	}

	@Override
	public boolean addBlackList(OrganizationBlacklist blacklist) {
		return getOrganizationBlacklistDao().addBlackList(blacklist);
	}

	@Override
	public boolean updateBlackList(OrganizationBlacklist blacklist) {
		return getOrganizationBlacklistDao().updateBlackList(blacklist);
	}

	@Override
	public boolean deleteBlacklist(String organizationid) {
		return getOrganizationBlacklistDao().deleteBlacklist(organizationid);
	}

}
