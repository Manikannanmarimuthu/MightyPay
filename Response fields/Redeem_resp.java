package com.qa.restassured;

public class Redeem_resp {
	
	private String responseCode;
	private String message;
	private String rrn;
	private String authidresp;
	private String txnUid;
	private String userEntityId;
	private String walletId;
	private String digitalAssetTypeCode;
	private String availableQuantity;
	private String merchantId;
	private String merchantRef;
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
	public String getUserEntityId() {
		return userEntityId;
	}
	public void setUserEntityId(String userEntityId) {
		this.userEntityId = userEntityId;
	}
	public String getWalletId() {
		return walletId;
	}
	public void setWalletId(String walletId) {
		this.walletId = walletId;
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
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getMerchantRef() {
		return merchantRef;
	}
	public void setMerchantRef(String merchantRef) {
		this.merchantRef = merchantRef;
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
		return "Redeem_resp [responseCode=" + responseCode + ", message=" + message + ", rrn=" + rrn + ", authidresp="
				+ authidresp + ", txnUid=" + txnUid + ", userEntityId=" + userEntityId + ", walletId=" + walletId
				+ ", digitalAssetTypeCode=" + digitalAssetTypeCode + ", availableQuantity=" + availableQuantity
				+ ", merchantId=" + merchantId + ", merchantRef=" + merchantRef + ", platformRef=" + platformRef
				+ ", trxnTime=" + trxnTime + ", trxnTimeZone=" + trxnTimeZone + ", getResponseCode()="
				+ getResponseCode() + ", getMessage()=" + getMessage() + ", getRrn()=" + getRrn() + ", getAuthidresp()="
				+ getAuthidresp() + ", getTxnUid()=" + getTxnUid() + ", getUserEntityId()=" + getUserEntityId()
				+ ", getWalletId()=" + getWalletId() + ", getDigitalAssetTypeCode()=" + getDigitalAssetTypeCode()
				+ ", getAvailableQuantity()=" + getAvailableQuantity() + ", getMerchantId()=" + getMerchantId()
				+ ", getMerchantRef()=" + getMerchantRef() + ", getPlatformRef()=" + getPlatformRef()
				+ ", getTrxnTime()=" + getTrxnTime() + ", getTrxnTimeZone()=" + getTrxnTimeZone() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


}
