package com.wso2telco.services.dep.sandbox.servicefactory.generic;

import com.wso2telco.core.dbutils.exception.ServiceError;
import com.wso2telco.services.dep.sandbox.dao.DaoFactory;
import com.wso2telco.services.dep.sandbox.dao.model.custom.RetrieveSenderAddressServiceRequestWrapper;
import com.wso2telco.services.dep.sandbox.dao.model.domain.ManageNumber;
import com.wso2telco.services.dep.sandbox.dao.model.domain.SenderAddress;
import com.wso2telco.services.dep.sandbox.dao.model.domain.User;
import com.wso2telco.services.dep.sandbox.servicefactory.AbstractRequestHandler;
import com.wso2telco.services.dep.sandbox.servicefactory.Returnable;
import org.apache.commons.logging.LogFactory;

import com.wso2telco.services.dep.sandbox.servicefactory.generic.RetrieveSenderAddressServiceResponseWrapper.SenderAddresses;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class RetrieveSenderAddressServiceServiceHandler extends AbstractRequestHandler<RetrieveSenderAddressServiceRequestWrapper> {

    private RetrieveSenderAddressServiceResponseWrapper responseWrapper;
    private RetrieveSenderAddressServiceRequestWrapper requestWrapper;
    private User user;

    {
        LOG = LogFactory.getLog(RetrieveSenderAddressServiceServiceHandler.class);
        userDAO = DaoFactory.getUserDAO();
    }

    @Override
    protected Returnable getResponseDTO() {
        return responseWrapper;
    }

    @Override
    protected List<String> getAddress() throws Exception {
        List<String> address = new ArrayList<>();
       user = userDAO.getUser(requestWrapper.getUserName());
       List<ManageNumber> manageNumber = user.getNumberList();
       for(ManageNumber number : manageNumber){
           address.add(number.getNumber());
       }
        return address;
    }

    @Override
    protected boolean validate(RetrieveSenderAddressServiceRequestWrapper wrapperDTO) throws Exception {
        return true;
    }

    @Override
    protected Returnable process(RetrieveSenderAddressServiceRequestWrapper extendedRequestDTO) throws Exception {

        if (responseWrapper.getRequestError() != null) {
            responseWrapper.setHttpStatus(Response.Status.BAD_REQUEST);
            return responseWrapper;
        }

        User user = extendedRequestDTO.getUser();
        List<String> senderAddressList = new ArrayList<String>();
        SenderAddresses senderAddressesObj = new SenderAddresses();
        List<SenderAddress> senderAddress = user.getSenderAddressList();

        try {

            if (senderAddress != null && !senderAddress.isEmpty()) {
                for (SenderAddress senderAddr : senderAddress) {
                    senderAddressList.add(senderAddr.getShortCode());
                }
            } else {
                responseWrapper.setRequestError(constructRequestError(
                        SERVICEEXCEPTION, ServiceError.INVALID_INPUT_VALUE,
                        "No any sender addresses are available"));
                responseWrapper.setHttpStatus(Response.Status.BAD_REQUEST);

                LOG.error("###USER### No any SenderAddresses are available");
            }
            senderAddressesObj.setSenderAddressList(senderAddressList);
            responseWrapper.setSenderAddressList(senderAddressesObj);
            responseWrapper.setHttpStatus(Response.Status.ACCEPTED);
        }catch(Exception ex){
            LOG.error(
                    "###USER### Error in processing send addresses retrieve request. ",
                    ex);
            responseWrapper.setHttpStatus(Response.Status.BAD_REQUEST);
        }

        return responseWrapper;
    }

    @Override
    protected void init(RetrieveSenderAddressServiceRequestWrapper extendedRequestDTO) throws Exception {
        requestWrapper = extendedRequestDTO;
        responseWrapper = new RetrieveSenderAddressServiceResponseWrapper();
    }

}
