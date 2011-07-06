package com.form.service;

import com.form.base.QueryParams;
import com.form.mapper.UserMapper;
import com.form.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
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
     * get User by LoginId
     *
     * @param loginId Login String
     * @return User info
     */
    public User getByLoginId(String loginId) {
        return userMapper.getByLoginId(loginId);
    }

    /**
     * get User by refNumber
     *
     * @param refNumber REF Number
     * @return User info
     */
    public User getByREFNumber(String refNumber) {
        return userMapper.getByREFNumber(refNumber);
    }
}
