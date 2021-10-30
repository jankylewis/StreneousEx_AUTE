package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.log4testng.Logger;

public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	private static int excelcolumnresult, excelRowresult;
	final static Logger logger = Logger.getLogger(ExcelUtils.class);
	// This method is to set the File path and to open the Excel file, Pass
	// Excel Path and Sheetname as Arguments to this method

	public static void setExcelFile(String Path, String SheetName) throws Exception {

		try {

			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e) {

			logger.error("This is a error : ", e);
			throw (e);
		}

	}

	public static void setrowcolumn(int row, int column) throws Exception {

		excelcolumnresult = column;
		excelRowresult = row;

	}

	public static Integer getcolumn() throws Exception {

		return excelcolumnresult;

	}

	public static Integer getrow() throws Exception {

		return excelRowresult;

	}

	public static void closeandsaveFile(String Path) throws Exception {
		FileOutputStream outFile = new FileOutputStream(Path);
		ExcelWBook.write(outFile);
		outFile.close();

	}

	public static void saveFile(String Path) throws Exception {
		FileOutputStream outFile = new FileOutputStream(Path);
		ExcelWBook.write(outFile);

	}

	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {

		String[][] tabArray = null;

		try {

			FileInputStream ExcelFile = new FileInputStream(FilePath);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			int startRow = 1;

			int startCol = 1;

			int ci, cj;

			int totalRows = ExcelWSheet.getLastRowNum();

			// you can write a function as well to get Column count

			int totalCols = 2;

			tabArray = new String[totalRows][totalCols];

			ci = 0;

			for (int i = startRow; i <= totalRows; i++, ci++) {

				cj = 0;

				for (int j = startCol; j <= totalCols; j++, cj++) {

					tabArray[ci][cj] = getCellData(i, j);

					System.out.println(tabArray[ci][cj]);

				}

			}

		}

		catch (FileNotFoundException e) {

			logger.error("Could not read the Excel sheet : ", e);

			e.printStackTrace();

		}

		catch (IOException e) {

			logger.error("Could not read the Excel sheet : ", e);

			e.printStackTrace();

		}

		return (tabArray);

	}

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
//			System.out.println(CellData);
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

	@SuppressWarnings("deprecation")
	public static String getDateCellData(int RowNum, int ColNum) throws Exception {
		try {

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			final DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			String CellData = dateFormat.format(Cell.getDateCellValue());
			return CellData;
		} catch (Exception e) {
			if (!Cell.getStringCellValue().isEmpty()) {
				return Cell.getStringCellValue();
			}
			return "";
		}
	}

	@SuppressWarnings("deprecation")
	public static String getDateCellData(int RowNum, int ColNum, String formatd) throws Exception {
		try {

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			final DateFormat dateFormat = new SimpleDateFormat(formatd);
			String CellData = dateFormat.format(Cell.getDateCellValue());
			return CellData;
		} catch (Exception e) {
			if (!Cell.getStringCellValue().isEmpty()) {
				return Cell.getStringCellValue();
			}
			return "";
		}
	}

	public static Integer getNumericCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			Integer CellData = (int) Cell.getNumericCellValue();
			return CellData;
		} catch (Exception e) {
			return null;
		}
	}

	public static void setCellData(int RowNum, int ColNum, String status) throws Exception {
		try {
			// Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			// Cell.setCellValue("Passed");
			XSSFRow sheetrow = ExcelWSheet.getRow(RowNum);
			if (sheetrow == null) {
				sheetrow = ExcelWSheet.createRow(RowNum);
			}
			// Update the value of cell
			Cell = sheetrow.getCell(ColNum);
			if (Cell == null) {
				Cell = sheetrow.createCell(ColNum);
			}
			Cell.setCellValue(status);
		} catch (Exception e) {
			return;
		}
	}

	public static String getTestCaseName(String sTestCase) throws Exception {
		String value = sTestCase;
		try {
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");
			value = value.substring(posi + 1);
			return value;
		} catch (Exception e) {
			logger.error("This is a error: ", e);
			throw (e);
		}
	}

	public static int getRowContains(String sTestCaseName, int colNum) throws Exception {
		int i;
		try {
			int rowCount = ExcelUtils.getRowUsed();
			for (i = 0; i < rowCount; i++) {
				if (ExcelUtils.getCellData(i, colNum).equalsIgnoreCase(sTestCaseName)) {
					break;
				}
			}
			return i;
		} catch (Exception e) {
			logger.error("This is a error: ", e);
			throw (e);
		}
	}

	public static int getRowUsed() throws Exception {
		try {
			int RowCount = ExcelWSheet.getLastRowNum();
			return RowCount;
		} catch (Exception e) {
			logger.error("This is a error: ", e);
			throw (e);
		}
	}

	public static void setExcelFile(InputStream resourceAsStream, String sheetName) {
		try {

			// Open the Excel file
			// FileInputStream ExcelFile = new FileInputStream(Path);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(resourceAsStream);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
		} catch (Exception e) {

			logger.error("This is a error : ", e);

		}

	}
}
