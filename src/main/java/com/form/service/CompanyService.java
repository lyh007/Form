package com.form.service;

import com.form.base.QueryParams;
import com.form.mapper.CompanyMapper;
import com.form.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("companyService")
@Transactional
public class CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    /**
     * save
     *
     * @param company
     */
    public void save(Company company) {
        companyMapper.save(company);
    }

    /**
     * update
     *
     * @param company
     */
    public void update(Company company) {
        companyMapper.update(company);
    }

    /**
     * delete
     *
     * @param id
     */
    public void delete(Long id) {
        companyMapper.delete(id);
    }

    /**
     * batch delete
     */
//    public void deleteByIds(String ids) {
//        companyMapper.deleteByIds(ids);
//    }

    /**
     * get by id
     *
     * @param id
     * @return T
     */
    public Company getById(Long id) {
        return companyMapper.getById(id);
    }

    /**
     * search by page
     *
     * @param queryParams
     * @return T type List
     */
    public List<Company> queryByPage(QueryParams<?> queryParams) {
        return companyMapper.queryByPage(queryParams);
    }

    /**
     * get query count
     *
     * @param params parameters object
     * @return count
     */
    public int getTotalCount(Object params) {
        return companyMapper.getTotalCount(params);
    }

    /**
     * save an Comany
     *
     * @param company
     */
    public void saveCompany(Company company) {
        companyMapper.saveCompany(company);
    }

    /**
     * get Comapny information by compnay Id
     *
     * @param companyId ID
     * @return company information
     */
    public Company getByCompanyId(String companyId) {
        return companyMapper.getByCompanyId(companyId);
    }
}
