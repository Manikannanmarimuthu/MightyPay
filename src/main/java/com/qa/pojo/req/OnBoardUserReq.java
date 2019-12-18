package com.qa.pojo.req;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OnBoardUserReq {
	private String platformCode;
	private String terminalId;
	private String name;
	private String mobileNo;
	private String userEntityIdentityType;
	private String userEntityIdentity;
	private String userEntityType;
	private String address1;
	private String postalCode;
	private String city;
	private String countryCode;
	private String timestamp;
	private String state;
	private String emailId;
	private String kycFlag;
}
