/*******************************************************************************
 * Copyright (c) 2015-2017, WSO2.Telco Inc. (http://www.wso2telco.com)
 *
 * All Rights Reserved. WSO2.Telco Inc. licences this file to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.wso2telco.services.dep.sandbox.servicefactory.smsmessaging.gateway;

import com.wso2telco.services.dep.sandbox.dao.model.custom.RequestDTO;
import com.wso2telco.services.dep.sandbox.servicefactory.RequestHandleable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class SMSRequestFactoryGateway {

    private static Log LOG = LogFactory.getLog(SMSRequestFactoryGateway.class);

    public static RequestHandleable getInstance(final RequestDTO requestDTO) {

        final String QUERY_DELIVERY_STATUS = "deliveryInfos";
        final String SEND_MT_SMS = "requests";
        final String RETRIVE_SMS = "registrations";
        final String OUTBOUND_REQUEST = "outbound";
        final String INBOUND_REQUEST = "inbound";
        final String SUBSCRIPTIONS = "subscriptions";


         if (requestDTO.getRequestPath().toLowerCase().contains(SEND_MT_SMS)
                && requestDTO.isPost()) {
            LOG.debug("LOADING SEND MT SMS SERVICE");

                return new SendMTSMSService();
            }

        else if (requestDTO.getRequestPath().toLowerCase().contains(RETRIVE_SMS)
                && requestDTO.isGet()) {
            LOG.debug("LOADING RETRIVE SMS SERVICE");

            return new ReceivingSMSHandler();
        }

         else if (requestDTO.getRequestPath().toLowerCase().contains(SUBSCRIPTIONS)
                 && requestDTO.isPost()) {
             LOG.debug("LOADING SUBSCRIPTIONS SMS SERVICE");

             return new SubscribeApplicationNotificationsHandler();
         }

         else if (requestDTO.getRequestPath().toLowerCase().contains(SUBSCRIPTIONS)
                 && requestDTO.isDelete()) {
             LOG.debug("LOADING SUBSCRIPTIONS SMS SERVICE");

             return new StopSubscriptionMessageNotificationHandler();
         }

       else {
             return null;
         }

    }
}