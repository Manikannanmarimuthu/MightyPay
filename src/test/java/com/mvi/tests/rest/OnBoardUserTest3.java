package com.mvi.tests.rest;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mv.apitesting.listeners.BaseClass;
import com.mv.apitesting.listeners.ExcelReaderPoi;
import com.mv.apitesting.listeners.ExtentTestManager;
import com.qa.json.pojo.OnBoardUserEntity;
import com.qa.json.pojo.OnBoardUserEntity_Res;
import com.qa.json.pojo.UpdateUserEntity_Res;
import com.qa.json.pojo.UserEntityDetails;
import com.qa.json.pojo.UserUpdateEntity;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class OnBoardUserTest3 extends BaseClass {

	private static final Object OnBoardUserEntity = null;

	public static String currentDir = System.getProperty("user.dir") + File.separator
			+ "testdata\\OnboardUserEntity.xlsx";

	public static String url = "http://192.168.0.194:8181/0.1/fe-api-gw/onboard";

	@DataProvider(name = "PositiveTestScenarios")
	public Object[][] fetchPositiveTestData() throws Exception {
		ExcelReaderPoi excel = new ExcelReaderPoi();
		return excel.readFilenSheet(currentDir, "Onboard User Entity");
	}

	@Test(priority = -1, dataProvider = "PositiveTestScenarios")
	public static void onboardUserEntityTest(Map<String, String> mObj) throws IOException {
		RestAssured.baseURI = url;
		OnBoardUserEntity OnBoardUserEntity = new OnBoardUserEntity ();
				OnBoardUserEntity.platformCode = mObj.get("platformCode");
		        OnBoardUserEntity.terminalId = mObj.get("terminalId");
		        OnBoardUserEntity.name = mObj.get("name");
		        OnBoardUserEntity.mobileNo = mObj.get("mobileNo");
		        OnBoardUserEntity.userEntityIdentityType = mObj.get("userEntityIdentityType");
		        OnBoardUserEntity.userEntityIdentity = mObj.get("userEntityIdentity");
		        OnBoardUserEntity.userEntityType = mObj.get("userEntityType");
		        OnBoardUserEntity.address1 = mObj.get("address1");
		        OnBoardUserEntity.address2 = mObj.get("address2");
		        OnBoardUserEntity.address3 = mObj.get("address3");
		        OnBoardUserEntity.postalCode = mObj.get("postalCode");
		        OnBoardUserEntity.city = mObj.get("city");
		        OnBoardUserEntity.countryCode = mObj.get("countryCode");
		        OnBoardUserEntity.timestamp = mObj.get("timestamp");
		        OnBoardUserEntity.timeZone = mObj.get("timeZone");
		        OnBoardUserEntity.state = mObj.get("state");
		        OnBoardUserEntity.emailId = mObj.get("emailId");
		        OnBoardUserEntity.kycFlag = mObj.get("kycFlag");
				
					
		ObjectMapper mapper = new ObjectMapper();
		String jsonBody = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(OnBoardUserEntity);

		usingDataOutputStream(jsonBody, mObj.get("TestCaseID"), "OnboardUserEntity", true);

		ValidatableResponse response = RestAssured.given().when().header("Content-Type", "application/json")
				.body(jsonBody).post().then();
		
		usingDataOutputStream(response.extract().asString(), mObj.get("TestCaseID"), "OnboardUserEntity", false);
		
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		OnBoardUserEntity_Res uuEndity = mapper.readValue(response.extract().asString(), OnBoardUserEntity_Res.class);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Test Case No : " + mObj.get("TestCaseID"));
		ExtentTestManager.getTest().log(LogStatus.INFO, "Payload is: " + jsonBody);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Response is: " + response.extract().asString());
		ExtentTestManager.getTest().log(LogStatus.INFO, "Response Code: " + uuEndity.responseCode);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Response Message: " + uuEndity.message);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Response Message: " + uuEndity.rrn);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Response Message: " + uuEndity.authidresp);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Response Message: " + uuEndity.txnUid);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Response Message: " + uuEndity.userEntityId);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Response Message: " + uuEndity.walletId);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Response Message: " + uuEndity.trxnTime);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Response Message: " + uuEndity.trxnTimeZone);
	}
}
