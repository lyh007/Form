package com.form.service;

import com.form.base.BaseInterface;
import com.form.model.User;

public interface UserService extends BaseInterface<User> {
     /**
     * get User information by userId
     *
     * @param userId userId
     * @return user information
     */
    public User getByUserId(String userId);
}
