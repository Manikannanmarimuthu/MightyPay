package com.qa.pojo.res;

import lombok.Data;

@Data
public class P2PTransfer_Res {
	private String responseCode;
	private String message;
	private String rrn;
	private String authidresp;
	private String txnUid;
	private String fromUserEntityId;
	private String fromWalletId;
	private String digitalAssetTypeCode;
	private String availableQuantity;
	private String platformRef;
	private String trxnTime;
	private String trxnTimeZone;
}
