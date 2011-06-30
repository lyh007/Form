package com.form.service;

import com.form.base.QueryParams;
import com.form.mapper.CompanyUserMapper;
import com.form.model.CompanyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("companyUserService")
public class CompanyUserService {
    @Autowired
    private CompanyUserMapper companyUserMapper;

    /**
     * save
     *
     * @param companyUser
     */
    public void save(CompanyUser companyUser) {
        companyUserMapper.save(companyUser);
    }

    /**
     * update
     *
     * @param companyUser
     */
    public void update(CompanyUser companyUser) {
        companyUserMapper.update(companyUser);
    }

    /**
     * delete
     *
     * @param id
     */
    public void delete(Long id) {
        companyUserMapper.delete(id);
    }

    /**
     * batch delete
     */
//    public void deleteByIds(String ids) {
//        companyUserMapper.deleteByIds(ids);
//    }

    /**
     * get by id
     *
     * @param id
     * @return T
     */
    public CompanyUser getById(Long id) {
        return companyUserMapper.getById(id);
    }

    /**
     * search by page
     *
     * @param queryParams
     * @return T type List
     */
    public List<CompanyUser> queryByPage(QueryParams<?> queryParams) {
        return companyUserMapper.queryByPage(queryParams);
    }

    /**
     * get query count
     *
     * @param params parameters object
     * @return count
     */
    public int getTotalCount(Object params) {
        return companyUserMapper.getTotalCount(params);
    }

    /**
     * get CompanyUser information by companyUserId
     *
     * @param companyUserId companyUserId
     * @return user information
     */
    public CompanyUser getByUserId(String companyUserId) {
        return companyUserMapper.getByUserId(companyUserId);
    }

    /**
     * Get a list of corporate users
     *
     * @param id company Id
     * @return user List
     */
    public List<CompanyUser> getByUsersByCompanyId(Long id) {
        return companyUserMapper.getUsersByCompanyId(id);
    }

    /**
     * get company CompanyUser
     *
     * @param companyUser company id and userId
     * @return user
     */
    public CompanyUser getUserByCompanyIdAndUserId(CompanyUser companyUser) {
        return companyUserMapper.getUserByCompanyIdAndUserId(companyUser);
    }

    /**
     * get company All SuperUsers
     *
     * @param id company id
     * @return user List
     */
    public List<CompanyUser> getSuperUsers(Long id) {
        return companyUserMapper.getSuperUsers(id);
    }
}
