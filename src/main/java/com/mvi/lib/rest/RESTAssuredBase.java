package com.mvi.lib.rest;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mv.apitesting.listeners.BaseClass;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

public class RESTAssuredBase extends BaseClass {

	public static RequestSpecification setLogs() {
		RestAssured.baseURI = "http://192.168.0.194:8181/0.1/fe-api-gw/";
		RequestLogSpecification log = RestAssured.given().log();
		return log.all().contentType(getContentType());
	}

	public static Response postWithJsonBody(Object jsonObject, String URL) {
		return setLogs().when().body(jsonObject).post(URL);
	}

	public static Response getWithHeader(Map<String, String> headers, String URL) {
		return setLogs().when().headers(headers).get(URL);
	}

	public static Response post() {
		return setLogs().post();
	}

	public static Response post(String URL) {
		return setLogs().post(URL);
	}

	public static Response postWithBodyAsFile(File bodyFile) {
		return setLogs().body(bodyFile).post();
	}

	public static Response postWithHeaderAndForm(Map<String, String> headers, JSONObject jsonObject, String URL) {
		return setLogs().headers(headers).body(jsonObject).post(URL);
	}

	public static Response postWithJsonAsBody(HashMap<String, String> map, String URL, String testCaseID) {
		ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
		String json;
		try {
			json = mapper.writeValueAsString(map);
			usingDataOutputStream1(json, testCaseID, URL);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return setLogs().body(map).post(URL);
	}

	public static Response postWithHeaderAndJsonBody(Map<String, String> headers, String jsonObject, String URL) {
		return setLogs().when().headers(headers).body(jsonObject).post(URL);
	}

	public static Response postWithHeaderParam(Map<String, String> headers, String URL) {
		return setLogs().when().headers(headers).post(URL);
	}

	public static void usingDataOutputStream(Response res, String testCaseID, String folderName) throws IOException {
		File file = new File("./reports/" + folderName);
		if (!file.exists()) {
			file.mkdir();
		}
		FileOutputStream outputStream = new FileOutputStream(
				file.getPath() + File.separator + testCaseID + "_Res.json");
		DataOutputStream dataOutStream = new DataOutputStream(new BufferedOutputStream(outputStream));
		String resp = res.asString();
		dataOutStream.writeUTF(resp);
		dataOutStream.close();
	}

	public static void usingDataOutputStream1(String fileContent, String testCaseID, String folderName) {
		File file = new File("./reports/" + folderName);
		file.mkdir();
		FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream(file.getPath() + File.separator + testCaseID + "_Req.json");
			DataOutputStream dataOutStream = new DataOutputStream(new BufferedOutputStream(outputStream));
			try {
				dataOutStream.writeUTF(fileContent);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				dataOutStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static Response delete(String URL) {
		return setLogs().when().delete(URL);
	}

	public static Response putWithHeaderAndBodyParam(Map<String, String> headers, JSONObject jsonObject, String URL) {
		return RestAssured.given().headers(headers).contentType(getContentType()).request().body(jsonObject).when()
				.put(URL);
	}

	private static ContentType getContentType() {
		return ContentType.JSON;
	}

	public static void verifyResponseCode(Response response, int code) {
		if (response.statusCode() == code) {
		} else {
		}
	}

	public static void verifyResponseTime(Response response, long time) {
		if (response.time() <= time) {
		} else {
		}
	}

	public static void verifyContentWithKey(Response response, String key, String expVal) {
		if (response.getContentType().contains("json")) {
			JsonPath jsonPath = response.jsonPath();
			String actValue = jsonPath.get(key);
			if (actValue.equalsIgnoreCase(expVal)) {
			} else {
			}
		}
	}

	/*
	 * public static void verifyContentsWithKey(Response response, String key,
	 * String expVal) { if (response.getContentType().contains("json")) { JsonPath
	 * jsonPath = response.jsonPath(); List<String> actValue =
	 * jsonPath.getList(key); if (actValue.get(0).equalsIgnoreCase(expVal)) {
	 * reportRequest("The JSON response has value " + expVal + " as expected. ",
	 * "PASS"); } else { reportRequest( "The JSON response :" + actValue +
	 * " does not have the value " + expVal + " as expected. ", "FAIL"); } }
	 */
	/*
	 * }
	 */
	public static List<String> getContentsWithKey(Response response, String key) {
		if (response.getContentType().contains("json")) {
			JsonPath jsonPath = response.jsonPath();
			return jsonPath.getList(key);
		} else {
			return null;
		}
	}

	public static String getContentWithKey(Response response, String key) {
		if (response.getContentType().contains("json")) {
			JsonPath jsonPath = response.jsonPath();
			return (String) jsonPath.get(key);
		} else {
			return null;
		}
	}

}