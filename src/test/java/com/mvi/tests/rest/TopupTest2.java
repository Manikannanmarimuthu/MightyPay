package com.mvi.tests.rest;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mv.apitesting.listeners.BaseClass;
import com.mv.apitesting.listeners.ExcelReaderPoi;
import com.mv.apitesting.listeners.ExtentTestManager;
import com.qa.json.pojo.Topup;
import com.qa.json.pojo.Topup_Resp;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class TopupTest2 extends BaseClass {

	public static String currentDir = System.getProperty("user.dir") + File.separator
			+ "testdata\\Topup.xlsx";

	public static String url = "http://192.168.0.194:8181/0.1/fe-api-gw/topup";

	@DataProvider(name = "PositiveTestScenarios")
	public Object[][] fetchPositiveTestData() throws Exception {
		ExcelReaderPoi excel = new ExcelReaderPoi();
		return excel.readFilenSheet(currentDir, "Topup");
	}

	@Test(priority = -1, dataProvider = "PositiveTestScenarios")
	public static void TopupTest(Map<String, String> mObj) throws IOException {
		RestAssured.baseURI = url;
		/*Topup topupdetails = new Topup();
		topupdetails.mobileno = mObj.get("mobileNo");
		topupdetails.userentityidentitytype = mObj.get("userEntityIdentityType");
		topupdetails.userentityidentity = mObj.get("userEntityIdentity");
		topupdetails.address1 = mObj.get("address1");
		topupdetails.address2 = mObj.get("address2");
		topupdetails.address3 = mObj.get("address3");
		topupdetails.postalcode = mObj.get("postalCode");
		topupdetails.city = mObj.get("city");
		topupdetails.countrycode = mObj.get("countryCode");
		topupdetails.state = mObj.get("state");
		topupdetails.emailid = mObj.get("emailId");
		topupdetails.kycFlag = mObj.get("kycFlag");*/

		Topup topup = new Topup();
		topup.platformCode = mObj.get("platformCode");
		topup.userEntityId = mObj.get("userEntityId");
		topup.walletId = mObj.get("walletId");
		topup.digitalAssetTypeCode = mObj.get("digitalAssetTypeCode");
		topup.quantity = mObj.get("quantity");
		topup.terminalId = mObj.get("terminalId");
		topup.platformRef = mObj.get("platformRef");
		topup.timestamp = mObj.get("timestamp");
		topup.remarks = mObj.get("remarks");



		ObjectMapper mapper = new ObjectMapper();
		String jsonBody = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(topup);

		usingDataOutputStream(jsonBody, mObj.get("TestCaseID"), "Topup", true);

		ValidatableResponse response = RestAssured.given().when().header("Content-Type", "application/json")
				.body(jsonBody).post().then();
		
		usingDataOutputStream(response.extract().asString(), mObj.get("TestCaseID"), "Topup", false);
		
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Topup_Resp T_up = mapper.readValue(response.extract().asString(), Topup_Resp.class);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Test Case No : " + mObj.get("TestCaseID"));
		ExtentTestManager.getTest().log(LogStatus.INFO, "Payload is: " + jsonBody);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Response is: " + response.extract().asString());
		ExtentTestManager.getTest().log(LogStatus.INFO, "responseCode: " + T_up.responseCode);
		ExtentTestManager.getTest().log(LogStatus.INFO, "message: " + T_up.message);
		ExtentTestManager.getTest().log(LogStatus.INFO, "rrn: " + T_up.rrn);
		ExtentTestManager.getTest().log(LogStatus.INFO, "authidresp: " + T_up.authidresp);
		ExtentTestManager.getTest().log(LogStatus.INFO, "platformRef: " + T_up.platformRef);
		ExtentTestManager.getTest().log(LogStatus.INFO, "txnUid: " + T_up.txnUid);
		ExtentTestManager.getTest().log(LogStatus.INFO, "trxnTime: " + T_up.trxnTime);
		ExtentTestManager.getTest().log(LogStatus.INFO, "digitalAssetTypeCode: " + T_up.digitalAssetTypeCode);
		ExtentTestManager.getTest().log(LogStatus.INFO, "availableQuantity: " + T_up.availableQuantity);
		ExtentTestManager.getTest().log(LogStatus.INFO, "userEntityId: " + T_up.userEntityId);
		ExtentTestManager.getTest().log(LogStatus.INFO, "walletId: " + T_up.walletId);



	}

}