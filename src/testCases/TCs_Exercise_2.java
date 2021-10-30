package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import pageObjects.LogInPage;

import utilities.ExcelUtils;


public class TCs_Exercise_2 extends AbstractClass{
	
	final static Logger logger = Logger.getLogger(ExcelUtils.class);
	private String LBL_MANAGER_ID_LOCATOR= "//tr//td[1][@style]";
	private boolean checkTestCase;
	
	@Test(groups= {"001"}, 
			description = "",
					priority = -1)
	public void checkLoginSuccessfully() throws Exception {
		
		ExcelUtils ex= new ExcelUtils();
		ex.setExcelFile("G:\\ECLIPSE\\workspace\\exercises_AUTE_30_10\\src\\testData\\DDT_LogIn_Data.xlsx", "LogInPassed");
		ex.getRowUsed();
		
		String userName= ex.getCellData(1, 0);
		String password= ex.getCellData(1, 1);
		
		testCaseSetUp(baseURL+ "/v4", "chrome");
		
		LogInPage lip= new LogInPage(driver);
		lip.inputUserId(userName);
		
		lip.pauseWithTryCatch(1000);
//		webelement.sendKeys(Keys.TAB);
		
		lip.inputPassword(password);
		lip.clickBtnLogin();
		
//		System.out.println(userName+ "\r\r"+ password);
		
		if (driver.findElement(By.xpath(LBL_MANAGER_ID_LOCATOR)).isDisplayed()==true
				&& driver.findElement(By.xpath(LBL_MANAGER_ID_LOCATOR)).getText().contains(userName)) {
			this.checkTestCase=true;
			Assert.assertFalse(false);
			logger.info("Test Case 001 is passed!");	
		}
		testCaseTearDown();
	}
		
	@Test(groups= {"002"}, 
			description = "",
					priority = 0)
	public void checkLoginUnSuccessfully() throws Exception {
		
		ExcelUtils ex= new ExcelUtils();
		ex.setExcelFile("G:\\ECLIPSE\\workspace\\exercises_AUTE_30_10\\src\\testData\\DDT_LogIn_Data.xlsx", "LogInFailed");
		ex.getRowUsed();
		
		testCaseSetUp(baseURL+ "/v4", "chrome");
		
		LogInPage lip= new LogInPage(driver);
		
		checkLoginFailed: for (int i = 0; i < 3; i++) {
			
			//get username along with password
			String userName= ex.getCellData(i+1, 0);
			String password= ex.getCellData(i+1, 1);
			
			lip.inputUserId(userName);
			
			lip.pauseWithTryCatch(1000);
			
			lip.inputPassword(password);	
			lip.clickBtnLogin();
			
			lip.pauseWithTryCatch(3000);
			
			lip.isAlertPresent(driver); 
				
			if (lip.checkIfAlertPresent==true) {
				Assert.assertFalse(false);	
			}
			else {
				Assert.assertFalse(true);
				testCaseTearDown();		
			}
			driver.navigate().refresh();	
		}
		testCaseTearDown();
	}
}
