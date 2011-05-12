package com.form.dao;

import com.form.base.BaseInterface;
import com.form.model.User;

public interface UserDao extends BaseInterface<User> {
    /**
     * get User information by userId
     *
     * @param userId userId
     * @return user information
     */
    public User getByUserId(String userId);
}
