package testCases;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.google.errorprone.annotations.Var;

public class AbstractClass {

	@Var
	public static JavascriptExecutor javascript;
	public Actions action;
	public WebDriver wait;
	public static WebDriver driver;
	public static WebElement webelement;
	
	public String browserArr[]= {"firefox", "chrome", "opera"};
	public String brRandom= browserArr[new Random().nextInt(browserArr.length)];
	String baseURL= "http://demo.guru99.com";
	
	@BeforeTest
	public void testCaseSetUp(String baseURL, String br) {
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
	
	@AfterTest
	public void testCaseTearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	
}
