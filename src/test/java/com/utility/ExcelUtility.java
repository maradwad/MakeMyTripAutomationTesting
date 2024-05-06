package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	  public static FileInputStream fi;
	  public static FileOutputStream fo;
	  public static XSSFWorkbook wb;
	  public static XSSFSheet ws;
	  public static XSSFRow row;
	  public static XSSFCell cell;
	  
	  public static  int rowCount(String file, String sheet) throws Exception
	  {
		  fi=new FileInputStream(file);
		  wb=new XSSFWorkbook(fi);
		  ws=wb.getSheet(sheet);
		  int row=ws.getLastRowNum();
		  wb.close();
		  fi.close();	  
		  return row;
	  }
	  public static int cellCount(String file,String sheet, int rownum ) throws Exception {
		  fi=new FileInputStream(file);
		  wb=new XSSFWorkbook(fi);
		  ws=wb.getSheet(sheet);
		  row=ws.getRow(rownum);
		  int cell=row.getLastCellNum();
		  wb.close();
		  fi.close();
		  return cell;
	  }
	  public static  String getCellData(String file,String sheet,int rownum,int colnum) throws Exception
	  {
		  fi=new FileInputStream(file);
		  wb=new XSSFWorkbook(fi);
		  ws=wb.getSheet(sheet);
		  
		  row=ws.getRow(rownum);
		  cell=row.getCell(colnum);
		  
		  String data;
		  try {
		  DataFormatter dataformat=new DataFormatter();
		  data=dataformat.formatCellValue(cell);
//		  return data;
		  }
		  catch(Exception e){
			  data="";
		  }
		  
		  wb.close();
		  fi.close();
		  return data;
		  
	  }
	  
	  public static  void setCellData(String file,String sheet,int rownum,int colnum,String cellData) throws IOException {
		  fi=new FileInputStream(file);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(sheet);
			
			row=ws.getRow(rownum);
			if(row==null)
			{
				row=ws.createRow(rownum);
			}
			
			cell=row.getCell(colnum);
			if(cell==null)
			{
				cell=row.createCell(colnum);
			}
			cell.setCellValue(cellData);
			
			fo=new FileOutputStream(file);
			wb.write(fo);
			wb.close();
			fi.close();
	  }
	  

}
