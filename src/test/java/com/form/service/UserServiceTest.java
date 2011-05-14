package com.form.service;

import com.form.base.BaseTestCase;
import com.form.model.User;
import org.junit.Test;

import java.util.List;

/**
 * User Service Test
 */
public class UserServiceTest extends BaseTestCase {
    private UserService userService;

    public UserServiceTest() {
        userService = (UserService) getApplicationContext().getBean("userService");
    }

    @Test
    public void testGetUserByCompanyIdAndUserId() {
        User param = new User();
        param.setUserId("lyh007");
        param.setCompanyId(15L);
        User user = userService.getUserByCompanyIdAndUserId(param);
        if (user != null) {
            System.out.println("user ID:" + user.getId());
        }
    }

    @Test
    public void testGetSuperUsers() {
        //company id
        Long id = 15L;
        List<User> users = userService.getSuperUsers(id);
        if (users != null && users.size() > 0) {
            for (User user : users) {
                System.out.println("ID:" + user.getId() + " userId:" + user.getUserId());
            }
        }

    }
}
