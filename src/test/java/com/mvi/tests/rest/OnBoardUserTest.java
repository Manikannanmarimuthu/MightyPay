package com.mvi.tests.rest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.mvi.lib.rest.RESTAssuredBase;
import com.qa.pojo.res.Onboard_Res;

import io.restassured.response.Response;

public class OnBoardUserTest extends RESTAssuredBase {

	public static int dataRow = 2;
	public static int reqLastCellNum = 24;
	public static final String COLUMN = "COLUMN";
	public static LinkedHashMap<String, String> headerMap = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> tcMap = new LinkedHashMap<String, String>();

	@SuppressWarnings("deprecation")
	@Test
	public static void read() throws IOException {
		FileInputStream inStream = new FileInputStream("./testdata/OnboardUserEntity.xlsx");
		XSSFWorkbook myWorkBook = new XSSFWorkbook(inStream);
		XSSFSheet mySheet = myWorkBook.getSheet("Onboard User Entity");
		{
			Row headerRow = mySheet.getRow(0);
			for (int i = dataRow; i < reqLastCellNum; i++) {
				for (int j = 6; j < reqLastCellNum; j++) {
					Cell headCell = headerRow.getCell(j);
					if (headCell != null && !headCell.getStringCellValue().isEmpty()) {
						headerMap.put(COLUMN + j, headCell.getStringCellValue());
					}
				}
			}
		}
		int lastRow = mySheet.getLastRowNum();
		for (int rowIndx = 1; rowIndx <= lastRow; rowIndx++) {
			Row currRow = mySheet.getRow(rowIndx);
			HashMap<String, String> dataMap = new HashMap<String, String>();
			Cell testCaseId = null;
			int lastCellNum = reqLastCellNum;
			for (int j = 6; j < reqLastCellNum; j++) {
				testCaseId = currRow.getCell(5);
				testCaseId.setCellType(Cell.CELL_TYPE_STRING);
				Cell cell1 = currRow.getCell(j);
				System.out.println("cell1" + cell1);
				cell1.setCellType(Cell.CELL_TYPE_STRING);
				if (cell1 != null && !cell1.getStringCellValue().isEmpty()) {
					dataMap.put(headerMap.get(COLUMN + j), cell1.getStringCellValue());
				} else {
					dataMap.put(headerMap.get(COLUMN + j), "");
				}
			}
			if (!dataMap.isEmpty()) {
				Response response = postWithJsonAsBody(dataMap, "/onboard", testCaseId.getStringCellValue());
				usingDataOutputStream(response, testCaseId.getStringCellValue());
				Onboard_Res onBoard = response.getBody().as(Onboard_Res.class);
				lastCellNum++;
				setRowData(currRow, onBoard.getResponseCode(), lastCellNum++);
				setRowData(currRow, onBoard.getAuthidresp(), lastCellNum++);
				setRowData(currRow, onBoard.getRrn(), lastCellNum++);
				setRowData(currRow, onBoard.getMessage(), lastCellNum++);
				setRowData(currRow, onBoard.getUserEntityId(), lastCellNum++);
				setRowData(currRow, onBoard.getTxnUid(), lastCellNum++);
				setRowData(currRow, onBoard.getTrxnTime(), lastCellNum++);
				setRowData(currRow, onBoard.getWalletId(), lastCellNum++);
			}
		}
		inStream.close();

		try {
			FileOutputStream out = new FileOutputStream("./testdata/OnboardUserEntity.xlsx");
			myWorkBook.write(out);
			myWorkBook.close();
			out.close();
			System.out.println("Excel written successfully..");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void setRowData(Row currRow, String data, int cellIndex) {
		if (data != null) {
			currRow.createCell(cellIndex).setCellValue(data);
		} else {
			currRow.createCell(cellIndex).setCellValue("");
		}
	}
}