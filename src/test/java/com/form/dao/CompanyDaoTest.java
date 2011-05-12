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
        System.out.println("success!");
    }

    @Test
    //save
    public void testSaveCompanyWithReturn() {
        Company company = new Company();
        company.setCompanyId("hello");
        company.setEmail("hello@gmail.com");
        company.setName("Hello World");
        companyDao.saveCompany(company);
        System.out.println("companyId:" + company.getId());
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

    @Test
    public void testGetByCompanyId() {
        String companyId = "BBC";
        Company company = companyDao.getByCompanyId(companyId);
        if (company != null) {
            System.out.println("company information: id:" + company.getId());
        }
    }
}
