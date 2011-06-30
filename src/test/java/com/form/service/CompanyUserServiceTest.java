package com.form.service;

import com.form.base.BaseTestCase;
import com.form.model.CompanyUser;
import org.junit.Test;

import java.util.List;

/**
 * CompanyUser Service Test
 */
public class CompanyUserServiceTest extends BaseTestCase {
    private CompanyUserService companyUserService;

    public CompanyUserServiceTest() {
        companyUserService = (CompanyUserService) getApplicationContext().getBean("companyUserService");
    }

    @Test
    public void testGetUserByCompanyIdAndUserId() {
        CompanyUser param = new CompanyUser();
        param.setUserId("lyh007");
        param.setCompanyId(15L);
        CompanyUser user = companyUserService.getUserByCompanyIdAndUserId(param);
        if (user != null) {
            System.out.println("companyuser ID:" + user.getId());
        }
    }

    @Test
    public void testGetSuperUsers() {
        //company id
        Long id = 15L;
        List<CompanyUser> users = companyUserService.getSuperUsers(id);
        if (users != null && users.size() > 0) {
            for (CompanyUser user : users) {
                System.out.println("ID:" + user.getId() + " userId:" + user.getUserId());
            }
        }

    }
}
