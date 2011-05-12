package com.form.dao;

import com.form.base.BaseTestCase;
import com.form.base.Page;
import com.form.base.QueryParams;
import com.form.model.User;
import org.junit.Test;

import java.util.List;

public class UserDaoTest extends BaseTestCase {
    private UserDao userDao;

    public UserDaoTest() {
        userDao = (UserDao) getApplicationContext().getBean("userDao");
    }

    @Test
    //get
    public void testGetUserById() {
        User user = userDao.getById(1L);
        if (user != null) {
            System.out.println(user.getLastName());
        }
    }

    @Test
    //save
    public void testSaveUser() {
        User user = new User();
        user.setCompanyId(2L);
        user.setEmail("admin@gmail.com");
        user.setFirstName("aa");
        user.setMiddleInital("bb");
        user.setLastName("cc");
        user.setPassword("111111");
        user.setStatus(0);
        user.setTitle("test title");
        user.setType(1);
        user.setUserId("admin");
        userDao.save(user);
    }

    @Test
    public void testUpdate() {
        User user = userDao.getById(2L);
        user.setFirstName("aa modify");
        userDao.update(user);
    }

    @Test
    public void testPageQuery() {
        QueryParams<User> queryParams = new QueryParams<User>();
        Page paging = new Page(1, 2);
        queryParams.setPaging(paging);
        List<User> userList = userDao.queryByPage(queryParams);
        System.out.println("user size:" + userList.size());
    }

    @Test
    public void testDelete() {
        userDao.delete(2L);
    }

    @Test
    public void testgetByUserId() {
        String userId = "";
        User user = userDao.getByUserId(userId);
        if (user != null) {
            System.out.println("user information: id:" + user.getId());
        }
    }

    @Test
    public void testGetByUsersByCompanyId() {
        long id = 15L;
        List<User> users = userDao.getByUsersByCompanyId(id);
        if (users != null && users.size() > 0) {
            for (User user : users) {
                System.out.println("Id:" + user.getId() + " userId:" + user.getUserId());
            }
        }
    }
}
