package TH_16_10_2021_TODAY;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TCs_Exercise1 extends BaseClass{
	
	private String LNK_REGISTER_LOCATOR= "//td[@valign]//descendant::a[contains(text(),\"REGISTER\")]";
	private String LNK_SUPPORT_LOCATOR= "//td[@valign]//descendant::a[contains(text(),\"SUPPORT\")]";
	private String LNK_BACk_TO_HOME_LOCATOR= "//tr[@valign]//a[contains(text(),\"Home\")]";
	private String BTN_BACK_TO_HOME_LOCATOR= "//tr[@valign]//following::a//img[1]";
	
	private String homeExpTitle= "Welcome";
	private String registerExpTitle= "Register";
	private String supportExpTitle= "Construction";
	
	@Test(groups= {"Click Register Link", "001"}, 
			enabled = true, 
				invocationCount = 1, 
					description = "this test scenario is to click on "
						+ "Register link that is located on the website",
							priority = -1)
	
	public void clickRegisterLinkTest() throws TimeoutException {
	
		testcaseSetUp(baseURL, brRandom);
		
		GeneralMethods ex1= new GeneralMethods();
		
		ex1.clickOnExpLink(driver, 
							LNK_REGISTER_LOCATOR, 
								registerExpTitle, 
									LNK_BACk_TO_HOME_LOCATOR,
										homeExpTitle);
		
		if (ex1.checkIfCaseIsAbleToBePassed==true) {
			Assert.assertFalse(false);
			System.out.println("\r\r//-----------//-------***TEST CASE 001 IS PASSED! ***------//-----------------//\r\r");
		}
		else {
			Assert.assertFalse(true);
			System.out.println("\r\r//-----------//-------***TEST CASE 001 IS FAILED! ***------//-----------------//\r\r");
		}
		testCaseTearDown();
		
	}

	@Test(groups= {"Click Support Link", "002"}, 
	enabled = true, 
		invocationCount = 1, 
			description = "this test scenario is to click on "
				+ "Support link that is located on the website",
					priority = -1)
	
	public void clickSupportLinkTest() throws TimeoutException {
	
		testcaseSetUp(baseURL, brRandom);
		
		GeneralMethods ex1= new GeneralMethods();
		
		ex1.clickOnExpLink(driver, 
							LNK_SUPPORT_LOCATOR, 
								supportExpTitle, 
									BTN_BACK_TO_HOME_LOCATOR,
										homeExpTitle);
		
		if (ex1.checkIfCaseIsAbleToBePassed==true) {
			Assert.assertFalse(false);
			System.out.println("\r\r//-----------//-------***TEST CASE 002 IS PASSED! ***------//-----------------//\r\r");
		}
		else {
			Assert.assertFalse(true);
			System.out.println("\r\r//-----------//-------***TEST CASE 002 IS FAILED! ***------//-----------------//\r\r");
		}
		testCaseTearDown();
		
	}
	
}
