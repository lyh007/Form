package com.form.dao.impl;

import com.form.dao.FormDataDao;
import com.form.dao.base.BaseDaoImpl;
import com.form.model.FormData;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("formDataDao")
public class FormDataDaoImpl extends BaseDaoImpl<FormData> implements FormDataDao {
    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;
}
