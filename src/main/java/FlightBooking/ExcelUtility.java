package FlightBooking;

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
	
	
	public static int getRowCount(String file, String sheet) throws IOException
	{
		fi=new FileInputStream(file);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheet);
		
		int rowcount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
		
	}
	
	public static int getCellCount(String file,String sheet,int rownum) throws IOException
	{
		fi=new FileInputStream(file);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheet);
		
		row=ws.getRow(rownum);
		int cellCount= row.getLastCellNum();
		
		return cellCount;
	}
	public static String geCellData(String file,String sheet, int rownum,int cellnum) throws IOException
	{
		fi=new FileInputStream(file);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheet);
		
		row=ws.getRow(rownum);
		cell=row.getCell(cellnum);
		
		String str;
		try {
			//data to string
			DataFormatter data=new DataFormatter();
			str=data.formatCellValue(cell);
		} catch (Exception e) {
			// TODO: handle exception
			str="";
		} 
		
	  wb.close();
	  fi.close();
	  return str;
	}
	
	public static void setCellData(String file,String sheet,int rownum,int cellnum, String data) throws IOException 
	{
		fi=new FileInputStream(file);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheet);
		
		row=ws.getRow(rownum);
		cell=row.getCell(cellnum);
		cell.setCellValue(data);
		
		fo=new FileOutputStream(file);
		wb.write(fo);
		
		wb.close();
		fi.close();
	}
	
}
