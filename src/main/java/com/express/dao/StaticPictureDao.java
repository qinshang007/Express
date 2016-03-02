package com.express.dao;

import java.util.List;

import com.express.bean.StaticPicture;

public interface StaticPictureDao {
	
	/* ��ѯ����ͼƬ�б� */
    public List<StaticPicture> getPicturetList();
    
    /* ����id��ѯָ��ͼƬ*/
    public StaticPicture getById(String id); 
    
    /* ����ļ�*/
    public boolean addStaticPicture(StaticPicture staticPicture);
    
    /* �����ļ�*/
    public boolean updateStaticPicture(StaticPicture staticPicture);
    
    /* ɾ���ļ�*/
    public boolean deleteStaticPicture(String id);

}
