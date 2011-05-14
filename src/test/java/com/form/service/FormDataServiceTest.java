package com.form.service;

import com.form.base.BaseTestCase;
import com.form.model.FormData;
import org.junit.Test;

import java.util.List;

public class FormDataServiceTest extends BaseTestCase {
    private FormDataService formDataService;

    public FormDataServiceTest() {
        formDataService = (FormDataService) getApplicationContext().getBean("formDataService");
    }

    @Test
    public void testQueryByTemplate() {
        long templateId = 10L;
        List<FormData> formDataList = formDataService.queryByTemplate(templateId);
        if (formDataList != null) {
            for (FormData formdata : formDataList) {
                System.out.println("formdata: id:" + formdata.getId() + " template id:" + formdata.getTemplateId());
            }
        }
    }
}
