package com.form.service;

import com.form.base.BaseTestCase;
import com.form.model.Template;
import org.junit.Test;

import java.util.List;

public class TemplateServiceTest extends BaseTestCase {
    private TemplateService templateService;

    public TemplateServiceTest() {
        templateService = (TemplateService) getApplicationContext().getBean("templateService");
    }

    @Test
    public void testGetTemplatesByCompanyId() {
        List<Template> templates = templateService.getTemplatesByCompanyId(1L);
        if (templates != null && templates.size() > 0) {
            for (Template template : templates) {
                System.out.println("template ID:" + template.getId() + " title:" + template.getTitle());
            }
        }
    }

    @Test
    public void testgetTemplateByCompanyIdAndTemplateTitle() {
        long id = 1L;
        String title = "form";
        Template param = new Template();
        param.setCompanyId(id);
        param.setTitle(title);
        Template dbTemplate = templateService.getTemplateByCompanyIdAndTemplateTitle(param);
        if (dbTemplate != null) {
            System.out.println("param ID:" + dbTemplate.getId());
        }
    }
}
