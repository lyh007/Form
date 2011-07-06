package com.form.mapper;

import com.form.base.BaseInterface;
import com.form.model.User;

public interface UserMapper extends BaseInterface<User> {
    /**
     * get User by LoginId
     *
     * @param loginId Login String
     * @return User info
     */
    public User getByLoginId(String loginId);
     /**
     * get User by refNumber
     *
     * @param refNumber REF Number
     * @return User info
     */
    public User getByREFNumber(String refNumber);
}
