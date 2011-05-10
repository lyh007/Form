package com.form.model;

import com.form.base.DomainObject;

import java.io.Serializable;

/**
 * Comany Persist Object
 */
public class Company extends DomainObject {
    private String companyId; //db FP_ID
    private String name;   //company name
    private String email; //company Email

    public Company() {
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
