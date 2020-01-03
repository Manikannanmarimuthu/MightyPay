package com.mvi.qa.pojo.res;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateUserEntity_Res {
	@JsonProperty("responseCode")
	public String responseCode;
	@JsonProperty("message")
	public String message;
	@JsonProperty("rrn")
	public String rrn;
	@JsonProperty("txnUid")
	public String txnUid;
	@JsonProperty("trxnTime")
	public String trxnTime;

}