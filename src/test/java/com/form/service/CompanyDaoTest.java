package com.form.service;

import com.form.base.BaseTestCase;
import com.form.model.Company;
import org.junit.Test;

/**
 * @author kevin
 * @version Revision: 1.00 Date: 11-5-13下午1:30
 * @Email liuyuhui007@gmail.com
 */
public class CompanyDaoTest extends BaseTestCase {
    private CompanyService companyService;

    public CompanyDaoTest() {
        companyService = (CompanyService) getApplicationContext().getBean("companyService");
    }

    @Test
    public void test() {
        Company company = companyService.getById(15L);
        if (company != null) {
            System.out.println("Name:" + company.getName());
        }
    }
}
