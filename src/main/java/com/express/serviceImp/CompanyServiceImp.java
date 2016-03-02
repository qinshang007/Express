package com.express.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.express.bean.Company;
import com.express.service.BaseService;
import com.express.service.CompanyService;


@Service
public class CompanyServiceImp extends BaseService implements CompanyService {

	@Override
	public List<Company> getCompanyList() {
		return getCompanyDao().getCompanyList();
	}

	@Override
	public List<Company> getSubcompanyListByCompId(String compid) {
		return getCompanyDao().getSubcompanyListByCompId(compid);
	}

	@Override
	public Company getByCompanyName(String compname) {
		return getCompanyDao().getByCompanyName(compname);
	}

	@Override
	public Company getByCompanyId(String compid) {
		return getCompanyDao().getByCompanyId(compid);
	}

	@Override
	public boolean addCompany(Company company) {
		return getCompanyDao().addCompany(company);
	}

	@Override
	public boolean updateCompany(Company company) {
		return getCompanyDao().updateCompany(company);
	}
	
	@Override
	public List<Company> getMainCompanyList() {
		return getCompanyDao().getMainCompanyList();
	}

	@Override
	public boolean deleteComp(String compid) {
		return getCompanyDao().deleteComp(compid);
	}

}
