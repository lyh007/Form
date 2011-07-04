package com.form.service;

import com.form.base.BaseTestCase;
import com.form.model.User;
import com.form.model.UserStatus;
import com.form.util.REFNumberUtil;
import org.junit.Test;

/**
 * User Service Test
 */
public class UserServiceTest extends BaseTestCase {
    private UserService userService;

    public UserServiceTest() {
        userService = (UserService) getApplicationContext().getBean("userService");
    }

    @Test   //save User to DB
    public void testSaveUser() {
        User user = new User();
        user.setLoginId("persist");
        user.setEmail("admin@gmail.com");
        user.setFirstName("fist");
        user.setLastName("last");
        user.setMiddleInital("mid");
        user.setPassword("11111111");
        user.setRefNumber(REFNumberUtil.GenerateREFNumber());
        user.setStatus(UserStatus.ENABLED.ordinal());
        userService.save(user);
    }

    @Test   //Get User By row id
    public void testGetById() {
        User user = userService.getById(1L);
        if (user != null) {
            System.out.println("loginId:" + user.getLoginId());
            System.out.println("email:" + user.getEmail());
        }
    }

    @Test //Get User By Login Id
    public void testGetByLoginId() {
        String loginId = "persist";
        User user = userService.getByLoginId(loginId);
        if (user != null) {
            System.out.println("loginId:" + user.getLoginId());
            System.out.println("email:" + user.getEmail());
        }
    }

    @Test //Update User
    public void testUpdate() {
        String loginId = "persist";
        User user = userService.getByLoginId(loginId);
        if (user != null) {
            user.setEmail("root@gmail.com");
            user.setMiddleInital("mid1");
            user.setPassword("22222222");
            user.setRefNumber(REFNumberUtil.GenerateREFNumber());
            user.setStatus(UserStatus.DISABLED.ordinal());
            user.setLastName("liu");
            userService.update(user);
        }
    }

    @Test //Delete User
    public void testDelete() {
        userService.delete(1L);
    }
}
