package com.form.service;

import com.form.base.BaseInterface;
import com.form.model.Company;

public interface CompanyService extends BaseInterface<Company> {
    /**
     * save an Comany
     *
     * @param company
     */
    public void saveCompany(Company company);
     /**
     * get Comapny information by compnay Id
     * @param companyId   ID
     * @return   company information
     */
    public Company getByCompanyId(String companyId);
}
