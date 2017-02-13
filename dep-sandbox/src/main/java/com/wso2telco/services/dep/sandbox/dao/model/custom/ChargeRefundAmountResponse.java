/*******************************************************************************
 * Copyright  (c) 2015-2016, WSO2.Telco Inc. (http://www.wso2telco.com) All Rights Reserved.
 * 
 * WSO2.Telco Inc. licences this file to you under  the Apache License, Version 2.0 (the "License");
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
package com.wso2telco.services.dep.sandbox.dao.model.custom;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_NULL)
public class ChargeRefundAmountResponse {
	
	private PaymentChargingInformation chargingInformation;

	private PaymentChargingMetaData chargingMetaData;

	private String totalAmountRefunded;

	public PaymentChargingInformation getChargingInformation() {
		return chargingInformation;
	}

	public void setChargingInformation(PaymentChargingInformation chargingInformation) {
		this.chargingInformation = chargingInformation;
	}

	public PaymentChargingMetaData getChargingMetaData() {
		return chargingMetaData;
	}

	public void setChargingMetaData(PaymentChargingMetaData chargingMetaData) {
		this.chargingMetaData = chargingMetaData;
	}

	public String getTotalAmountRefunded() {
		return totalAmountRefunded;
	}

	public void setTotalAmountRefunded(String totalAmountRefunded) {
		this.totalAmountRefunded = totalAmountRefunded;
	}
}
