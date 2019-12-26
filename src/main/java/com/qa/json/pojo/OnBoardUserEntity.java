package com.qa.json.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "mobileno", "platformCode", "userentityidentitytype", "terminalId", "name", "userEntityIdentityType",
	"userentityidentity", "userEntityType", "address1", "address2", "address3",	"postalcode", "city", "countrycode", "timestamp", 
	"state", "emailid", "kycFlag", "timeZone" })
public class OnBoardUserEntity {

	@JsonProperty("mobileNo")
	private String mobileNo;
	@JsonProperty("platformCode")
	private String platformCode;
	@JsonProperty("terminalId")
	private String terminalId;
	@JsonProperty("name")
	private String name;
	@JsonProperty("userEntityIdentityType")
	private String userEntityIdentityType;
	@JsonProperty("userEntityIdentity")
	private String userEntityIdentity;
	@JsonProperty("userEntityType")
	private String userEntityType;
	@JsonProperty("address1")
	private String address1;
	@JsonProperty("address2")
	private String address2;
	@JsonProperty("address3")
	private String address3;
	@JsonProperty("postalCode")
	private String postalCode;
	@JsonProperty("City")
	private String city;
	@JsonProperty("countryCode")
	private String countryCode;
	@JsonProperty("timestamp")
	private String timestamp;
	@JsonProperty("State")
	private String state;
	@JsonProperty("emailId")
	private String emailId;
	@JsonProperty("kycFlag")
	private String kycFlag;
	@JsonProperty("timeZone")
	private String timeZone;
	/**
	 * No args constructor for use in serialization
	 *
	 */
	public OnBoardUserEntity() {
	}

	/**
	 *
	 * @param platformCode
	 * @param terminalId
	 * @param name
	 * @param mobileNo
	 * @param userEntityIdentityType
	 * @param userEntityIdentity
	 * @param userEntityType
	 * @param address1
	 * @param address2
	 * @param address3
	 * @param postalCode
	 * @param city
	 * @param countryCode
	 * @param timestamp
	 * @param timeZone
	 * @param State
	 * @param emailId
	 * @param kycFlag
	 */
	
	
	public OnBoardUserEntity(String mobileNo, String platformCode, String terminalId, String name,
			String userEntityIdentityType, String userEntityIdentity, String userEntityType, String address1, String address2, String address3,
			String postalCode, String City, String countryCode, String timestamp, String State, String emailId, String kycFlag, String timeZone) {
		super();
		
		this.mobileNo = mobileNo;
		this.platformCode = platformCode;
		this.terminalId = terminalId;
		this.name = name;
	    this.userEntityIdentityType = userEntityIdentityType;
		this.userEntityIdentity = userEntityIdentity;
		this.userEntityType = userEntityType;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.postalCode = postalCode;
		this.city = City;
		this.countryCode = countryCode;
		this.timestamp = timestamp;
		this.state = State;
		this.emailId = emailId;
		this.kycFlag = kycFlag;
		this.timeZone = timeZone;
	}

			// TODO Auto-generated constructor stub
	}

