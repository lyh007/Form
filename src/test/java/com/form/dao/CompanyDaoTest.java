package com.form.dao;

import com.form.base.BaseTestCase;
import com.form.base.Page;
import com.form.base.QueryParams;
import com.form.model.Company;
import org.junit.Test;

import java.util.List;

public class CompanyDaoTest extends BaseTestCase {
    private CompanyDao companyDao;

    public CompanyDaoTest() {
        companyDao = (CompanyDao) getApplicationContext().getBean("companyDao");
    }

    @Test
    //get
    public void testGetCompanyById() {
        Company company = companyDao.getById(1L);
        if (company != null) {
            System.out.println(company.getName());
        }
    }

    @Test
    //save
    public void testSaveCompany() {
        Company company = new Company();
        company.setCompanyId("BBC");
        company.setEmail("admin@gmail.com");
        company.setName("Big BC");
        companyDao.save(company);
    }

    @Test
    public void testUpdate() {
        Company company = companyDao.getById(1L);
        company.setName("modify china");
        companyDao.update(company);
    }

    @Test
    public void testPageQuery() {
        QueryParams<Company> queryParams = new QueryParams<Company>();
        Page paging = new Page(1, 2);
        queryParams.setPaging(paging);
        List<Company> companyList = companyDao.queryByPage(queryParams);
        System.out.println("user size:" + companyList.size());
    }

    @Test
    public void testDelete() {
        companyDao.delete(1L);
    }
}
