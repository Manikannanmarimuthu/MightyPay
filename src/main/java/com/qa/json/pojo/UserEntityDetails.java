package com.qa.json.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "mobileno", "userentityidentitytype", "userentityidentity", "address1", "address2", "address3",
		"postalcode", "city", "countrycode", "state", "emailid", "kycFlag" })
public class UserEntityDetails {

	@JsonProperty("mobileno")
	public String mobileno;
	@JsonProperty("userentityidentitytype")
	public String userentityidentitytype;
	@JsonProperty("userentityidentity")
	public String userentityidentity;
	@JsonProperty("address1")
	public String address1;
	@JsonProperty("address2")
	public String address2;
	@JsonProperty("address3")
	public String address3;
	@JsonProperty("postalcode")
	public String postalcode;
	@JsonProperty("city")
	public String city;
	@JsonProperty("countrycode")
	public String countrycode;
	@JsonProperty("state")
	public String state;
	@JsonProperty("emailid")
	public String emailid;
	@JsonProperty("kycFlag")
	public String kycFlag;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public UserEntityDetails() {
	}

	/**
	 *
	 * @param userentityidentity
	 * @param address3
	 * @param address2
	 * @param city
	 * @param address1
	 * @param postalcode
	 * @param countrycode
	 * @param kycFlag
	 * @param emailid
	 * @param mobileno
	 * @param state
	 * @param userentityidentitytype
	 */
	public UserEntityDetails(String mobileno, String userentityidentitytype, String userentityidentity, String address1,
			String address2, String address3, String postalcode, String city, String countrycode, String state,
			String emailid, String kycFlag) {
		super();
		this.mobileno = mobileno;
		this.userentityidentitytype = userentityidentitytype;
		this.userentityidentity = userentityidentity;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.postalcode = postalcode;
		this.city = city;
		this.countrycode = countrycode;
		this.state = state;
		this.emailid = emailid;
		this.kycFlag = kycFlag;
	}

}