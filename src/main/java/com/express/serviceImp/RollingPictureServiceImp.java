package com.express.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.express.bean.RollingPicture;
import com.express.service.BaseService;
import com.express.service.RollingPictureService;

@Service
public class RollingPictureServiceImp extends BaseService implements RollingPictureService{

	@Override
	public List<RollingPicture> getListBySequence() {
		return getRollingpictureDao().getListBySequence();
	}

	@Override
	public RollingPicture getById(String id) {
		return getRollingpictureDao().getById(id);
	}

	@Override
	public boolean addRollingPicture(RollingPicture rollingPicture) {
		return getRollingpictureDao().addRollingPicture(rollingPicture);
	}

	@Override
	public boolean updateRollingPicture(RollingPicture rollingPicture) {
		return getRollingpictureDao().updateRollingPicture(rollingPicture);
	}

	@Override
	public boolean deleteRollingPicture(String id) {
		return getRollingpictureDao().deleteRollingPicture(id);
	}


}
