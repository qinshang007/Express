package com.express.daoImp;

import java.util.List;

import org.apache.log4j.Logger;

import com.express.bean.Advertisement;
import com.express.dao.AdvertisementDao;
import com.express.dao.BaseDao;

public class AdvertisementDaoImp extends BaseDao implements AdvertisementDao{
	
	private static final Logger logger = Logger.getLogger(AdvertisementDaoImp.class);

	/**
	 * 返回广告列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Advertisement> getAdvertisementList() {
		// TODO Auto-generated method stub
		List<Advertisement> addList = null;
		try {
			addList = getSqlMapClientTemplate().queryForList("getAdvertisementList");
		} catch (Exception e) {
			logger.error("获取广告列表出错！" +  ",errMsg=" + e.getMessage());
		}
		return addList;
	}

	/**
	 * 添加广告
	 * @param add
	 * @return
	 */
	@Override
	public boolean addAdvertisement(Advertisement add) {
		// TODO Auto-generated method stub
		String object = null;
		boolean flag = false;
		try {
			object =(String) getSqlMapClientTemplate().insert("addAdvertisement", add);
		} catch (Exception e) {
			logger.error("添加广告出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 更新广告
	 * @param add
	 * @return
	 */
	@Override
	public boolean updateAdvertisement(Advertisement add) {
		// TODO Auto-generated method stub
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("updateAdvertisement", add);
		} catch (Exception e) {
			logger.error("更新广告出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 根据广告id获取广告
	 * @param id
	 * @return
	 */
	@Override
	public Advertisement getAdvertisementById(int id) {
		// TODO Auto-generated method stub
		Advertisement add = null;
		try {
			add = (Advertisement) getSqlMapClientTemplate().queryForObject("getAdvertisementById",id);
		} catch (Exception e) {
			logger.error("根据id获取广告出错！" +  ",errMsg=" + e.getMessage());
		}
		return add;
	}

	/**
	 * 删除广告
	 * @param id
	 * @return
	 */
	@Override
	public boolean deleteAdvertisement(int id) {
		// TODO Auto-generated method stub
		Object object = null;
		boolean flag = false;
		try {
			object = getSqlMapClientTemplate().delete("deleteAdvertisement", id);
		} catch (Exception e) {
			logger.error("删除广告出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

}
