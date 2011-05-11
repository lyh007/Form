package com.form.dao.impl;

import com.form.dao.TemplateDao;
import com.form.dao.base.BaseDaoImpl;
import com.form.model.Template;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("templateDao")
public class TemplateDaoImpl extends BaseDaoImpl<Template> implements TemplateDao {
    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;
}
