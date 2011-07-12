package com.form.mapper;

import com.form.base.BaseInterface;
import com.form.model.CompleteRequest;
import com.form.model.Template;

import java.util.List;

public interface CompleteRequestMapper extends BaseInterface<CompleteRequest> {
    /**
     * change request status
     *
     * @param completeRequest id,status
     */
    public void changeStatus(CompleteRequest completeRequest);

    /**
     * query user accept request form templates
     * @param userId common user Id
     * @return Template List
     */
    public List<Template> queryCommonUserTemplates(long userId);
}
