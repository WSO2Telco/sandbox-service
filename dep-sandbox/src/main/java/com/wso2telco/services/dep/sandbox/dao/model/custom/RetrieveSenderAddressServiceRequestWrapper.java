package com.wso2telco.services.dep.sandbox.dao.model.custom;

public class RetrieveSenderAddressServiceRequestWrapper  extends RequestDTO{

    private static final long serialVersionUID = -3609438606243268257L;

    private String endUserId;

    public String getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(String endUserId) {
        this.endUserId = endUserId;
    }
}
