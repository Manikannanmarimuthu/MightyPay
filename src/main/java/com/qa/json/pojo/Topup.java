package com.qa.json.pojo;


		import com.fasterxml.jackson.annotation.JsonInclude;
		import com.fasterxml.jackson.annotation.JsonProperty;
		import com.fasterxml.jackson.annotation.JsonPropertyOrder;

		@JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter=NoTagFilter.class)
		@JsonPropertyOrder({
		"platformCode",
		"userEntityId",
		"walletId",
		"digitalAssetTypeCode",
		"quantity",
		"terminalId",
		"platformRef",
		"timestamp",
		"remarks"
		})
		public class Topup {

		@JsonProperty("platformCode")
		public String platformCode;
		@JsonProperty("userEntityId")
		public String userEntityId;
		@JsonProperty("walletId")
		public String walletId;
		@JsonProperty("digitalAssetTypeCode")
		public String digitalAssetTypeCode;
		@JsonProperty("quantity")
		public String quantity;
		@JsonProperty("terminalId")
		public String terminalId;
		@JsonProperty("platformRef")
		public String platformRef;
		@JsonProperty("timestamp")
		public String timestamp;
		@JsonProperty("remarks")
		public String remarks;
		
		public Topup() {
		
		}

		
	}

