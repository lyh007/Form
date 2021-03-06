package com.form.mapper;

import com.form.base.BaseInterface;
import com.form.model.FormData;

import java.util.List;

public interface FormDataMapper extends BaseInterface<FormData> {
    /**
     * query Formdata List
     *
     * @param id template id
     * @return FormData List
     */
    public List<FormData> queryByTemplate(long id);

    /**
     * Get Company records count
     *
     * @param companyId company id
     * @return records count
     */
    public long getCompanyRecordCount(long companyId);
}
