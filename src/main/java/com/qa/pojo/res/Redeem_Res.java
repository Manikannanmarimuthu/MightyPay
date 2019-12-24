package com.qa.pojo.res;

import lombok.Data;

@Data
public class Redeem_Res {
	private String responseCode;
	private String message;
	private String rrn;
	private String authidresp;
	private String txnUid;
	private String userEntityId;
	private String walletId;
	private String digitalAssetTypeCode;
	private String availableQuantity;
	private String merchantId;
	private String merchantRef;
	private String platformRef;
	private String trxnTime;
	private String trxnTimeZone;
}
