package com.express.service;

import java.util.List;

import com.express.bean.MercBlacklist;

public interface MercBlacklistService {

	/* ��ѯ�������б� */
    public List<MercBlacklist> getBlackList();
    
    /* ����mercname��ѯ������ */
    public MercBlacklist getByMercName(String mercname); 
    
    /* ����userid��ѯ������ */
    public MercBlacklist getByMercId(String mercid);  
    
    /* ����º��������� */
    public boolean addBlackList(MercBlacklist blacklist);
    
    /* ����ָ��������������Ϣ*/
    public boolean updateBlackList(MercBlacklist blacklist);
    
    /* ����mercidɾ��ָ���������û�*/
    public boolean deleteBlacklist(String mercid);
}
