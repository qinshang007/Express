package com.express.service;

import java.util.List;

import com.express.bean.OrganizationBlacklist;

public interface OrganizationBlacklistService {

	/* 查询黑名单列表 */
    public List<OrganizationBlacklist> getBlackList();
    
    /* 根据organizationname查询黑名单 */
    public OrganizationBlacklist getByOrganizationName(String organizationname); 
    
    /* 根据organizationid查询黑名单 */
    public OrganizationBlacklist getByOrganizationId(String organizationid);  
    
    /* 添加新黑名单快递单位 */
    public boolean addBlackList(OrganizationBlacklist blacklist);
    
    /* 更新指定黑名单快递单位信息*/
    public boolean updateBlackList(OrganizationBlacklist blacklist);
    
    /* 根据organizationid删除指定黑名单用户*/
    public boolean deleteBlacklist(String organizationid);
}
