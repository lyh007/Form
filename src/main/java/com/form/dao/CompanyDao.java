package com.form.dao;

import com.form.base.BaseInterface;
import com.form.model.Company;

public interface CompanyDao extends BaseInterface<Company> {
    /**
     * save an Comany
     *
     * @param company
     */
    public void saveCompany(Company company);
}
