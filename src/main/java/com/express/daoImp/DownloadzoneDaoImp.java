package com.express.daoImp;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.express.bean.Downloadzone;
import com.express.dao.BaseDao;
import com.express.dao.DownloadzoneDao;

@Repository
public class DownloadzoneDaoImp extends BaseDao implements DownloadzoneDao{
	
	private static final Logger logger = Logger.getLogger(DownloadzoneDaoImp.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<Downloadzone> getFileList() {
		List<Downloadzone> list= null;
		try {
			list = getSqlMapClientTemplate().queryForList("getFileList");
		} catch (Exception e) {
			logger.error("��ѯ�ļ��б���Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		return list; 
	}

	@Override
	public Downloadzone getById(String id) {
		Downloadzone file = null;
		try {
			file = (Downloadzone) getSqlMapClientTemplate().queryForObject("getDownloadzoneById",id);
		} catch (Exception e) {
			logger.error("����id��ȡ�ļ���Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		return file; 
	}

	@Override
	public boolean addDownloadzone(Downloadzone downloadzone) {
		String object = null;
		boolean flag = false;
		try {
			object =(String) getSqlMapClientTemplate().insert("addDownloadzone", downloadzone);
		} catch (Exception e) {
			logger.error("����ļ���Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updateDownloadzone(Downloadzone downloadzone) {
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("updateDownloadzone", downloadzone);
		} catch (Exception e) {
			logger.error("�����ļ���Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean deleteDownloadzone(String id) {
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("deleteDownloadzone", id);
		} catch (Exception e) {
			logger.error("ɾ���ļ���Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

}
