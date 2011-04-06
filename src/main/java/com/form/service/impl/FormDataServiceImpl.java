package com.form.service.impl;

import com.form.base.QueryParams;
import com.form.model.FormData;
import com.form.service.FormDataService;
import com.form.dao.FormDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("formDataService")
/**
 * Form service implent
 */
@Transactional
public class FormDataServiceImpl implements FormDataService {
    @Autowired
    private FormDataDao formDataDao;

    @Override
    public void save(FormData entity) {
        formDataDao.save(entity);
    }

    @Override
    public void update(FormData entity) {
        formDataDao.update(entity);
    }

    @Override
    public void delete(Long id) {
        formDataDao.delete(id);
    }

    @Override
    public void deleteByIds(String ids) {
        formDataDao.deleteByIds(ids);
    }

    @Override
    public FormData getById(Long id) {
        return formDataDao.getById(id);
    }

    @Override
    public List<FormData> queryByPage(QueryParams<?> queryParams) {
        return formDataDao.queryByPage(queryParams);
    }

    @Override
    public int getTotalCount(Object params) {
        return formDataDao.getTotalCount(params);
    }
}
