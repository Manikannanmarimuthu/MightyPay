package com.mv.apitesting.listeners;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.relevantcodes.extentreports.LogStatus;

public abstract class BaseClass {

	public String testCaseName;

	public void beforeMethod(String testName, String desc) {
		ExtentTestManager.startTest(testName, desc);
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

	
	public static void writetoFile(String fileContent, String testCaseID, String folderName, boolean isReq) {
		File file = new File("./reports/" + folderName);
		com.mvi.lib.utils.Xls_Reader xls = new com.mvi.lib.utils.Xls_Reader(
				"D:\\Rest API\\UdemyWorkspace\\MightyPay\\testdata\\Topup.xlsx");
		int rowNum = xls.getCellRowNum("Topup", "TestCaseID", testCaseID);
		System.out.println("Row Number is " + rowNum);
		file.mkdir();
		FileOutputStream outputStream;
		String fileApp = "_Res.json";
		xls.setCellData("Topup", "Res Name", rowNum, file.getPath() + File.separator + testCaseID + fileApp);
		if (isReq) {
			fileApp = "_Req.json";
			xls.setCellData("Topup", "Req Name", rowNum, file.getPath() + File.separator + testCaseID + fileApp);
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
