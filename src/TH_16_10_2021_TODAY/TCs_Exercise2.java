package TH_16_10_2021_TODAY;

import java.util.Random;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TCs_Exercise2 extends BaseClass{

	private int randomNum= new Random().nextInt(50000);
	
	private String LNK_REGISTER_LOCATOR= "//td[@valign]//descendant::a[contains(text(),\"REGISTER\")]";
	private String LNK_SIGN_ON_LOCATOR= "//td[@valign]//descendant::a[contains(text(),\"SIGN\")]";
	private String LNK_FLIGHT_LOCATOR= "//tr[@valign]//a[contains(text(),\"Flight\")]";
	private String TXT_FIRST_NAME_LOCATOR= "//form[@method=\"post\"]//following::input[@name=\"firstName\"]";
	private String TXT_LAST_NAME_LOCATOR= "//form[@method=\"post\"]//following::input[@name=\"lastName\"]";
	private String TXT_PHONE_LOCATOR= "//form[@method=\"post\"]//following::input[@name=\"phone\"]";
	private String TXT_USERNAME_LOCATOR= "//form[@method=\"post\"]//following::input[@name=\"userName\" or @id=\"userName\"]";
	private String TXT_ADDRESS_LOCATOR= "//form[@method=\"post\"]//following::input[contains(@name, \"address\")]";
	private String TXT_CITY_LOCATOR= "//form[@method=\"post\"]//following::input[@name=\"city\"]";
	private String TXT_STATE_LOCATOR= "//form[@method=\"post\"]//following::input[@name=\"state\"]";
	private String TXT_POSTAL_CODE_LOCATOR= "//form[@method=\"post\"]//following::input[@name=\"postalCode\"]";
	private String TXT_USER_EMAIL_LOCATOR= "//form[@method=\"post\"]//following::input[@name=\"email\"]";
	private String TXT_PASSWORD_LOCATOR= "//form[@method=\"post\"]//following::input[@name=\"password\"]";
	private String TXT_PASSWORD_CONFIRMATION_LOCATOR= "//form[@method=\"post\"]//following::input[@name=\"confirmPassword\"]";
	private String BTN_SUBMIT_LOCATOR= "//form[@method=\"post\"]//following::input[@name=\"submit\" and @type= \"submit\"]";
	private String RDB_CLASS_LOCATOR= "//following::input[@name=\"servClass\" and @value= \"Business\"]";
	private String BTN_FIND_LOCATOR ="//following::input[@name=\"findFlights\"]";
	
	private String LBL_DEAR_LOCATOR_AF= "//b[contains(text(),\"Dear\")]";
	private String LBL_NOTE_LOCATOR_AF= "//b[contains(text(),\"Your user name\")]";
	private String LBL_LOGIN_SUCCESSFULLY_AF= "//table//h3";
	
	private String firstName= "VinhAK";
	private String lastName= "Tran";
	private String ranEmail= "vinhak"+ String.valueOf(randomNum)+ "@gmail.com";
	private String expFullName= firstName+ " "+ lastName;
	private String expTextAfLoginSuccessfully= "Login Successfully";
	
	@Test(groups= {"Create An Account", "001"}, 
			enabled = true, 
				invocationCount = 1, 
							priority = -1)
	
	public void clickRegisterLinkTest() throws InterruptedException {
		
		testcaseSetUp(baseURL, brRandom);
		
		GeneralMethods ex2= new GeneralMethods();
		
		ex2.createAccount(driver, LNK_REGISTER_LOCATOR);
		
		//CONTACT INF
		ex2.sendKeyToTextBox(driver, "VinhAK", TXT_FIRST_NAME_LOCATOR);
		ex2.sendKeyToTextBox(driver, "Tran", TXT_LAST_NAME_LOCATOR);
		ex2.sendKeyToTextBox(driver, "0928174817", TXT_PHONE_LOCATOR);
		ex2.sendKeyToTextBox(driver, ranEmail, TXT_USERNAME_LOCATOR);
		
		//MAILING INFOR
		ex2.sendKeyToTextBox(driver, "210 Flabbergasted Flower", TXT_ADDRESS_LOCATOR);
		ex2.sendKeyToTextBox(driver, "Unknown", TXT_CITY_LOCATOR);
		ex2.sendKeyToTextBox(driver, "Vancouver", TXT_STATE_LOCATOR);
		ex2.sendKeyToTextBox(driver, "0291M", TXT_POSTAL_CODE_LOCATOR);
		ex2.selectKeyFromDropDownListStatic(driver, "country", "Vietnam".toUpperCase());
		
		//USER INFOR
		ex2.sendKeyToTextBox(driver, ranEmail, TXT_USER_EMAIL_LOCATOR);
		ex2.sendKeyToTextBox(driver, "password1", TXT_PASSWORD_LOCATOR);
		ex2.sendKeyToTextBox(driver, "password1", TXT_PASSWORD_CONFIRMATION_LOCATOR);
		
		//CLICK ON SUBMIT BUTTON
		ex2.pauseWithTryCatch(2000);
		ex2.executeScrollingDown(driver, javascript, 350);
		ex2.clickSubmitButton(driver, BTN_SUBMIT_LOCATOR);
		
		String expEmail= ranEmail;
		if (driver.findElement(
				By.xpath(LBL_DEAR_LOCATOR_AF)).getText().contains(expFullName)==true
					&& driver.findElement(By.xpath(LBL_NOTE_LOCATOR_AF)).getText().contains(expEmail)) {
			Assert.assertFalse(false);
			System.out.println("\r\r//-----------//-------***TEST CASE 001 IS PASSED! ***------//-----------------//\r\r");
		}
		else {
			Assert.assertFalse(true);
			System.out.println("\r\r//-----------//-------***TEST CASE 001 IS FAILED! ***------//-----------------//\r\r");
		}
		
		ex2.pauseWithTryCatch(500);
//		testCaseTearDown();
		
	}
	
	@Test(groups= {"Sign In With The Created Account", "002"}, 
			enabled = true, 
				invocationCount = 1, 
							priority = 0)
	
	public void logInTest() throws InterruptedException {
		
		testcaseSetUp(baseURL, brRandom);
		
		GeneralMethods ex2= new GeneralMethods();
		
		ex2.createAccount(driver, LNK_SIGN_ON_LOCATOR);
		
		//ENTER USER INFOR
		ex2.sendKeyToTextBox(driver, "vinhak@gmail.com", TXT_USERNAME_LOCATOR);
		ex2.sendKeyToTextBox(driver, "password1", TXT_PASSWORD_LOCATOR);
		
		//CLICK ON LOGIN BUTTON
		ex2.clickSubmitButton(driver, BTN_SUBMIT_LOCATOR);
		
		if (driver.findElement(By.xpath(LBL_LOGIN_SUCCESSFULLY_AF)).getText().equals(expTextAfLoginSuccessfully)==true) {
			Assert.assertFalse(false);
			System.out.println("\r\r//-----------//-------***TEST CASE 002 IS PASSED! ***------//-----------------//\r\r");
		}
		else {
			Assert.assertFalse(true);
			System.out.println("\r\r//-----------//-------***TEST CASE 002 IS FAILED! ***------//-----------------//\r\r");
		}
		
		ex2.pauseWithTryCatch(500);
//		testCaseTearDown();
		
	}
	
	@Test(groups= {"Find One Flight Ticket", "003"}, 
			enabled = true, 
				invocationCount = 1, 
							priority = -2)
	
	public void findOneFlightTicketTest() throws InterruptedException {
		
		testcaseSetUp(baseURL, brRandom);
		
		GeneralMethods ex2= new GeneralMethods();
		
		ex2.findOneFlightTicket(driver, LNK_FLIGHT_LOCATOR);
		
		//SELECT DESIRED VALUES
		ex2.selectKeyFromDropDownListStatic(driver, "passCount", "2");
		ex2.selectKeyFromDropDownListStatic(driver, "fromPort", "Paris");
		ex2.selectKeyFromDropDownListStatic(driver, "fromMonth", "September");
		ex2.selectKeyFromDropDownListStatic(driver, "fromDay", "29");
		
		ex2.selectKeyFromDropDownListStatic(driver, "toPort", "Paris");
		ex2.selectKeyFromDropDownListStatic(driver, "toMonth", "September");
		ex2.selectKeyFromDropDownListStatic(driver, "toDay", "30");
		ex2.clickOnExpElement(driver, RDB_CLASS_LOCATOR);
		ex2.selectKeyFromDropDownListStatic(driver, "airline", "No Preference");
		
		//CLICK ON FIND ONE FLIGHT TICKET BUTTON
		ex2.clickOnExpElement(driver, BTN_FIND_LOCATOR);
	}
}
