package com.form.dao;

import com.form.base.Page;
import com.form.dao.FormDataDao;
import com.form.model.FormData;
import com.form.base.BaseTestCase;
import com.form.base.QueryParams;
import org.junit.Test;

import java.util.List;
public class FormDataDaoTest extends BaseTestCase {
    private FormDataDao formDataDao;

    public FormDataDaoTest() {
        formDataDao = (FormDataDao) getApplicationContext().getBean("formDataDao");
    }

    @Test
    //get
    public void testGetFormDataById() {
        FormData formData = formDataDao.getById(1L);
        System.out.println(formData.getText_20_1());
    }

    @Test
    //save
    public void testSaveFormData() {
        FormData formData = new FormData();
        formData.setText_20_1("a20_1");
        formData.setText_20_2("a20_2");
        formDataDao.save(formData);
    }

    @Test
    public void testUpdate() {
        FormData formData = formDataDao.getById(1L);
        formData.setText_20_1("modify text");
        formDataDao.update(formData);
    }

    @Test
    public void testPageQuery() {
        QueryParams<FormData> queryParams = new QueryParams<FormData>();
        Page paging = new Page(1, 2);
        queryParams.setPaging(paging);
        List<FormData> formDataList = formDataDao.queryByPage(queryParams);
        System.out.println("user size:" + formDataList.size());
    }

    @Test
    public void testDelete() {
        formDataDao.delete(2L);
    }

}
