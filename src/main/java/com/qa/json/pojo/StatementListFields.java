package com.qa.json.pojo;




import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"trxnDate",
"stmtDesc",
"printCode",
"status",
"trxnImpact",
"trxnQuantity",
"digitalAssetTypeCode",
"availableQuantity",
"trxnSource",
"trxnRefNum",

})

public class StatementListFields {

@JsonProperty("trxnDate")
public String trxnDate;
@JsonProperty("stmtDesc")
public String stmtDesc;
@JsonProperty("printCode")
public String printCode;
@JsonProperty("status")
public String status;
@JsonProperty("trxnImpact")
public String trxnImpact;
@JsonProperty("trxnQuantity")
public String trxnQuantity;
@JsonProperty("digitalAssetTypeCode")
public String digitalAssetTypeCode;
@JsonProperty("availableQuantity")
public String availableQuantity;
@JsonProperty("trxnSource")
public String trxnSource;
@JsonProperty("trxnRefNum")
public String trxnRefNum;



public StatementListFields() {
	

}

}