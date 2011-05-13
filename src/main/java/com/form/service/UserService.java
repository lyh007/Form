package com.form.service;

import com.form.base.QueryParams;
import com.form.mapper.UserMapper;
import com.form.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * save
     *
     * @param user
     */
    public void save(User user) {
        userMapper.save(user);
    }

    /**
     * update
     *
     * @param user
     */
    public void update(User user) {
        userMapper.update(user);
    }

    /**
     * delete
     *
     * @param id
     */
    public void delete(Long id) {
        userMapper.delete(id);
    }

    /**
     * batch delete
     */
//    public void deleteByIds(String ids) {
//        userMapper.deleteByIds(ids);
//    }

    /**
     * get by id
     *
     * @param id
     * @return T
     */
    public User getById(Long id) {
        return userMapper.getById(id);
    }

    /**
     * search by page
     *
     * @param queryParams
     * @return T type List
     */
    public List<User> queryByPage(QueryParams<?> queryParams) {
        return userMapper.queryByPage(queryParams);
    }

    /**
     * get query count
     *
     * @param params parameters object
     * @return count
     */
    public int getTotalCount(Object params) {
        return userMapper.getTotalCount(params);
    }

    /**
     * get User information by userId
     *
     * @param userId userId
     * @return user information
     */
    public User getByUserId(String userId) {
        return userMapper.getByUserId(userId);
    }

    /**
     * Get a list of corporate users
     *
     * @param id company Id
     * @return user List
     */
    public List<User> getByUsersByCompanyId(Long id) {
        return userMapper.getByUsersByCompanyId(id);
    }
}
