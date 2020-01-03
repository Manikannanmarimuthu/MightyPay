package com.mvi.qa.pojo.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "responseCode", "message", "rrn", "authidresp", "platformRef", "txnUid", "trxnTime",
		"digitalAssetTypeCode", "availableQuantity", "userEntityId", "walletId" })
public class Topup_Res {

	@JsonProperty("responseCode")
	public String responseCode;
	@JsonProperty("message")
	public String message;
	@JsonProperty("rrn")
	public String rrn;
	@JsonProperty("authidresp")
	public String authidresp;
	@JsonProperty("platformRef")
	public String platformRef;
	@JsonProperty("txnUid")
	public String txnUid;
	@JsonProperty("trxnTime")
	public String trxnTime;
	@JsonProperty("digitalAssetTypeCode")
	public String digitalAssetTypeCode;
	@JsonProperty("availableQuantity")
	public String availableQuantity;
	@JsonProperty("userEntityId")
	public String userEntityId;
	@JsonProperty("walletId")
	public String walletId;

	public Topup_Res() {

	}

}