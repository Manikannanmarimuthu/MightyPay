package com.qa.json.pojo;




import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"digitalAssetTypeCode",
"digitalAssetName",
"availableQuantity",
"status",

})

public class DigitalAssetListFields {

@JsonProperty("digitalAssetTypeCode")
public String digitalAssetTypeCode;
@JsonProperty("digitalAssetName")
public String digitalAssetName;
@JsonProperty("availableQuantity")
public String availableQuantity;
@JsonProperty("status")
public String status;


public DigitalAssetListFields() {
	

}

}