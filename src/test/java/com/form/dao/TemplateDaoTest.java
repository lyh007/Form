package com.form.dao;

import com.form.base.BaseTestCase;
import com.form.base.Page;
import com.form.base.QueryParams;
import com.form.model.Template;
import org.junit.Test;

import java.util.List;

public class TemplateDaoTest extends BaseTestCase {
    private TemplateDao templateDao;

    public TemplateDaoTest() {
        templateDao = (TemplateDao) getApplicationContext().getBean("templateDao");
    }

    @Test
    //get
    public void testGetTemplateById() {
        Template template = templateDao.getById(1L);
        if (template != null) {
            System.out.println(template.getTitle());
        }
    }

    @Test
    //save
    public void testSaveTemplate() {
        Template template = new Template();
        template.setTitle("china");
        template.setStatus(1);
        template.setCompanyId(2L);
        template.setCreatedBy(2L);
        template.setDescription("template description");
        template.setLastModifiedBy(2L);
        templateDao.save(template);
    }

    @Test
    public void testUpdate() {
        Template template = templateDao.getById(1L);
        template.setTitle("modify china");
        templateDao.update(template);
    }

    @Test
    public void testPageQuery() {
        QueryParams<Template> queryParams = new QueryParams<Template>();
        Page paging = new Page(1, 2);
        queryParams.setPaging(paging);
        List<Template> templateList = templateDao.queryByPage(queryParams);
        System.out.println("user size:" + templateList.size());
    }

    @Test
    public void testDelete() {
        templateDao.delete(2L);
    }
}
