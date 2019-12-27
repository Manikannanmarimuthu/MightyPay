package com.mvi.tests.rest;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mv.apitesting.listeners.ExcelReaderPoi;
import com.qa.json.pojo.UserEntityDetails;
import com.qa.json.pojo.UserUpdateEntity;
import com.vimalselvam.testng.listener.ExtentTestNgFormatter;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class UpdateUserEntityTest {

	String currentDir = System.getProperty("user.dir") + File.separator + "testdata\\UpdateUserEntity.xlsx";

	public static String url = "http://192.168.2.15:9090/0.1/fe-api-gw/update-user";

	@DataProvider(name = "PositiveTestScenarios")
	public Object[][] fetchPositiveTestData() throws Exception {
		ExcelReaderPoi excel = new ExcelReaderPoi();
		return excel.readFilenSheet(currentDir, "UpdateUserEntity");
	}

	@Test(priority = 1, dataProvider = "PositiveTestScenarios")
	public static void updateUserEntityTest1(Map<String, String> mObj) throws IOException {
		RestAssured.baseURI = url;
		UserEntityDetails userDetails = new UserEntityDetails();
		userDetails.mobileno = mObj.get("mobileNo");
		userDetails.userentityidentitytype = mObj.get("userEntityIdentityType");
		userDetails.userentityidentity = mObj.get("userEntityIdentity");
		userDetails.address1 = mObj.get("address1");
		userDetails.address2 = mObj.get("address2");
		userDetails.address3 = mObj.get("address3");
		userDetails.postalcode = mObj.get("postalCode");
		userDetails.city = mObj.get("city");
		userDetails.countrycode = mObj.get("countryCode");
		userDetails.state = mObj.get("state");
		userDetails.emailid = mObj.get("emailId");
		userDetails.kycFlag = mObj.get("kycFlag");

		UserUpdateEntity userUpdateEnty = new UserUpdateEntity();
		userUpdateEnty.platformcode = mObj.get("platformCode");
		userUpdateEnty.userentityid = mObj.get("userEntityId");
		userUpdateEnty.terminalid = mObj.get("terminalId");
		userUpdateEnty.timestamp = mObj.get("timestamp");
		userUpdateEnty.userEntityDetails = userDetails;
		userUpdateEnty.timeZone = mObj.get("timeZone");
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonBody = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userUpdateEnty);
		ValidatableResponse response = RestAssured.given().when().header("Content-Type", "application/json")
				.body(jsonBody).post().then();
		ExtentTestNgFormatter.getInstance().addInfoLogToNode("Payload is" + jsonBody);
		ExtentTestNgFormatter.getInstance().addInfoLogToNode("Response is" + response);
	}
}