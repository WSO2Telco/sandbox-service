/*
 * Copyright (c) 2017, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wso2telco.services.dep.sandbox.servicefactory.payment;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wso2telco.services.dep.sandbox.dao.model.custom.RequestDTO;
import com.wso2telco.services.dep.sandbox.servicefactory.RequestHandleable;


public class PaymentRequestFactory {
    private static Log LOG = LogFactory.getLog(PaymentRequestFactory.class);

    // TODO: based on the json body need to implement request handle
    public static RequestHandleable getInstance(final RequestDTO requestDTO) {

        final String MAKE_PAYMENT = "payment";

        if (requestDTO.getRequestPath().contains(MAKE_PAYMENT)) {
            LOG.debug("LOADING MAKE PAYMENT SERVICE");
            return new PaymentRequestHandler();
        }

        return null;
    }
}
