package com.form.mapper;

import com.form.base.BaseInterface;
import com.form.model.Template;

import java.util.List;

public interface TemplateMapper extends BaseInterface<Template> {
    /**
     * Get Company Templates
     *
     * @param id company id
     * @return Template List
     */
    public List<Template> getTemplatesByCompanyId(Long id);

    /**
     * get Template by Company id and Template title
     *
     * @param template paramter template id,template title
     * @return Template information
     */
    public Template getTemplateByCompanyIdAndTemplateTitle(Template template);
}
