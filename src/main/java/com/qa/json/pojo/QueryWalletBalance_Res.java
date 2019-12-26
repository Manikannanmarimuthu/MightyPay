package com.qa.json.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "responseCode", "message", "rrn", "authidresp", "txnUid", "userEntityId", "walletId", "digitalAssetList", "platformRef", "trxnTime","trxnTimeZone" })

public class QueryWalletBalance_Res {

	@JsonProperty("responseCode")
	private String responseCode;
	@JsonProperty("message")
	private String message;
	@JsonProperty("rrn")
	private String rrn;
	@JsonProperty("authidresp")
	private String authidresp;
	@JsonProperty("txnUid")
	private String txnUid;
	@JsonProperty("userEntityId")
	private String userEntityId;
	@JsonProperty("walletId")
	private String walletId;
	@JsonProperty("digitalAssetList")
	public DigitalAssetList digitalAssetList;
	@JsonProperty("platformRef")
	private String platformRef;
	@JsonProperty("trxnTime")
	public String trxnTime;
	@JsonProperty("trxnTimeZone")
	public String trxnTimeZone;

	public QueryWalletBalance_Res() {

	}

}
