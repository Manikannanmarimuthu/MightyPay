package com.qa.pojo.res;

import lombok.Data;

@Data
public class Topup_Res {

	public String responseCode;
	public String message;
	public String rrn;
	public String authidresp;
	public String platformRef;
	public String txnUid;
	public String trxnTime;
	public String digitalAssetTypeCode;
	public String availableQuantity;
	public String userEntityId;
	public String walletId;
	public String trxnTimeZone;

}
