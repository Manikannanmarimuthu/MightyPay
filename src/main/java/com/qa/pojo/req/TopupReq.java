package com.qa.pojo.req;

import lombok.Setter;

@Setter
public class TopupReq {
	private String platformcode;
	private String userEntityId;
	private String walletId;
	private String digitalAssetTypeCode;
	private String quantity;
	private String terminalId;
	private String platformRef;
	private String timestamp;
	private String remarks;
}
