package com.express.dao;

import java.util.List;

import com.express.bean.MercBlacklist;

public interface MercBlacklistDao {
	
	/* 查询黑名单列表 */
    public List<MercBlacklist> getBlackList();
    
    /* 根据mercname查询黑名单 */
    public MercBlacklist getByMercName(String mercname); 
    
    /* 根据userid查询黑名单 */
    public MercBlacklist getByMercId(String mercid);  
    
    /* 添加新黑名单电商 */
    public boolean addBlackList(MercBlacklist blacklist);
    
    /* 更新指定黑名单电商信息*/
    public boolean updateBlackList(MercBlacklist blacklist);
    
    /* 根据mercid删除指定黑名单用户*/
    public boolean deleteBlacklist(String mercid);

}
