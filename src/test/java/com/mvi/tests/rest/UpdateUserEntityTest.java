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
import com.qa.json.pojo.UserEntityDetails;
import com.qa.json.pojo.UserUpdateEntity;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class UpdateUserEntityTest extends BaseClass {

	String currentDir = System.getProperty("user.dir") + File.separator + "testdata\\UpdateUserEntity.xlsx";

	@DataProvider(name = "PositiveTestScenarios")
	public Object[][] fetchPositiveTestData() throws Exception {
		ExcelReaderPoi excel = new ExcelReaderPoi();
		return excel.readFilenSheet(currentDir, "UpdateUserEntity");
	}

	@Test(priority = -1, dataProvider = "PositiveTestScenarios")
	public static void updateUserEntityTest1(Map mObj) throws IOException {
		String url = "http://192.168.2.164:9090/0.1/fe-api-gw/update-user";
		RestAssured.baseURI = url;
		UserEntityDetails userDetails = new UserEntityDetails("mobileNo" + mObj.get("mobileNo"),
				"userEntityIdentityType" + mObj.get("userEntityIdentityType"),
				"userEntityIdentity" + mObj.get("userEntityIdentity"), "address1" + mObj.get("address1"),
				"address2" + mObj.get("address2"), "address3" + mObj.get("address3"),
				"postalCode" + mObj.get("postalCode"), "city" + mObj.get("city"),
				"countryCode" + mObj.get("countryCode"), "state" + mObj.get("state"), "emailId" + mObj.get("emailId"),
				"kycFlag" + mObj.get("kycFlag"));
		UserUpdateEntity userUpdateEnty = new UserUpdateEntity("platformCode" + mObj.get("platformCode"),
				"userEntityId" + mObj.get("userEntityId"), "terminalId" + mObj.get("terminalId"),
				"timestamp" + mObj.get("timestamp"), userDetails, "timeZone" + mObj.get("timeZone"));
		ObjectMapper mapper = new ObjectMapper();
		String jsonBody = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userUpdateEnty);
		ExtentTestManager.getTest().log(LogStatus.INFO, "URL is: " + url);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Payload is: " + jsonBody);
		ValidatableResponse response = RestAssured.given().when().header("Content-Type", "application/json")
				.body(jsonBody).post().then();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Response is: " + response.extract().asString());
		response.statusCode(200);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the Status Code Successfully !!");
		response.contentType(ContentType.JSON);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the ContentType Successfully !!");
		response.body("SuccessCode", Matchers.containsString("OPERATION_SUCCESS"));
		ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the SuccessCode message Successfully!!");
		response.body("Message", Matchers.containsString("Operation completed successfully"));
		ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the success request message Successfully!!");
	}
}
