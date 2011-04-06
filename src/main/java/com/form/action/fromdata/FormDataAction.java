package com.form.action.fromdata;

import com.form.action.BaseAction;
import com.form.base.Page;
import com.form.base.QueryParams;
import com.form.model.FormData;
import com.form.service.FormDataService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
@Namespace("/formdata")
@Results({
        @Result(name = "step1", location = "/WEB-INF/jsp/formdata/page1.jsp"),
        @Result(name = "step2", location = "/WEB-INF/jsp/formdata/page2.jsp"),
        @Result(name = "list", location = "/WEB-INF/jsp/formdata/list.jsp"),
        @Result(name = "view", location = "/WEB-INF/jsp/formdata/view.jsp"),
        @Result(name = "result", location = "/WEB-INF/jsp/formdata/result.jsp")
}
)
public class FormDataAction extends BaseAction {
    @Autowired
    private FormDataService formDataService;
    private FormData formData = new FormData();
    private List<FormData> formDataList = new ArrayList<FormData>();
    private String[] text_20_1;
    private String[] text_20_12;
    private String[] text_50_14;
    private int submitType; //submit type: 1,Save & Exit;2,Save & Continue
    //first step

    public String step1() {
        return "step1";
    }
    //third step

    public String step2() {
        if (formData != null) {
            formData.setText_20_1(arrayToString(text_20_1));
            formData.setText_20_12(arrayToString(text_20_12));
            formData.setText_50_14(arrayToString(text_50_14));
            formDataService.save(formData);
        }
        if (submitType == 2) {
            return "step2";
        } else {
            return list();
        }
    }

    //save
    public String save() {
      //  return "result";
        return list();
    }

    public String list() {
        QueryParams<String> queryParams = new QueryParams<String>();
        if (records == 0) {
            records = formDataService.getTotalCount(null);
        }
        Page paging = new Page(currentPage, pageSize, records);
        queryParams.setPaging(paging);
        records = queryParams.getPaging().getRecords();
        formDataList = formDataService.queryByPage(queryParams);
        records = queryParams.getPaging().getRecords();
        return "list";
    }

    public String view() {
        if (formData != null) {
            if (formData.getId() != 0) {
                formData = formDataService.getById(formData.getId());
                if (formData.getText_20_1() != null && formData.getText_20_1().length() > 0) {
                    text_20_1 = formData.getText_20_1().split(",");
                }
                if (formData.getText_20_12() != null && formData.getText_20_12().length() > 0) {
                    text_20_12 = formData.getText_20_12().split(",");
                }
                if (formData.getText_50_14() != null && formData.getText_50_14().length() > 0) {
                    text_50_14 = formData.getText_50_14().split(",");
                }
            }
        }
        return "view";
    }

    private String arrayToString(String[] data) {
        StringBuffer str = new StringBuffer();
        if (data != null && data.length > 0) {
            for (int i = 0; i < data.length; i++) {
                if (i == data.length - 1) {
                    str.append(data[i]);
                } else {
                    str.append(data[i]).append(",");
                }
            }
        }
        return str.toString();
    }

    public FormData getFormData() {
        return formData;
    }

    public void setFormData(FormData formData) {
        this.formData = formData;
    }

    public List<FormData> getFormDataList() {
        return formDataList;
    }

    public void setFormDataList(List<FormData> formDataList) {
        this.formDataList = formDataList;
    }

    public String[] getText_20_1() {
        return text_20_1;
    }

    public void setText_20_1(String[] text_20_1) {
        this.text_20_1 = text_20_1;
    }

    public FormDataService getFormDataService() {
        return formDataService;
    }

    public void setFormDataService(FormDataService formDataService) {
        this.formDataService = formDataService;
    }

    public String[] getText_20_12() {
        return text_20_12;
    }

    public void setText_20_12(String[] text_20_12) {
        this.text_20_12 = text_20_12;
    }

    public String[] getText_50_14() {
        return text_50_14;
    }

    public void setText_50_14(String[] text_50_14) {
        this.text_50_14 = text_50_14;
    }

    public int getSubmitType() {
        return submitType;
    }

    public void setSubmitType(int submitType) {
        this.submitType = submitType;
    }
}
