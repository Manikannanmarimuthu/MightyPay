package com.qa.json.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "responseCode", "message", "rrn", "authidresp", "txnUid", "userEntityId", "walletId", "digitalAssetTypeCode",
	"availableQuantity", "merchantId", "merchantRef", "platformRef", "trxnTime","trxnTimeZone" })

public class Redeem_Res {
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
	@JsonProperty("digitalAssetTypeCode")
	private String digitalAssetTypeCode;
	@JsonProperty("availableQuantity")
	private String availableQuantity;
	@JsonProperty("merchantId")
	private String merchantId;
	@JsonProperty("merchantRef")
	private String merchantRef;
	@JsonProperty("platformRef")
	private String platformRef;
	@JsonProperty("trxnTime")
	private String trxnTime;
	@JsonProperty("trxnTimeZone")
	public String trxnTimeZone;


}
