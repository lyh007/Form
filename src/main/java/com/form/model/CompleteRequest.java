package com.form.model;

import com.form.base.DomainObject;

import java.util.Date;

/**
 * Complete Request Persist Object.
 */
public class CompleteRequest extends DomainObject {
    private String refNumber; //generate ten bit
    private long formId; //FormData id
    private long companyId; //Company id
    private long companyUserId; //Company User Id
    private long consumerId; //Consumer id
    private long formDataId;//FP_FORM_DATA_ID todo table
    private String note; //Note
    private int status; //1 (pending), 2 (accept), 3 (rejected)
    private Date requestDate; //Request Date

    public CompleteRequest() {
    }

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }

    public long getFormId() {
        return formId;
    }

    public void setFormId(long formId) {
        this.formId = formId;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public long getCompanyUserId() {
        return companyUserId;
    }

    public void setCompanyUserId(long companyUserId) {
        this.companyUserId = companyUserId;
    }

    public long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(long consumerId) {
        this.consumerId = consumerId;
    }

    public long getFormDataId() {
        return formDataId;
    }

    public void setFormDataId(long formDataId) {
        this.formDataId = formDataId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }
}
