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
     *
     * @param userId common user Id
     * @return Template List
     */
    public List<Template> queryCommonUserTemplates(long userId);

    /**
     * query all user records count
     *
     * @param userId common user id
     * @return records count
     */
    public long getCommonUserRecordCount(long userId);

    /**
     * get common user incomming count
     *
     * @param userId user id
     * @return common user incomming count
     */
    public long getCommonUserIncommingCount(long userId);
}
