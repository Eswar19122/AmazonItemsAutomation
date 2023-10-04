package excelutilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AmazonExcelReader {
	public static String[][] readExcel(String filePath, String[][] dataRef) throws IOException {
		FileInputStream fileInput = new FileInputStream(filePath);
		XSSFWorkbook workBook = new XSSFWorkbook(fileInput);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		int rowsNumb = sheet.getLastRowNum() + 1;
		int colsNumb = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[rowsNumb][colsNumb];
		Iterator<Row> rowIterator = sheet.iterator();
		int rowNo = 0;
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.iterator();
			int colNo = 0;
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				data[rowNo][colNo] = cell.getStringCellValue();
				colNo++;
			}
			rowNo++;
		}
		workBook.close();
		fileInput.close();
		for (int i = 0; i < rowsNumb; i++) {
			for (int j = 0; j < colsNumb; j++) {
				dataRef[i][j] = data[i][0];
			}
		}
		return dataRef;
	}
}
