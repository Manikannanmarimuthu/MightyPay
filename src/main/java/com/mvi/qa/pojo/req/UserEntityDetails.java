package com.mvi.qa.pojo.req;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mvi.lib.utils.NoTagFilter;

@JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NoTagFilter.class)
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
}