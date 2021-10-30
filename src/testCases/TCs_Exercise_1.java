package testCases;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LogInPage;

public class TCs_Exercise_1 extends AbstractClass{
	
	private String LBL_GURU99BANK_LOCATOR= "//div//h2[@class and @style]";
	private String LBL_MANAGER_ID_LOCATOR= "//tr//td[1][@style]";
	
	private String userID= "mngr362985";
	private String password= "pygyhab";
	
	private boolean checkTestCaseIsPassed;
	
	@Test(groups= {"001"}, 
					description = "",
							priority = -1)
	
	public void logInTest() throws TimeoutException {
		
		testCaseSetUp(baseURL+ "/v4", "chrome");
		
		if (driver.findElement(By.xpath(LBL_GURU99BANK_LOCATOR)).isDisplayed()==true) {
			this.checkTestCaseIsPassed=true;
		}
		
		LogInPage lip= new LogInPage(driver);
		lip.inputUserId(userID);
		
		lip.pauseWithTryCatch(1000);
//		webelement.sendKeys(Keys.TAB);
		
		lip.inputPassword(password);
		lip.clickBtnLogin();
		
		if (driver.findElement(By.xpath(LBL_MANAGER_ID_LOCATOR)).isDisplayed()==true
				&& driver.findElement(By.xpath(LBL_MANAGER_ID_LOCATOR)).getText().contains(userID)) {
			this.checkTestCaseIsPassed=true;
			Assert.assertFalse(false);
		}
		
//		testCaseTearDown();
		
	}
}
