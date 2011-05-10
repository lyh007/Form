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
}
