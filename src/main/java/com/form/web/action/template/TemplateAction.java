package com.form.web.action.template;

import com.form.SystemConstants;
import com.form.base.OceanRuntimeException;
import com.form.model.Company;
import com.form.model.CompanyUser;
import com.form.model.Template;
import com.form.service.TemplateService;
import com.form.web.action.BaseAction;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
@Namespace("/template")
@Results({
       // @Result(name = "success", location = "/WEB-INF/jsp/company/company_welcome.jsp"),
        @Result(name = "success", location = "/WEB-INF/jsp/template/template_list.jsp"),
        @Result(name = "create", location = "/WEB-INF/jsp/template/template_create.jsp"),
        @Result(name = "preUpdate", location = "/WEB-INF/jsp/template/template_update.jsp")
})
public class TemplateAction extends BaseAction {
    @Autowired
    private TemplateService templateService;
    private List<Template> templates = new ArrayList<Template>();
    private Template template = new Template();

    @Override
    public String execute() throws Exception {
        HttpSession session = request.getSession();
        Company sessionCompany = (Company) session.getAttribute(SystemConstants.SESSION_COMPANY);
        CompanyUser user = (CompanyUser) session.getAttribute(SystemConstants.SESSION_COMPANY_USER);
        templates = templateService.getTemplatesByCompanyId(sessionCompany.getId());
        return SUCCESS;
    }

    public String preCreate() {
        return "create";
    }

    public String create() throws Exception {
        HttpSession session = request.getSession();
        Company company = (Company) session.getAttribute(SystemConstants.SESSION_COMPANY);
        CompanyUser user = (CompanyUser) session.getAttribute(SystemConstants.SESSION_COMPANY_USER);
        if (template == null) {
            addActionError("please input template infomation!");
            return "create";
        }
        if (template.getTitle() == null || template.getTitle().length() == 0) {
            addActionError("please input Template title!");
            return "create";
        }

        Template param = new Template();
        param.setCompanyId(company.getId());
        param.setTitle(template.getTitle());
        Template dbTemplate = templateService.getTemplateByCompanyIdAndTemplateTitle(param);
        if (dbTemplate != null) {
            addActionError("Template title has exist!");
            return "create";
        }
        template.setCompanyId(company.getId());
        template.setCreatedBy(user.getId());
        template.setLastModifiedBy(user.getId());
        templateService.save(template);
        return execute();
    }

    //prepare update Template
    public String preUpdate() throws Exception {
        if (template == null || template.getId() == 0L) {
            throw new OceanRuntimeException("delete template paramter is wrong!");
        }
        template = templateService.getById(template.getId());
        if (template == null) {
            throw new OceanRuntimeException("delete template not exists!");
        }
        return "preUpdate";
    }

    //update template CompanyUser
    public String update() throws Exception {
        HttpSession session = request.getSession();
        Company company = (Company) session.getAttribute(SystemConstants.SESSION_COMPANY);
        CompanyUser user = (CompanyUser) session.getAttribute(SystemConstants.SESSION_COMPANY_USER);
        if (template == null) {
            addActionError("please input template infomation!");
            return "preCreate";
        }
        if (template.getTitle() == null || template.getTitle().length() == 0) {
            addActionError("please input Template title!");
            return "preCreate";
        }
        if (template.getDescription() == null || template.getDescription().length() == 0) {
            addActionError("please input Template description!");
            return "preCreate";
        }

        Template dbTemplate = templateService.getById(template.getId());
        if (dbTemplate == null) {
            addActionError("modify Template not exist!!");
            return "preCreate";
        }
        dbTemplate.setTitle(template.getTitle());
        dbTemplate.setLastModifiedBy(user.getId());
        dbTemplate.setStatus(template.getStatus());
        templateService.update(dbTemplate);
        return execute();
    }

    //delete template CompanyUser
    public String delete() throws Exception {
        if (template == null || template.getId() == 0L) {
            throw new OceanRuntimeException("delete Template paramter is wrong!");
        }
        template = templateService.getById(template.getId());
        if (template == null) {
            throw new OceanRuntimeException("delete template  not exists!");
        }
        templateService.delete(template.getId());
        return execute();
    }

    public List<Template> getTemplates() {
        return templates;
    }

    public void setTemplates(List<Template> templates) {
        this.templates = templates;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }
}
