package com.form.dao.impl;

import com.form.dao.CompanyDao;
import com.form.dao.base.BaseDaoImpl;
import com.form.model.Company;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("companyDao")
public class CompanyDaoImpl extends BaseDaoImpl<Company> implements CompanyDao {
    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    /**
     * save an Comany
     *
     * @param company company infomation
     */
    public void saveCompany(Company company) {
        sqlSessionFactory.openSession().insert(getStatement(), company);
    }

    /**
     * get Comapny information by compnay Id
     *
     * @param companyId ID
     * @return company information
     */
    public Company getByCompanyId(String companyId) {
        Object obj = sqlSessionFactory.openSession().selectOne(getStatement(), companyId);
        if (obj != null && obj instanceof Company) {
            return (Company) obj;
        }
        return null;
    }
}
