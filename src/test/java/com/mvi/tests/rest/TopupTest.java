package com.mvi.tests.rest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.mvi.lib.rest.RESTAssuredBase;
import com.qa.pojo.res.Onboard_Res;
import com.qa.pojo.res.Topup_Res;

import io.restassured.response.Response;

public class TopupTest extends RESTAssuredBase {

	public static int dataRow = 2; // without Header
	public static int reqLastCellNum = 16;
	public static final String COLUMN = "COLUMN";
	public static final String NO_TAG = "NO_TAG";
	public static LinkedHashMap<String, String> headerMap = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> tcMap = new LinkedHashMap<String, String>();
	public static Cell testres = null;

	@SuppressWarnings("deprecation")
	@Test
	public static void read() throws IOException {
		FileInputStream inStream = new FileInputStream("./testdata/Topup.xlsx");
		XSSFWorkbook myWorkBook = new XSSFWorkbook(inStream);
		XSSFSheet mySheet = myWorkBook.getSheet("Topup");
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
			int lastCellNum = reqLastCellNum;
			Cell testCaseId = null;
			testCaseId = currRow.getCell(5);
			testCaseId.setCellType(Cell.CELL_TYPE_STRING);
			testres = currRow.getCell(29);
			for (int j = 6; j < reqLastCellNum; j++) {
				Cell cell1 = currRow.getCell(j);
				System.out.println("cell Value  = " + cell1);
				cell1.setCellType(Cell.CELL_TYPE_STRING);
				if (cell1 == null || cell1.getStringCellValue().isEmpty()) {
					dataMap.put(headerMap.get(COLUMN + j), "");
				} else if (cell1.getStringCellValue().trim().contains(NO_TAG)) {
					;
				} else {
					dataMap.put(headerMap.get(COLUMN + j), cell1.getStringCellValue());
				}
			}
			if (!dataMap.isEmpty()) {
				Response response = postWithJsonAsBody(dataMap, "topup", testCaseId.getStringCellValue());
				usingDataOutputStream(response, testCaseId.getStringCellValue(), "topup");
				Topup_Res topup = response.getBody().as(Topup_Res.class);
				lastCellNum++;
				setRowData(currRow, topup.getResponseCode(), lastCellNum++);
				if (topup.getResponseCode().equalsIgnoreCase(testres.getStringCellValue())) {
					setRowData(currRow, "PASS", 30);
				} else {
					setRowData(currRow, "FAIL", 30);
				}
				setRowData(currRow, topup.getMessage(), lastCellNum++);
				setRowData(currRow, topup.getRrn(), lastCellNum++);
				setRowData(currRow, topup.getAuthidresp(), lastCellNum++);
				setRowData(currRow, topup.getTxnUid(), lastCellNum++);
				setRowData(currRow, topup.getUserEntityId(), lastCellNum++);
				setRowData(currRow, topup.getWalletId(), lastCellNum++);
				setRowData(currRow, topup.getDigitalAssetTypeCode(), lastCellNum++);
				setRowData(currRow, topup.getPlatformRef(), lastCellNum++);
				setRowData(currRow, topup.getAvailableQuantity(), lastCellNum++);
				setRowData(currRow, topup.getTrxnTime(), lastCellNum++);
				setRowData(currRow, topup.getTrxnTimeZone(), lastCellNum++);
				

			}
		}
		inStream.close();

		try {
			FileOutputStream out = new FileOutputStream("./testdata/Topup.xlsx");
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