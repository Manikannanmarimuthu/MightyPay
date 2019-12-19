package com.qa.pojo.res;

import lombok.Data;

@Data
public class Topup_Res {

	private String responseCode;
	private String message;
	private String rrn;
	private String authidresp;
	private String platformRef;
	private String txnUid;
	private String trxnTime;
	private String digitalAssetTypeCode;
	private String availableQuantity;
	private String userEntityId;
	private String walletId;
	private String trxnTimeZone;

}
