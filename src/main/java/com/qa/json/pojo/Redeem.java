package com.qa.json.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "platformCode", "userEntityId", "walletId", "digitalAssetTypeCode", "quantity", "merchantId", "merchantRef",
	"terminalId", "platformRef", "remarks", "timestamp", "timeZone" })
public class Redeem {
	
	@JsonProperty("platformCode")
	private String platformCode;
	@JsonProperty("userEntityId")
	private String userEntityId;
	@JsonProperty("walletId")
	private String walletId;
	@JsonProperty("digitalAssetTypeCode")
	private String digitalAssetTypeCode;
	@JsonProperty("quantity")
	private String quantity;
	@JsonProperty("merchantId")
	private String merchantId;
	@JsonProperty("merchantRef")
	private String merchantRef;
	@JsonProperty("terminalId")
	private String terminalId;
	@JsonProperty("platformRef")
	private String platformRef;
	@JsonProperty("remarks")
	private String remarks;
	@JsonProperty("timestamp")
	private String timestamp;
	@JsonProperty("timeZone")
	private String timeZone;



	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Redeem() {
	}

	}

