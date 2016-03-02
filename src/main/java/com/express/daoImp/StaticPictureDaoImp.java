package com.express.daoImp;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.express.bean.StaticPicture;
import com.express.dao.BaseDao;
import com.express.dao.StaticPictureDao;

@Repository
public class StaticPictureDaoImp extends BaseDao implements StaticPictureDao{
	
	private static final Logger logger = Logger.getLogger(StaticPictureDaoImp.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<StaticPicture> getPicturetList() {
		List<StaticPicture> list= null;
		try {
			list = getSqlMapClientTemplate().queryForList("getPicturetList");
		} catch (Exception e) {
			logger.error("��ѯͼƬ�б���Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		return list; 
	}

	@Override
	public StaticPicture getById(String id) {
		StaticPicture pic = null;
		try {
			pic = (StaticPicture) getSqlMapClientTemplate().queryForObject("getStaticPictureById",id);
		} catch (Exception e) {
			logger.error("����id��ȡͼƬ��Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		return pic; 
	}

	@Override
	public boolean addStaticPicture(StaticPicture staticPicture) {
		String object = null;
		boolean flag = false;
		try {
			object =(String) getSqlMapClientTemplate().insert("addStaticPicture", staticPicture);
		} catch (Exception e) {
			logger.error("���ͼƬ��Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updateStaticPicture(StaticPicture staticPicture) {
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("updateStaticPicture", staticPicture);
		} catch (Exception e) {
			logger.error("����ͼƬ��Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean deleteStaticPicture(String id) {
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("deleteStaticPicture", id);
		} catch (Exception e) {
			logger.error("ɾ��ͼƬ��Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}  

}
