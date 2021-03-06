package com.form.model;

import com.form.base.DomainObject;

/**
 * common user
 */
public class User extends DomainObject {
    private String refNumber;//number and characters generated
    private String firstName;
    private String middleInital;
    private String lastName;
    private String email;
    private int status; //1 ( enabled), 0 (disabled)
    private String loginId;
    private String password;

    public User() {
    }

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
