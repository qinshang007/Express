package com.express.dao;

import java.util.List;

import com.express.bean.UserBlacklist;

public interface UserBlacklistDao {
	/* 查询黑名单列表 */
    public List<UserBlacklist> getBlackList();
    
    /* 根据name查询黑名单 */
    public UserBlacklist getByName(String name); 
    
    /* 根据userid查询黑名单 */
    public UserBlacklist getByUserid(String userid);  
    
    /* 添加新黑名单人员 */
    public boolean addBlackList(UserBlacklist blacklist);
    
    /* 更新指定黑名单人员信息*/
    public boolean updateBlackList(UserBlacklist blacklist);
    
    /* 根据userid删除指定黑名单用户*/
    public boolean deleteBlacklist(String userid);
}
