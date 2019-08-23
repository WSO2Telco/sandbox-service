package com.wso2telco.services.dep.sandbox.servicefactory.generic;


import com.wso2telco.services.dep.sandbox.servicefactory.AbstractReturnWrapperDTO;
import java.util.List;

public class RetrieveSenderAddressServiceResponseWrapper extends AbstractReturnWrapperDTO {


   private SenderAddresses senderAddresses;

    @Override
    public Object getResponse() {
        if (getRequestError() != null) {
            return getRequestError();
        }
        return getSenderAddressList();
    }


    public void setSenderAddressList(  SenderAddresses senderAddresses) {
        this.senderAddresses = senderAddresses;
    }

    public  SenderAddresses getSenderAddressList() {
        return senderAddresses;
    }

    public static class SenderAddresses {

        private List<String> senderAddressList;

        public void setSenderAddressList(List<String> senderAddressList) {
            this.senderAddressList = senderAddressList;
        }

        public List<String> getSenderAddressList() {
            return senderAddressList;
        }

    }


}
