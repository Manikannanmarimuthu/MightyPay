package com.qa.json.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
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

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public UserUpdateEntity() {
	}

	/**
	 *
	 * @param userEntityDetails
	 * @param timeZone
	 * @param terminalid
	 * @param platformcode
	 * @param userentityid
	 * @param timestamp
	 */
	public UserUpdateEntity(String platformcode, String userentityid, String terminalid, String timestamp,
			UserEntityDetails userEntityDetails, String timeZone) {
		super();
		this.platformcode = platformcode;
		this.userentityid = userentityid;
		this.terminalid = terminalid;
		this.timestamp = timestamp;
		this.userEntityDetails = userEntityDetails;
		this.timeZone = timeZone;
	}

}
