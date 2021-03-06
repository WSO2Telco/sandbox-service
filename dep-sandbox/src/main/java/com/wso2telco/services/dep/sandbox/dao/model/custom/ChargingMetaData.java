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
public class ChargingMetaData {

	private String onBehalfOf;

	private String purchaseCategoryCode;

	private String channel;

	public String getOnBehalfOf() {
		return onBehalfOf;
	}

	public void setOnBehalfOf(String onBehalfOf) {
		this.onBehalfOf = onBehalfOf;
	}

	public String getPurchaseCategoryCode() {
		return purchaseCategoryCode;
	}

	public void setPurchaseCategoryCode(String purchaseCategoryCode) {
		this.purchaseCategoryCode = purchaseCategoryCode;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append(" onBehalfOf : " + onBehalfOf);
		builder.append(" categoryCode : " + purchaseCategoryCode);
		builder.append(" channel : " + channel);

		return builder.toString();
	}

}
