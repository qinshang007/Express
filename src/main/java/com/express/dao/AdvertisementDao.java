package com.express.dao;

import java.util.List;

import com.express.bean.Advertisement;

public interface AdvertisementDao {
	
	/**
	 * ���ع���б�
	 * @return
	 */
	public List<Advertisement> getAdvertisementList();
	
	/**
	 * ��ӹ��
	 * @param add
	 * @return
	 */
	public boolean addAdvertisement(Advertisement add);
	
	/**
	 * ���¹��
	 * @param add
	 * @return
	 */
	public boolean updateAdvertisement(Advertisement add);
	
	/**
	 * ���ݹ��id��ȡ���
	 * @param id
	 * @return
	 */
	public Advertisement getAdvertisementById(int id);
	
	/**
	 * ɾ�����
	 * @param id
	 * @return
	 */
	public boolean deleteAdvertisement(int id);
	
}
