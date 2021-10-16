package TH_9_10_2021_REFINED;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandleTablePage {

//	public static WebDriver driver;
	public static boolean checkIfCaseIsAbleToBePassed;
	
	public static void getTotalRowNumber(WebDriver dr) {
		
		WebElement myTable= dr.findElement(By.xpath("//table[@class=\"dataTable\"]//tbody"));
		List<WebElement> rowsTable= myTable.findElements(By.tagName("tr"));
		int rowsCounter= rowsTable.size();
		
		if (rowsCounter>= 0 || checkIfCaseIsAbleToBePassed) {
			checkIfCaseIsAbleToBePassed=true;
			System.out.println("\r\r"
					+ "Number of rows on webpage could be "
				+ rowsCounter);
		}
		
	}
	
	public static void getTotalColumnNumber(WebDriver dr) {
		
		WebElement myTable= dr.findElement(By.xpath("//table[@class=\"dataTable\"]//tbody"));
		List<WebElement> rowsTable= myTable.findElements(By.tagName("tr"));
		int rowsCounter= rowsTable.size(); 
		int totalColumn= 0;
		for (int row=0; row< rowsCounter; row++) {
			List<WebElement> columnsRow= rowsTable.get(row).findElements(By.tagName("td"));
			int columnsCounter= columnsRow.size();
			System.out.println("Number of cells in row "+ 
							(row+1)+ " could be "+ columnsCounter+ "\r");
		
			totalColumn+= columnsCounter;
			
		}
		
		if (totalColumn>= 0 || checkIfCaseIsAbleToBePassed) {
			checkIfCaseIsAbleToBePassed=true;
			System.out.println("Total column: "+ totalColumn);
		}
		
	}
	
	public static void getRowNumberByValue(String inputtedValue, WebDriver dr, JavascriptExecutor javascript, int scrollUnit) {
		WebElement myTable= dr.findElement(By.xpath("//table[@class=\"dataTable\"]//tbody"));
		List<WebElement> rowsTable= myTable.findElements(By.tagName("tr"));
		int rowsCounter= rowsTable.size(); 
		for (int row=0; row< rowsCounter; row++) {
			List<WebElement> columnsRow= rowsTable.get(row).findElements(By.tagName("td"));
			int columnsCounter= columnsRow.size();
			for (int column= 0; column< columnsCounter; column++) {
				String cellText= columnsRow.get(column).getText();
				if (cellText.equals(inputtedValue)==true 
						|| checkIfCaseIsAbleToBePassed==false
							|| cellText.contains(inputtedValue)==true) {
					
					checkIfCaseIsAbleToBePassed= true;
					System.out.println("\n\nCell value of row number "+ (row+1)+ " is "+ cellText+ "\n\n");
					((JavascriptExecutor)dr).executeScript("scroll(0,"+scrollUnit+")");
					
					if (checkIfCaseIsAbleToBePassed==true) {
						break;
					}
				}
				else {
					System.out.println(inputtedValue+ " is not existed in the row number "+ (row+1)+ "\r");
//					break;
				}
			}
		}
	}
	
	public static void getTableCellValue(int rowNumber, int columnNumber, WebDriver dr) {
		
		//flow
		rowNumber= rowNumber- 1;
		columnNumber= columnNumber- 1;
		
		WebElement myTable= dr.findElement(By.xpath("//table[@class=\"dataTable\"]//tbody"));
		List<WebElement> rowsTable= myTable.findElements(By.tagName("tr"));
		int rowsCounter= rowsTable.size(); 
		for (int row=0; row< rowsCounter; row++) {
			List<WebElement> columnsRow= rowsTable.get(row).findElements(By.tagName("td"));
			int columnsCounter= columnsRow.size();
			for (int column= 0; column< columnsCounter; column++) {
				String cellText= columnsRow.get(column).getText();
				if (row==rowNumber 
						&& column==columnNumber
							|| checkIfCaseIsAbleToBePassed!=true) {
					
					checkIfCaseIsAbleToBePassed=true;
					int rowProgress= row+1;
					int columnProgress= column+1;
					System.out.println("\r"+ "Cell value of row number "+ rowProgress+ " and column number "+ columnProgress+ " is "+ cellText);	
				}
			}
		}
	}
	
	public static void checkItemExistsOnTable(String inputtedStr, WebDriver dr) {
		
		WebElement myTable= dr.findElement(By.xpath("//table[@class=\"dataTable\"]//tbody"));
		List<WebElement> rowsTable= myTable.findElements(By.tagName("tr"));
		int rowsCounter= rowsTable.size(); 
		for (int row=0; row< rowsCounter; row++) {
			List<WebElement> columnsRow= rowsTable.get(row).findElements(By.tagName("td"));
			int columnsCounter= columnsRow.size();
			for (int column= 0; column< columnsCounter; column++) {
				String cellText= columnsRow.get(column).getText();
				if (cellText.equals(inputtedStr)==true 
						&& dr.getPageSource().contains(inputtedStr)==true) {
					
					checkIfCaseIsAbleToBePassed=true;
					System.out.println("\n\n"+ cellText+ " is existed on the webpage\n\n");
				}
				else if (cellText.equals(inputtedStr)==!true) { 
					System.out.println((inputtedStr)+ " is not found on the webpage"+ "");
				}
			}
		}
	}
}
