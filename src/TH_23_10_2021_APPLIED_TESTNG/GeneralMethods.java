package TH_23_10_2021_APPLIED_TESTNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class GeneralMethods {
	
	public static boolean checkIfCaseIsAbleToBePassed;
	public String registerTitle;
	
//	@FindBy(xpath= "//td[@valign]//descendant::a[contains(text(),\"REGISTER\")]")
//	@CacheLookup
//	WebElement LNK_REGISTER_LOCATOR;
	
	public void pauseWithTryCatch(int timeSecond) {
		try {
			Thread.sleep(timeSecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void executeScrollingDown(WebDriver dr, JavascriptExecutor js, int scrollUnit) {
		((JavascriptExecutor)dr).executeScript("scroll(0,"+scrollUnit+")");
	}
	
	public void clickOnExpLink(WebDriver dr, 
						String elementLocatorBe4, 
					String expTitleBe4, 
				String elementLocatorAf,
			String expTitleAf) {
			
			WebElement elementLocatedBe4= dr.findElement(By.xpath(elementLocatorBe4));
			
			if (elementLocatedBe4.isDisplayed()==true 
					|| elementLocatedBe4.isEnabled()==true
						|| checkIfCaseIsAbleToBePassed) {
				elementLocatedBe4.click();
				this.registerTitle=dr.getTitle();
				System.out.println("\r\r"+ registerTitle+ "\r\r");
			}
			
			WebElement elementLocatedAf= dr.findElement(By.xpath(elementLocatorAf));
			if (registerTitle.contains(expTitleBe4)==true) {
				checkIfCaseIsAbleToBePassed=true;
				elementLocatedAf.click();
				this.registerTitle= dr.getTitle();
				System.out.println("\n\n"+ registerTitle+ "\n\n");
					if (registerTitle.contains(expTitleAf)==true) {
						checkIfCaseIsAbleToBePassed=true;
					}
			}
			else {
				checkIfCaseIsAbleToBePassed=false;
			}
			
		}
	
	public void clickOnExpElement (WebDriver dr, String expElement) {
		
		WebElement elementLocated= dr.findElement(By.xpath(expElement));
		if (elementLocated.isDisplayed()==true || checkIfCaseIsAbleToBePassed) {
			elementLocated.click();
		}
		
	}
		
	public void createAccount(WebDriver dr, String registerElementLocator) {
		
		WebElement registerLocated= dr.findElement(By.xpath(registerElementLocator));
		if (registerLocated.isDisplayed()==true) {
			registerLocated.click();
		}
		else {
			dr.quit();
		}
		
	}
	
	public void sendKeyToTextBox(WebDriver dr, String keyDesired, String elementDesired) {
		
		WebElement elementDesiredLocated= dr.findElement(By.xpath(elementDesired));
		if (elementDesiredLocated.isDisplayed()==true) {
			elementDesiredLocated.clear();
			elementDesiredLocated.sendKeys(keyDesired);
		}
		
	}
	
	public void selectKeyFromDropDownListStatic(WebDriver dr, String ddlNameDesired, String valueDesired) {
		
		Select valueFromDDL= new Select(dr.findElement(By.name(ddlNameDesired)));
		valueFromDDL.selectByValue(valueDesired.toString());
		
	}
	
	public void clickSubmitButton(WebDriver dr, String submitLocator) {
		
		WebElement submitButtonLocated= dr.findElement(By.xpath(submitLocator));
		if (submitButtonLocated.isEnabled()!=false) {
			submitButtonLocated.click();
		}
		
	}
	
	public void findOneFlightTicket(WebDriver dr, String registerElementLocator) {
		
		WebElement registerLocated= dr.findElement(By.xpath(registerElementLocator));
		if (registerLocated.isDisplayed()==true) {
			registerLocated.click();
		}
		else {
			dr.quit();
		}
		
	}
	
}
