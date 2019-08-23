package com.wso2telco.services.dep.sandbox.service;


import com.wordnik.swagger.annotations.*;
import com.wso2telco.services.dep.sandbox.dao.model.custom.APIServiceCallRequestWrapperDTO;
import com.wso2telco.services.dep.sandbox.dao.model.custom.RetrieveSenderAddressServiceRequestWrapper;
import com.wso2telco.services.dep.sandbox.exception.SandboxException;
import com.wso2telco.services.dep.sandbox.servicefactory.RequestBuilderFactory;
import com.wso2telco.services.dep.sandbox.servicefactory.RequestHandleable;
import com.wso2telco.services.dep.sandbox.servicefactory.Returnable;
import com.wso2telco.services.dep.sandbox.util.RequestType;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/common/{v1}/utilities")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
@Api(value = "/{v1}/utilities", description = "Rest Service for Sandbox UI ")
public class CommonService {

    Log LOG = LogFactory.getLog(CommonService.class);

    @GET
    @Path("/senderAddress")
    @ApiOperation(value = "listSenderAddresses", notes = "List of available sender addresses", response = Response.class)
    @ApiImplicitParams({ @ApiImplicitParam(name = "sandbox", value = "username", required = true, dataType = "string", paramType = "header") })
    public Response getSenderAddressesList(@Context HttpServletRequest httpRequest) {
        RetrieveSenderAddressServiceRequestWrapper requestDTO = new RetrieveSenderAddressServiceRequestWrapper();
        requestDTO.setRequestType(RequestType.GENERIC);
        requestDTO.setHttpRequest(httpRequest);
        requestDTO.setUserName(httpRequest.getHeader("sandbox"));
        RequestHandleable handler = RequestBuilderFactory
                .getInstance(requestDTO);
        Returnable returnable = null;

        try {
            returnable = handler.execute(requestDTO);
            Response response = Response.status(returnable.getHttpStatus())
                    .entity(returnable.getResponse()).build();
            LOG.debug("GET Sender Address list RESPONSE : " + response);
            return response;
        } catch (SandboxException ex) {
            LOG.error(
                    "###USER### Error encountered in getSenderAddress Service : ",
                    ex);
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(ex.getErrorType().getCode() + " "
                            + ex.getErrorType().getMessage()).build();
        } catch (Exception ex) {
            LOG.error(
                    "###USER### Error encountered in RretriveSenderAddress list Service : ",
                    ex);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(ex.getMessage()).build();
        }}

}
