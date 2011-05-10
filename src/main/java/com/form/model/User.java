package com.form.model;

import com.form.base.DomainObject;

/**
 * User Persist Object
 */
public class User extends DomainObject {
    private String userId; //db FP_LOGIN_ID
    private long companyId;   //Company Id
    private String firstName;
    private String middleInital;
    private String lastName;
    private String title;
    private int status; //0:Disabled 1:Enabled
    private int type; //0:Super User 9:Read Only
    private String password;
    private String email;

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInital() {
        return middleInital;
    }

    public void setMiddleInital(String middleInital) {
        this.middleInital = middleInital;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
