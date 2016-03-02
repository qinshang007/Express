package com.express.service;

import java.util.List;

import com.express.bean.OrganizationBlacklist;

public interface OrganizationBlacklistService {

	/* ��ѯ�������б� */
    public List<OrganizationBlacklist> getBlackList();
    
    /* ����organizationname��ѯ������ */
    public OrganizationBlacklist getByOrganizationName(String organizationname); 
    
    /* ����organizationid��ѯ������ */
    public OrganizationBlacklist getByOrganizationId(String organizationid);  
    
    /* ����º�������ݵ�λ */
    public boolean addBlackList(OrganizationBlacklist blacklist);
    
    /* ����ָ����������ݵ�λ��Ϣ*/
    public boolean updateBlackList(OrganizationBlacklist blacklist);
    
    /* ����organizationidɾ��ָ���������û�*/
    public boolean deleteBlacklist(String organizationid);
}
