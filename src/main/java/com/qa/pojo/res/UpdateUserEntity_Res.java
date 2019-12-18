package com.qa.pojo.res;

import lombok.Data;

@Data
public class UpdateUserEntity_Res {
	private String responseCode;
	private String message;
	private String rrn;
	private String authidresp;
	private String txnUid;
	private String userEntityId;
	private String trxnTime;
	private String trxnTimeZone;
}
