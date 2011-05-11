package com.form.service.impl;

import com.form.base.QueryParams;
import com.form.dao.TemplateDao;
import com.form.model.Template;
import com.form.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Template service implements
 */
@Service("templateService")
@Transactional
public class TemplateServiceImpl implements TemplateService {
    @Autowired
    private TemplateDao templateDao;

    @Override
    public void save(Template entity) {
        templateDao.save(entity);
    }

    @Override
    public void update(Template entity) {
        templateDao.update(entity);
    }

    @Override
    public void delete(Long id) {
        templateDao.delete(id);
    }

    @Override
    public void deleteByIds(String ids) {
        templateDao.deleteByIds(ids);
    }

    @Override
    public Template getById(Long id) {
        return templateDao.getById(id);
    }

    @Override
    public List<Template> queryByPage(QueryParams<?> queryParams) {
        return templateDao.queryByPage(queryParams);
    }

    @Override
    public int getTotalCount(Object params) {
        return templateDao.getTotalCount(params);
    }
}
