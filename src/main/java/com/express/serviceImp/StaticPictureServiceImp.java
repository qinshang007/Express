package com.express.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.express.bean.StaticPicture;
import com.express.service.BaseService;
import com.express.service.StaticPictureService;

@Service
public class StaticPictureServiceImp extends BaseService implements StaticPictureService{

	@Override
	public List<StaticPicture> getPicturetList() {
		return getStaticpictureDao().getPicturetList();
	}

	@Override
	public StaticPicture getById(String id) {
		return getStaticpictureDao().getById(id);
	}

	@Override
	public boolean addStaticPicture(StaticPicture staticPicture) {
		return getStaticpictureDao().addStaticPicture(staticPicture);
	}

	@Override
	public boolean updateStaticPicture(StaticPicture staticPicture) {
		return getStaticpictureDao().updateStaticPicture(staticPicture);
	}

	@Override
	public boolean deleteStaticPicture(String id) {
		return getStaticpictureDao().deleteStaticPicture(id);
	}

}
