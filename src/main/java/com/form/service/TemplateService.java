package com.form.service;

import com.form.base.QueryParams;
import com.form.mapper.TemplateMapper;
import com.form.model.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("templateService")
public class TemplateService {
    @Autowired
    private TemplateMapper templateMapper;

    /**
     * save
     *
     * @param template
     */
    public void save(Template template) {
        templateMapper.save(template);
    }

    /**
     * update
     *
     * @param template
     */
    public void update(Template template) {
        templateMapper.update(template);
    }

    /**
     * delete
     *
     * @param id
     */
    public void delete(Long id) {
        templateMapper.delete(id);
    }

    /**
     * batch delete
     */
//    public void deleteByIds(String ids) {
//        templateMapper.deleteByIds(ids);
//    }

    /**
     * get by id
     *
     * @param id
     * @return T
     */
    public Template getById(Long id) {
        return templateMapper.getById(id);
    }

    /**
     * search by page
     *
     * @param queryParams
     * @return T type List
     */
    public List<Template> queryByPage(QueryParams<?> queryParams) {
        return templateMapper.queryByPage(queryParams);
    }

    /**
     * get query count
     *
     * @param params parameters object
     * @return count
     */
    public int getTotalCount(Object params) {
        return templateMapper.getTotalCount(params);
    }
}
