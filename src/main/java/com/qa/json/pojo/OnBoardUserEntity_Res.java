package com.qa.json.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "responseCode", "message", "rrn", "authidresp", "userEntityId", "txnUid", "trxnTime", "walletId" })

public class OnBoardUserEntity_Res {
	@JsonProperty("responseCode")
	public String responseCode;
	@JsonProperty("message")
	public String message;
	@JsonProperty("rrn")
	public String rrn;
	@JsonProperty("authidresp")
	public String authidresp;
	@JsonProperty("userEntityId")
	public String userEntityId;
	@JsonProperty("txnUid")
	public String txnUid;
	@JsonProperty("trxnTime")
	public String trxnTime;
	@JsonProperty("walletId")
	public String walletId;
	public String trxnTimeZone;
}
