package com.mv.apitesting.listeners;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.ValidatableResponse;

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

	public static void getData(String wbName, String sheetName, String testcaseName, String reqResfName)
			throws IOException {
		FileInputStream fis = new FileInputStream("./testdata/" + File.separator + wbName + ".xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		CreationHelper createHelper = workbook.getCreationHelper();
		XSSFCellStyle hlinkstyle = workbook.createCellStyle();
		XSSFFont hlinkfont = workbook.createFont();
		hlinkfont.setUnderline(XSSFFont.U_SINGLE);
		hlinkfont.setColor(HSSFColor.BLUE.index);
		hlinkstyle.setFont(hlinkfont);
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				int rowCount = sheet.getLastRowNum();
				for (int j = 1; j < rowCount + 1; j++) {
					XSSFRow row = sheet.getRow(j);
					row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
					String cellValue = row.getCell(5).getStringCellValue();
					if (cellValue.equals(testcaseName)) {
						Cell cell = row.createCell(16);
						cell.setCellValue(testcaseName);
						XSSFHyperlink link = (XSSFHyperlink) createHelper.createHyperlink(HyperlinkType.FILE);
						link.setAddress(
								"D:\\Rest API\\UdemyWorkspace\\MightyPay\\reports\\Topup\\TC_UUE-0001_Req.json");
						cell.setHyperlink(link);
						cell.setCellStyle(hlinkstyle);
						break;
					}
				}
			}
		}
		FileOutputStream os = new FileOutputStream("./testdata/" + File.separator + wbName + ".xlsx");
		workbook.write(os);
	}
}
