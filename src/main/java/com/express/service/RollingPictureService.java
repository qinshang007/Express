package com.express.service;

import java.util.List;

import com.express.bean.RollingPicture;

public interface RollingPictureService {
	/* ��ѯ�����ļ��б� */
    public List<RollingPicture> getListBySequence();
    
    /* ����objectid��ѯָ���ļ�*/
    public RollingPicture getById(String id); 
    
    /* ����ļ�*/
    public boolean addRollingPicture(RollingPicture rollingPicture);
    
    /* �����ļ�*/
    public boolean updateRollingPicture(RollingPicture rollingPicture);
    
    /* ɾ���ļ�*/
    public boolean deleteRollingPicture(String id);

}
