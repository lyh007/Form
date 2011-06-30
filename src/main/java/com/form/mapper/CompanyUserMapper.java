package com.form.mapper;

import com.form.base.BaseInterface;
import com.form.model.CompanyUser;

import java.util.List;

public interface CompanyUserMapper extends BaseInterface<CompanyUser> {
    /**
     * get CompanyUser information by companyUserId
     *
     * @param companyUserId companyUserId
     * @return user information
     */
    public CompanyUser getByUserId(String companyUserId);

    /**
     * Get a list of corporate users
     *
     * @param id company Id
     * @return user List
     */
    public List<CompanyUser> getUsersByCompanyId(Long id);

    /**
     * get company CompanyUser
     *
     * @param companyUser company id and userId
     * @return user
     */
    public CompanyUser getUserByCompanyIdAndUserId(CompanyUser companyUser);

    /**
     * get company All SuperUsers
     *
     * @param id company id
     * @return user List
     */
    public List<CompanyUser> getSuperUsers(Long id);
}
