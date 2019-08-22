package com.wso2telco.services.dep.sandbox.servicefactory.generic;


import com.wso2telco.services.dep.sandbox.dao.model.custom.RequestDTO;
import com.wso2telco.services.dep.sandbox.servicefactory.RequestHandleable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class GenericServiceFactory {

    private static Log LOG = LogFactory.getLog(GenericServiceFactory.class);

    public static RequestHandleable getInstance(RequestDTO requestDTO) {

        final String SENDER_ADDRESS = "senderAddress";


        if (requestDTO.getRequestPath().contains(SENDER_ADDRESS)
                && requestDTO.isGet()) {
            LOG.debug("LOADING SENDER ADDRESS LIST SERVICE CALL");
            return new RetrieveSenderAddressServiceServiceHandler();
        }
        LOG.debug("NO ANY SERVICE FOUND FOR REQUESTED PATH");
        return null;
    }
}
