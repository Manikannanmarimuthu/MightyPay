package com.qa.json.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "mobileno", "platformCode", "userentityidentitytype", "terminalId", "name", "userEntityIdentityType",
	"userentityidentity", "userEntityType", "address1", "address2", "address3",	"postalcode", "city", "countrycode", "timestamp", 
	"state", "emailid", "kycFlag", "timeZone" })
public class OnBoardUserEntity {
	
	@JsonProperty("platformCode")
	public String platformCode;
	@JsonProperty("terminalId")
	public String terminalId;
	@JsonProperty("name")
	public String name;
	@JsonProperty("mobileNo")
	public String mobileNo;
	@JsonProperty("userEntityIdentityType")
	public String userEntityIdentityType;
	@JsonProperty("userEntityIdentity")
	public String userEntityIdentity;
	@JsonProperty("userEntityType")
	public String userEntityType;
	@JsonProperty("address1")
	public String address1;
	@JsonProperty("address2")
	public String address2;
	@JsonProperty("address3")
	public String address3;
	@JsonProperty("postalCode")
	public String postalCode;
	@JsonProperty("city")
	public String city;
	@JsonProperty("countryCode")
	public String countryCode;
	@JsonProperty("timestamp")
	public String timestamp;
	@JsonProperty("timeZone")
	public String timeZone;
	@JsonProperty("state")
	public String state;
	@JsonProperty("emailId")
	public String emailId;
	@JsonProperty("kycFlag")
	public String kycFlag;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public OnBoardUserEntity() {
	}

	}

