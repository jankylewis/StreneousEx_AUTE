package pageObjects;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import testCases.AbstractClass;

public class LogInPage {
	
	public Actions action;
	public WebDriverWait wait;
	
	WebDriver ldriver;
	public LogInPage(WebDriver rdriver) {
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
		action= new Actions(rdriver);
		//time=>second
		wait= new WebDriverWait(rdriver, 50);
	}
	
	@FindBy(xpath= "//td//input[@type=\"text\" and @name=\"uid\"]")
	@CacheLookup
	WebElement TXT_USERID;
	
	@FindBy(xpath= "//td//input[@type=\"password\" and @name=\"password\" and @onkeyup]")
	@CacheLookup
	WebElement TXT_PASSWORD;
	
	@FindBy(xpath= "//td//input[@type=\"submit\" and @name=\"btnLogin\" and @value]")
	@CacheLookup
	WebElement BTN_LOGIN;
	
	public void inputUserId(String userID) {
		TXT_USERID.clear();
		TXT_USERID.sendKeys(userID);
	}
	
	public void inputPassword(String password) {
		TXT_PASSWORD.clear();
		TXT_PASSWORD.sendKeys(password);
	}
	
	public void clickBtnLogin() {
		if (BTN_LOGIN.isDisplayed()==true) {
			BTN_LOGIN.click();
		}
	}
	
	public void pauseWithTryCatch(int timeSecond) {
		try {
			Thread.sleep(timeSecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean checkIfAlertPresent;
	
	public boolean isAlertPresent(WebDriver dr) 
	{ 
		
	    try 
	    { 
	        dr.switchTo().alert();
	        checkIfAlertPresent=true;
	        return checkIfAlertPresent; 
	    }  
	    catch (NoAlertPresentException Ex) 
	    { 
	        return checkIfAlertPresent=false; 
	    }   
	}
}
