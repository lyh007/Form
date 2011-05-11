package com.form.service.impl;

import com.form.base.QueryParams;
import com.form.dao.CompanyDao;
import com.form.model.Company;
import com.form.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Company service implements
 */
@Service("companyService")
@Transactional
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDao companyDao;

    @Override
    public void save(Company entity) {
        companyDao.save(entity);
    }

    @Override
    public void update(Company entity) {
        companyDao.update(entity);
    }

    @Override
    public void delete(Long id) {
        companyDao.delete(id);
    }

    @Override
    public void deleteByIds(String ids) {
        companyDao.deleteByIds(ids);
    }

    @Override
    public Company getById(Long id) {
        return companyDao.getById(id);
    }

    @Override
    public List<Company> queryByPage(QueryParams<?> queryParams) {
        return companyDao.queryByPage(queryParams);
    }

    @Override
    public int getTotalCount(Object params) {
        return companyDao.getTotalCount(params);
    }
    /**
     * save an Comany
     *
     * @param company
     */
    public void saveCompany(Company company){
        companyDao.saveCompany(company);
    }
}
