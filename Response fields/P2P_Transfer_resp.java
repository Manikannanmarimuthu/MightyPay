package com.qa.restassured;

public class P2P_Transfer_resp {
	
	private String responseCode;
	private String message;
	private String rrn;
	private String authidresp;
	private String txnUid;
	private String fromUserEntityId;
	private String fromWalletId;
	private String digitalAssetTypeCode;
	private String availableQuantity;
	private String platformRef;
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
	public String getFromUserEntityId() {
		return fromUserEntityId;
	}
	public void setFromUserEntityId(String fromUserEntityId) {
		this.fromUserEntityId = fromUserEntityId;
	}
	public String getFromWalletId() {
		return fromWalletId;
	}
	public void setFromWalletId(String fromWalletId) {
		this.fromWalletId = fromWalletId;
	}
	public String getDigitalAssetTypeCode() {
		return digitalAssetTypeCode;
	}
	public void setDigitalAssetTypeCode(String digitalAssetTypeCode) {
		this.digitalAssetTypeCode = digitalAssetTypeCode;
	}
	public String getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(String availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public String getPlatformRef() {
		return platformRef;
	}
	public void setPlatformRef(String platformRef) {
		this.platformRef = platformRef;
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
		return "P2P_Transfer_resp [responseCode=" + responseCode + ", message=" + message + ", rrn=" + rrn
				+ ", authidresp=" + authidresp + ", txnUid=" + txnUid + ", fromUserEntityId=" + fromUserEntityId
				+ ", fromWalletId=" + fromWalletId + ", digitalAssetTypeCode=" + digitalAssetTypeCode
				+ ", availableQuantity=" + availableQuantity + ", platformRef=" + platformRef + ", trxnTime=" + trxnTime
				+ ", trxnTimeZone=" + trxnTimeZone + ", getResponseCode()=" + getResponseCode() + ", getMessage()="
				+ getMessage() + ", getRrn()=" + getRrn() + ", getAuthidresp()=" + getAuthidresp() + ", getTxnUid()="
				+ getTxnUid() + ", getFromUserEntityId()=" + getFromUserEntityId() + ", getFromWalletId()="
				+ getFromWalletId() + ", getDigitalAssetTypeCode()=" + getDigitalAssetTypeCode()
				+ ", getAvailableQuantity()=" + getAvailableQuantity() + ", getPlatformRef()=" + getPlatformRef()
				+ ", getTrxnTime()=" + getTrxnTime() + ", getTrxnTimeZone()=" + getTrxnTimeZone() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


}
