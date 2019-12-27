package com.mv.apitesting.listeners;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.LogStatus;

public abstract class BaseClass {

	@BeforeMethod
	public void beforeMethod(Method method) {
		ExtentTestManager.startTest(method.getName());
	}

	@AfterMethod
	protected void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			ExtentTestManager.getTest().log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
		} else {
			ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
		}

		ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
		ExtentManager.getReporter().flush();
	}

	protected String getStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);
		return sw.toString();
	}

	public static void usingDataOutputStream(String fileContent, String testCaseID, String folderName, boolean isReq) {
		File file = new File("./reports/" + folderName);
		file.mkdir();
		FileOutputStream outputStream;
		String fileApp = "_Res.json";
		if (isReq) {
			fileApp = "_Req.json";
		}
		try {
			outputStream = new FileOutputStream(file.getPath() + File.separator + testCaseID + fileApp);
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
}
