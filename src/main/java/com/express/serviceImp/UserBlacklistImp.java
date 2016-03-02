package com.express.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.express.bean.UserBlacklist;
import com.express.service.BaseService;
import com.express.service.UserBlacklistService;

@Service
public class UserBlacklistImp extends BaseService implements UserBlacklistService{

	@Override
	public List<UserBlacklist> getBlackList() {
		return getUserBlacklistDao().getBlackList();
	}

	@Override
	public UserBlacklist getByName(String name) {
		return getUserBlacklistDao().getByName(name);
	}

	@Override
	public boolean addBlackList(UserBlacklist blacklist) {
		return getUserBlacklistDao().addBlackList(blacklist);
	}

	@Override
	public boolean updateBlackList(UserBlacklist blacklist) {
		return getUserBlacklistDao().updateBlackList(blacklist);
	}

	@Override
	public boolean deleteBlacklist(String userid) {
		return getUserBlacklistDao().deleteBlacklist(userid);
	}

	@Override
	public UserBlacklist getByUserid(String userid) {
		return getUserBlacklistDao().getByUserid(userid);
	}

}
