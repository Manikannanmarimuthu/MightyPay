package com.qa.json.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "responseCode", "message", "rrn", "authidresp", "txnUid", "fromUserEntityId", "fromWalletId", "digitalAssetTypeCode", "availableQuantity", "platformRef", "trxnTime","trxnTimeZone" })

public class P2PTransfer_Res {
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
	@JsonProperty("fromUserEntityId")
	private String fromUserEntityId;
	@JsonProperty("fromWalletId")
	private String fromWalletId;
	@JsonProperty("digitalAssetTypeCode")
	private String digitalAssetTypeCode;
	@JsonProperty("availableQuantity")
	private String availableQuantity;
	@JsonProperty("platformRef")
	private String platformRef;
	@JsonProperty("trxnTime")
	private String trxnTime;
	@JsonProperty("trxnTimeZone")
	public String trxnTimeZone;


}
