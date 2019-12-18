package com.qa.restassured;

public class Update_User_Entity_resp {
	
	private String responseCode;
	private String message;
	private String rrn;
	private String authidresp;
	private String txnUid;
	private String userEntityId;
	private String trxnTime;
	private String trxnTimeZone;
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRrn() {
		return rrn;
	}
	public void setRrn(String rrn) {
		this.rrn = rrn;
	}
	public String getAuthidresp() {
		return authidresp;
	}
	public void setAuthidresp(String authidresp) {
		this.authidresp = authidresp;
	}
	public String getTxnUid() {
		return txnUid;
	}
	public void setTxnUid(String txnUid) {
		this.txnUid = txnUid;
	}
	public String getUserEntityId() {
		return userEntityId;
	}
	public void setUserEntityId(String userEntityId) {
		this.userEntityId = userEntityId;
	}
	public String getTrxnTime() {
		return trxnTime;
	}
	public void setTrxnTime(String trxnTime) {
		this.trxnTime = trxnTime;
	}
	public String getTrxnTimeZone() {
		return trxnTimeZone;
	}
	public void setTrxnTimeZone(String trxnTimeZone) {
		this.trxnTimeZone = trxnTimeZone;
	}
	
	@Override
	public String toString() {
		return "Update_User_Entity_resp [responseCode=" + responseCode + ", message=" + message + ", rrn=" + rrn
				+ ", authidresp=" + authidresp + ", txnUid=" + txnUid + ", userEntityId=" + userEntityId + ", trxnTime="
				+ trxnTime + ", trxnTimeZone=" + trxnTimeZone + ", getResponseCode()=" + getResponseCode()
				+ ", getMessage()=" + getMessage() + ", getRrn()=" + getRrn() + ", getAuthidresp()=" + getAuthidresp()
				+ ", getTxnUid()=" + getTxnUid() + ", getUserEntityId()=" + getUserEntityId() + ", getTrxnTime()="
				+ getTrxnTime() + ", getTrxnTimeZone()=" + getTrxnTimeZone() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
