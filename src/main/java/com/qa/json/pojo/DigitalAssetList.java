package com.qa.json.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "digitalAssetTypeCode", "digitalAssetName", "availableQuantity", "status" })

public class DigitalAssetList {

	@JsonProperty("digitalAssetTypeCode")
	private String digitalAssetTypeCode;
	@JsonProperty("digitalAssetName")
	private String digitalAssetName;
	@JsonProperty("availableQuantity")
	private String availableQuantity;
	@JsonProperty("status")
	private String status;
	
	public DigitalAssetList() {

	}

}
