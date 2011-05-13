package com.form.service;

import com.form.base.QueryParams;
import com.form.mapper.FormDataMapper;
import com.form.model.FormData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Form Service
 */
@Service("formDataService")
public class FormDataService {
    @Autowired
    private FormDataMapper formDataMapper;

    /**
     * save
     *
     * @param formData
     */
    public void save(FormData formData) {
        formDataMapper.save(formData);
    }

    /**
     * update
     *
     * @param formData
     */
    public void update(FormData formData) {
        formDataMapper.update(formData);
    }

    /**
     * delete
     *
     * @param id
     */
    public void delete(Long id) {
        formDataMapper.delete(id);
    }

    /**
     * batch delete
     */
//    public void deleteByIds(String ids) {
//        formDataMapper.deleteByIds(ids);
//    }

    /**
     * get by id
     *
     * @param id
     * @return T
     */
    public FormData getById(Long id) {
        return formDataMapper.getById(id);
    }

    /**
     * search by page
     *
     * @param queryParams
     * @return T type List
     */
    public List<FormData> queryByPage(QueryParams<?> queryParams) {
        return formDataMapper.queryByPage(queryParams);
    }

    /**
     * get query count
     *
     * @param params parameters object
     * @return count
     */
    public int getTotalCount(Object params) {
        return formDataMapper.getTotalCount(params);
    }
}
