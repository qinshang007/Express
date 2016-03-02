package com.express.daoImp;

import java.util.List;

import org.apache.log4j.Logger;

import com.express.bean.Company;
import com.express.dao.BaseDao;
import com.express.dao.CompanyDao;

public class CompanyDaoImp extends BaseDao implements CompanyDao{
	
	private static final Logger logger = Logger.getLogger(CompanyDaoImp.class);  

	@SuppressWarnings("unchecked")
	public List<Company> getCompanyList() {
		List<Company> Company = null;
		try {
			Company = getSqlMapClientTemplate().queryForList("getCompanyList");
		} catch (Exception e) {
			logger.error("��ȡ��˾��Ϣ�б����" +  ",errMsg=" + e.getMessage());
		}
		return Company; 
	}

	public Company getByCompanyName(String compname) {
		Company company = null;
		try {
			company = (Company) getSqlMapClientTemplate().queryForObject("getByCompanyName",compname);
		} catch (Exception e) {
			logger.error("���ݹ�˾����ȡ��˾��Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		return company;
	}

	public Company getByCompanyId(String compid) {
		Company company = null;
		try {
			company = (Company) getSqlMapClientTemplate().queryForObject("getByCompanyId",compid);
		} catch (Exception e) {
			logger.error("���ݹ�˾id��ȡ��˾��Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		return company;  
	}

	public boolean addCompany(Company company) {
		String object = null;
		boolean flag = false;
		try {
			object =(String) getSqlMapClientTemplate().insert("addCompany", company);
		} catch (Exception e) {
			logger.error("��ӹ�˾��Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public boolean updateCompany(Company company) {
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("updateCompany", company);
		} catch (Exception e) {
			logger.error("���¹�˾��Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	public List<Company> getSubcompanyListByCompId(String compid) {
		List<Company> SubCompany = null;
		try {
			SubCompany = getSqlMapClientTemplate().queryForList("getSubcompanyListByCompId",compid);
		} catch (Exception e) {
			logger.error("��������˾id��ȡ�ӹ�˾��Ϣ�б����" +  ",errMsg=" + e.getMessage());
		}
		return SubCompany;
	}

	@SuppressWarnings("unchecked")
	public List<Company> getMainCompanyList() {
		List<Company> Company = null;
		try {
			Company = getSqlMapClientTemplate().queryForList("getMainCompanyList");
		} catch (Exception e) {
			logger.error("��ȡ��������˾��Ϣ�б����" +  ",errMsg=" + e.getMessage());
		}
		return Company; 
	}

	public boolean deleteComp(String compid) {
		Object object = null;
		boolean flag = false;
		try {
			object = getSqlMapClientTemplate().delete("deleteComp", compid);
		} catch (Exception e) {
			logger.error("ɾ����˾��Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

}
