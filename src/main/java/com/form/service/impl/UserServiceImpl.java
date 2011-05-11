package com.form.service.impl;


import com.form.base.QueryParams;
import com.form.dao.UserDao;
import com.form.model.User;
import com.form.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User service implements
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void save(User entity) {
        userDao.save(entity);
    }

    @Override
    public void update(User entity) {
        userDao.update(entity);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public void deleteByIds(String ids) {
        userDao.deleteByIds(ids);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public List<User> queryByPage(QueryParams<?> queryParams) {
        return userDao.queryByPage(queryParams);
    }

    @Override
    public int getTotalCount(Object params) {
        return userDao.getTotalCount(params);
    }
}
