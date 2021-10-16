package TH_9_10_2021_REFINED;

import java.util.List;

//import org.graalvm.compiler.core.common.SuppressSVMWarnings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TCs_HandleTableFunctions extends AbstractClass{
	
//	@SuppressWarnings("The variable baseURL is declared in the AbstractClass already")
//	private String baseURL= "http://demo.guru99.com";
	
	@Test(groups= {"Total Number of Row", "001"}, 
			enabled = true, 
				invocationCount = 1, 
					description = "this test scenario will get total number of row of the given page")
	
	public void getTotalRowNumberTest() throws InterruptedException {
		
		testcaseSetUp(baseURL+ "/test/web-table-element.php", brRandom);
		
		HandleTablePage htp= new HandleTablePage();
		
		if (htp.checkIfCaseIsAbleToBePassed==false) {
			htp.getTotalRowNumber(driver);
			Assert.assertFalse(false);
			System.out.println("\r\rTEST CASE 001 IS PASSED!\r");
		}
		else {
			Assert.assertFalse(true);
			System.out.println("\r\rTEST CASE 001 IS FAILED\r!");
		}

		testCaseTearDown();
	}
	
	@Test(groups= {"Total Number of Column", "002"}, priority = -1)
	public void getTotalColumnNumberTest() throws InterruptedException {
		
		testcaseSetUp(baseURL+ "/test/web-table-element.php", brRandom);
		
		HandleTablePage htp= new HandleTablePage();
		
		if (htp.checkIfCaseIsAbleToBePassed==false) {
			htp.getTotalColumnNumber(driver);
			Assert.assertFalse(false);
			System.out.println("\r\rTEST CASE 002 IS PASSED!\r");
		}
		
		else {
			Assert.assertFalse(true);
			System.out.println("\r\rTEST CASE 002 IS FAILED\r!");
		}

		testCaseTearDown();
	}
	
	@Test(groups= {"Input Value and Get the Number of Row", "003"}, 
			priority = 0, dataProvider = "none")
	public void getRowNumberByValueTest() throws InterruptedException {
		
		testcaseSetUp(baseURL+ "/test/web-table-element.php", brRandom);
		
		HandleTablePage htp= new HandleTablePage();
		
		if (htp.checkIfCaseIsAbleToBePassed!=true) {
			
			htp.getRowNumberByValue("Bank", driver, javascript, 450);
			
			Assert.assertFalse(false);
			System.out.println("\r\rTEST CASE 003 IS PASSED!\r");
		}
		
		else {
			Assert.assertFalse(true);
			System.out.println("\r\rTEST CASE 003 IS FAILED\r!");
		}
		
		testCaseTearDown();
	}
	
	@Test(groups= {"Input Row, Number and Get Value", "004"}, priority = 1)
	public void getTableCellValueTest() throws InterruptedException {
		
		testcaseSetUp(baseURL+ "/test/web-table-element.php", brRandom);
		
		HandleTablePage htp= new HandleTablePage();
		
		if (htp.checkIfCaseIsAbleToBePassed==false) {
			
			htp.getTableCellValue(6, 4, driver);
			
			Assert.assertFalse(false);
			System.out.println("\r\rTEST CASE 004 IS PASSED!\r");
		}
		else {
			Assert.assertFalse(true);
			System.out.println("\r\rTEST CASE 003 IS FAILED\r!");
		}
		
		testCaseTearDown();
	
	}
	
	@Test(groups= {"Check If Item Is Existed", "005"}, priority = 2)
	public void checkIfItemIsAppeared() throws InterruptedException {
		
		testcaseSetUp(baseURL+ "/test/web-table-element.php", brRandom);
		
		HandleTablePage htp= new HandleTablePage();
		
		if (htp.checkIfCaseIsAbleToBePassed==false) {
			
			htp.checkItemExistsOnTable("Central Bank", driver);;;;;;;;;;;;;;;;;;;;;;;;;;;;;
			
			Assert.assertFalse(false);
			System.out.println("\r\rTEST CASE 005 IS PASSED!\r");
		}
		else {
			Assert.assertFalse(true);
			System.out.println("\r\rTEST CASE 005 IS FAILED\r!");
		}
		
		testCaseTearDown();
	
	}
	
}
