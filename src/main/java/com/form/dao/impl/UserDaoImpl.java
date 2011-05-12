package com.form.dao.impl;

import com.form.dao.UserDao;
import com.form.dao.base.BaseDaoImpl;
import com.form.model.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    /**
     * get User information by userId
     *
     * @param userId userId
     * @return user information
     */
    public User getByUserId(String userId) {
        Object obj = sqlSessionFactory.openSession().selectOne(getStatement(), userId);
        if (obj != null && obj instanceof User) {
            return (User) obj;
        }
        return null;
    }

    /**
     * Get a list of corporate users
     *
     * @param id company Id
     * @return user List
     */
    public List<User> getByUsersByCompanyId(Long id) {
        return sqlSessionFactory.openSession().selectList(getStatement(), id);
    }
}
