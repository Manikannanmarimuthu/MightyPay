package com.qa.json.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "platformCode", "userEntityId", "walletId", "digitalAssetTypeCode",
	"terminalId", "platformRef", "timestamp", "timeZone", "remarks" })
public class QueryWalletBalance {
	
	@JsonProperty("platformCode")
	private String platformCode;
	@JsonProperty("userEntityId")
	private String userEntityId;
	@JsonProperty("walletId")
	private String walletId;
	@JsonProperty("digitalAssetTypeCode")
	private String digitalAssetTypeCode;
	@JsonProperty("terminalId")
	private String terminalId;
	@JsonProperty("platformRef")
	private String platformRef;
	@JsonProperty("timestamp")
	private String timestamp;
	@JsonProperty("timeZone")
	private String timeZone;
	@JsonProperty("remarks")
	private String remarks;


	/**
	 * No args constructor for use in serialization
	 *
	 */
	public QueryWalletBalance() {
	}

	}

