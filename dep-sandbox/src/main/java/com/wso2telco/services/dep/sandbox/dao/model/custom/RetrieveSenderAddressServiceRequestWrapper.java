package com.wso2telco.services.dep.sandbox.dao.model.custom;

public class RetrieveSenderAddressServiceRequestWrapper  extends RequestDTO{

    private static final long serialVersionUID = -3609438606243268257L;

    private String userName;

    public String getUserName() {
        return  userName;
    }

    public void setUserName(String  userName) {
        this. userName =  userName;
    }
}
