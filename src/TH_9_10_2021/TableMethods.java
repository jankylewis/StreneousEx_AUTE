package TH_9_10_2021;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class TableMethods {
	
	public static WebDriver driver;
	
	public void testcaseSetUp(String baseURL, String br) {
		if (br== "chrome") {
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver_94.exe");
			driver= new ChromeDriver();
		}
		if (br== "firefox") {
			System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		if (br== "IE") {	
			System.setProperty("webdriver.ie.driver", ".\\Drivers\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
		if (br== "opera") {	
			System.setProperty("webdriver.opera.driver", ".\\Drivers\\operadriver.exe");
			driver= new OperaDriver();
		}
		driver.get(baseURL);
		driver.manage().window().maximize();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	public void tearDown() {
		driver.quit();
	}
	
	public static void getTotalRowNumber() {
		WebElement myTable= driver.findElement(By.xpath("//table[@class=\"dataTable\"]//tbody"));
		List<WebElement> rowsTable= myTable.findElements(By.tagName("tr"));
		int rowsCounter= rowsTable.size(); 
		System.out.println("Number of rows on webpage could be "+ rowsCounter);
	}
	
	public static void getTotalColumnNumber() {
		WebElement myTable= driver.findElement(By.xpath("//table[@class=\"dataTable\"]//tbody"));
		List<WebElement> rowsTable= myTable.findElements(By.tagName("tr"));
		int rowsCounter= rowsTable.size(); 
		for (int row=0; row< rowsCounter; row++) {
			List<WebElement> columnsRow= rowsTable.get(row).findElements(By.tagName("td"));
			int columnsCounter= columnsRow.size();
			System.out.println("Number of cells in row "+ row+ " could be "+ columnsCounter);
		}
	}
	
	public static void getRowNumberByValue(String str) {
		WebElement myTable= driver.findElement(By.xpath("//table[@class=\"dataTable\"]//tbody"));
		List<WebElement> rowsTable= myTable.findElements(By.tagName("tr"));
		int rowsCounter= rowsTable.size(); 
		for (int row=0; row< rowsCounter; row++) {
			List<WebElement> columnsRow= rowsTable.get(row).findElements(By.tagName("td"));
			int columnsCounter= columnsRow.size();
			for (int column= 0; column< columnsCounter; column++) {
				String cellText= columnsRow.get(column).getText();
				if (cellText.equals(str)==true) {
					System.out.println("\n\nCell value of row number "+ row+ " is "+ cellText+ "\n\n");
					break;
				}
				else {
					System.out.println(str+ " is not existed in the row number "+ row);
//					break;
				}
			}
		}
	}
	
	public static void getTableCellValue(int rowNumber, int columnNumber) {
		
		//flow
		rowNumber= rowNumber- 1;
		columnNumber= columnNumber- 1;
		
		WebElement myTable= driver.findElement(By.xpath("//table[@class=\"dataTable\"]//tbody"));
		List<WebElement> rowsTable= myTable.findElements(By.tagName("tr"));
		int rowsCounter= rowsTable.size(); 
		for (int row=0; row< rowsCounter; row++) {
			List<WebElement> columnsRow= rowsTable.get(row).findElements(By.tagName("td"));
			int columnsCounter= columnsRow.size();
			for (int column= 0; column< columnsCounter; column++) {
				String cellText= columnsRow.get(column).getText();
				if (row==rowNumber && column==columnNumber) {
					int rowProgress= row+1;
					int columnProgress= column+1;
					System.out.println("Cell value of row number "+ rowProgress+ " and column number "+ columnProgress+ " is "+ cellText);	
				}
			}
		}
	}
	
	public static void checkItemExistsOnTable(String str) {
		WebElement myTable= driver.findElement(By.xpath("//table[@class=\"dataTable\"]//tbody"));
		List<WebElement> rowsTable= myTable.findElements(By.tagName("tr"));
		int rowsCounter= rowsTable.size(); 
		for (int row=0; row< rowsCounter; row++) {
			List<WebElement> columnsRow= rowsTable.get(row).findElements(By.tagName("td"));
			int columnsCounter= columnsRow.size();
			for (int column= 0; column< columnsCounter; column++) {
				String cellText= columnsRow.get(column).getText();
				if (cellText.equals(str)==true && driver.getPageSource().contains(str)==true) {
					System.out.println("\n\n"+ cellText+ " is existed on the webpage\n\n");
				}
				else if (cellText.equals(str)==!true) { 
					System.out.println(str+ " is not found on the webpage");
				}
			}
		}
	}
}
