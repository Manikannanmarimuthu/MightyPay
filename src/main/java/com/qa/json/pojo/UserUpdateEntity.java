package com.qa.json.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NoTagFilter.class)
@JsonPropertyOrder({ "platformcode", "userentityid", "terminalid", "timestamp", "userEntityDetails", "timeZone" })

public class UserUpdateEntity {

	@JsonProperty("platformcode")
	public String platformcode;
	@JsonProperty("userentityid")
	public String userentityid;
	@JsonProperty("terminalid")
	public String terminalid;
	@JsonProperty("timestamp")
	public String timestamp;
	@JsonProperty("userEntityDetails")
	public UserEntityDetails userEntityDetails;
	@JsonProperty("timeZone")
	public String timeZone;

	public UserUpdateEntity() {

	}

}
