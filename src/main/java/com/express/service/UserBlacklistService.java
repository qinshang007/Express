package com.express.service;

import java.util.List;

import com.express.bean.UserBlacklist;

public interface UserBlacklistService {
	/* ��ѯ�������б� */
    public List<UserBlacklist> getBlackList();
    
    /* ����name��ѯ������ */
    public UserBlacklist getByName(String name);  
    
    /* ����userid��ѯ������ */
    public UserBlacklist getByUserid(String userid);  
    
    /* ����º�������Ա */
    public boolean addBlackList(UserBlacklist blacklist);
    
    /* ����ָ����������Ա��Ϣ*/
    public boolean updateBlackList(UserBlacklist blacklist);
    
    /* ����useridɾ��ָ���������û�*/
    public boolean deleteBlacklist(String userid);

}
