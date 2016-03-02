package com.express.daoImp;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.express.bean.RollingPicture;
import com.express.dao.BaseDao;
import com.express.dao.RollingPictureDao;

@Repository
public class RollingPictureDaoImp extends BaseDao implements RollingPictureDao{
	
	private static final Logger logger = Logger.getLogger(RollingPictureDaoImp.class);  

	@SuppressWarnings("unchecked")
	@Override
	public List<RollingPicture> getListBySequence(){
		List<RollingPicture> list= null;
		try {
			list = getSqlMapClientTemplate().queryForList("getListBySequence");
		} catch (Exception e) {
			logger.error("��ѯ�ļ��б���Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		return list; 
	}

	@Override
	public RollingPicture getById(String id){
		RollingPicture pic = null;
		try {
			pic = (RollingPicture) getSqlMapClientTemplate().queryForObject("getById",id);
		} catch (Exception e) {
			logger.error("����id��ȡ�ļ���Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		return pic; 
	}

	@Override
	 public boolean addRollingPicture(RollingPicture rollingPicture){
		String object = null;
		boolean flag = false;
		try {
			object =(String) getSqlMapClientTemplate().insert("addRollingPicture", rollingPicture);
		} catch (Exception e) {
			logger.error("����ļ���Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updateRollingPicture(RollingPicture rollingPicture){
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("updateRollingPicture", rollingPicture);
		} catch (Exception e) {
			logger.error("�����ļ���Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}
	
	@Override
	public boolean deleteRollingPicture(String id){
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("deleteRollingPicture", id);
		} catch (Exception e) {
			logger.error("ɾ���ļ���Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

}
