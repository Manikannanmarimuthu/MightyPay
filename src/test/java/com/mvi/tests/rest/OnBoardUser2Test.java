package com.mvi.tests.rest;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mv.apitesting.listeners.BaseClass;
import com.mv.apitesting.listeners.ExcelReaderPoi;
import com.mv.apitesting.listeners.ExtentTestManager;
import com.qa.json.pojo.OnBoardUserEntity;
import com.qa.json.pojo.UserEntityDetails;
import com.qa.json.pojo.UserUpdateEntity;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class OnBoardUser2Test extends BaseClass {

	private static final Object OnBoardUserEntity = null;
	String currentDir = System.getProperty("user.dir") + File.separator + "testdata\\OnboardUserEntity.xlsx";

	@DataProvider(name = "PositiveTestScenarios")
	public Object[][] fetchPositiveTestData() throws Exception {
		ExcelReaderPoi excel = new ExcelReaderPoi();
		return excel.readFilenSheet(currentDir, "Onboard User Entity");
	}

	@Test(priority = -1, dataProvider = "PositiveTestScenarios")
	public static void onboardUserEntityTest(Map mObj) throws IOException {
		String url = "http://192.168.0.194:8181/0.1/fe-api-gw/onboard";
		RestAssured.baseURI = url;
		OnBoardUserEntity OnBoardUserEntity = new OnBoardUserEntity ("" + mObj.get("mobileNo"),"" + mObj.get("platformCode"),
				"" + mObj.get("terminalId"),"" + mObj.get("name"),"" + mObj.get("userEntityIdentityType"),
				"" + mObj.get("userEntityIdentity"),"" + mObj.get("userEntityType"),
				"" + mObj.get("address1"), "" + mObj.get("address2"), "" + mObj.get("address3"),
				"" + mObj.get("postalCode"), "" + mObj.get("city"),
				"" + mObj.get("countryCode"), "" + mObj.get("timestamp"), "" + mObj.get("state"), "" + mObj.get("emailId"),
				"" + mObj.get("kycFlag"),"" + mObj.get("timeZone"));
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonBody = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(OnBoardUserEntity);
		ExtentTestManager.getTest().log(LogStatus.INFO, "URL is: " + url);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Test Case Number : " + mObj.get("TestCaseID"));
		ExtentTestManager.getTest().log(LogStatus.INFO, "Payload is: " + jsonBody);
		ValidatableResponse response = RestAssured.given().when().header("Content-Type", "application/json")
				.body(jsonBody).post().then();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Response is: " + response.extract().asString());
		response.statusCode(200);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the Status Code Successfully !!");
		response.contentType(ContentType.JSON);
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the ContentType Successfully !!");
//		response.body("SuccessCode", Matchers.containsString("OPERATION_SUCCESS"));
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the SuccessCode message Successfully!!");
//		response.body("Message", Matchers.containsString("Operation completed successfully"));
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the success request message Successfully!!");
	}
}
