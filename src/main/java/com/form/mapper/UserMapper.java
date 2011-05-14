package com.form.mapper;

import com.form.base.BaseInterface;
import com.form.model.User;

import java.util.List;

public interface UserMapper extends BaseInterface<User> {
    /**
     * get User information by userId
     *
     * @param userId userId
     * @return user information
     */
    public User getByUserId(String userId);

    /**
     * Get a list of corporate users
     *
     * @param id company Id
     * @return user List
     */
    public List<User> getUsersByCompanyId(Long id);

    /**
     * get company User
     *
     * @param user company id and userId
     * @return user
     */
    public User getUserByCompanyIdAndUserId(User user);

    /**
     * get company All SuperUsers
     *
     * @param id company id
     * @return user List
     */
    public List<User> getSuperUsers(Long id);
}
