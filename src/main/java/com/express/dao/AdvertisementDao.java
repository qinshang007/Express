package com.express.dao;

import java.util.List;

import com.express.bean.Advertisement;

public interface AdvertisementDao {
	
	/**
	 * 返回广告列表
	 * @return
	 */
	public List<Advertisement> getAdvertisementList();
	
	/**
	 * 添加广告
	 * @param add
	 * @return
	 */
	public boolean addAdvertisement(Advertisement add);
	
	/**
	 * 更新广告
	 * @param add
	 * @return
	 */
	public boolean updateAdvertisement(Advertisement add);
	
	/**
	 * 根据广告id获取广告
	 * @param id
	 * @return
	 */
	public Advertisement getAdvertisementById(int id);
	
	/**
	 * 删除广告
	 * @param id
	 * @return
	 */
	public boolean deleteAdvertisement(int id);
	
}
