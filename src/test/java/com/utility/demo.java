package com.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class demo {
	static ExcelUtility excel;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String excelFilePath = System.getProperty("user.dir")+"\\HotelDetails.xlsx";
        int rowIndex = 2; // 0-based index of the row
        int columnIndex = 1; // 0-based index of the column
        String newValue = "NewValue";

        try (FileInputStream fis = new FileInputStream(excelFilePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheetAt(0); // Assuming we are working with the first sheet

            XSSFRow row = sheet.getRow(rowIndex);
            if (row == null) {
                row = sheet.createRow(rowIndex);
            }

            XSSFCell cell = row.getCell(columnIndex);
            if (cell == null) {
                cell = row.createCell(columnIndex);
            }

            cell.setCellValue(newValue);

            try (FileOutputStream fos = new FileOutputStream(excelFilePath)) {
                workbook.write(fos);
            }

            System.out.println("Value set successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	

}
