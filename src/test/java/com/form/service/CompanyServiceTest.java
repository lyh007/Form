package com.form.service;

import com.form.base.BaseTestCase;
import com.form.model.Company;
import org.junit.Test;

public class CompanyServiceTest extends BaseTestCase {
    private CompanyService companyService;

    public CompanyServiceTest() {
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
