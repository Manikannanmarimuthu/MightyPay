package com.qa.json.pojo;




import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"responseCode",
"message",
"rrn",
"authidresp",
"txnUid",
"fromUserEntityId",
"fromWalletId",
"digitalAssetTypeCode",
"availableQuantity",
"platformRef",
"trxnTime",
"trxnTimeZone"
})
public class P2PTransfer_Res {

@JsonProperty("responseCode")
public String responseCode;
@JsonProperty("message")
public String message;
@JsonProperty("rrn")
public String rrn;
@JsonProperty("authidresp")
public String authidresp;
@JsonProperty("txnUid")
public String txnUid;
@JsonProperty("fromUserEntityId")
public String fromUserEntityId;
@JsonProperty("fromWalletId")
public String fromWalletId;
@JsonProperty("digitalAssetTypeCode")
public String digitalAssetTypeCode;
@JsonProperty("availableQuantity")
public String availableQuantity;
@JsonProperty("platformRef")
public String platformRef;
@JsonProperty("trxnTime")
public String trxnTime;
@JsonProperty("trxnTimeZone")
public String trxnTimeZone;


public P2PTransfer_Res() {
	

}

}