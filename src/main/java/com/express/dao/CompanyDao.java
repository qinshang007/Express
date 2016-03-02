package com.express.dao;

import java.util.List;

import com.express.bean.Company;

public interface CompanyDao {
	/* 查询公司列表 */
    public List<Company> getCompanyList();
    
    /* 根据主公司id查询对应子公司列表 */
    public List<Company> getSubcompanyListByCompId(String compid);
    
    /* 根据compname查询指定用户 */
    public Company getByCompanyName(String compname);  
    
    /* 根据compid查询指定用户 */
    public Company getByCompanyId(String compid); 
    
    /* 添加新公司 */
    public boolean addCompany(Company company);
    
    /* 更新公司信息*/
    public boolean updateCompany(Company company);
    
    /* 更新公司信息*/
    public List<Company> getMainCompanyList();
    
    /* 删除公司信息*/
    public boolean deleteComp(String compid);

}
