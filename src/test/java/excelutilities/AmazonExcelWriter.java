package excelutilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class AmazonExcelWriter  {
	
	public static void WriteExcel(String filePath,int rn,int cn,String d) throws IOException  {
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(rn);
		XSSFCell cell = row.getCell(cn,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		cell.setCellValue(d);
		FileOutputStream fos = new FileOutputStream(filePath);
		workBook.write(fos);
		workBook.close();
		fos.close();
		fis.close();
	}
}
