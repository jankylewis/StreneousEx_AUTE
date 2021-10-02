package TH_2_10_Team1;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class selectMenuItemTest {

	public static void main(String[] args) {
		
		String baseURL= "https://guru99.com";
		int waitTime= 50;
		
		//trigger browser
		System.setProperty("webdriver.gecko.driver", ".\\driver\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
		
		//utilize the defined method
		selectMenuItem("Web", driver);
	}
	
	//define method
	public static void selectMenuItem(String str, WebDriver dr) {
		WebElement listElement= dr.findElement(By.xpath("//li[@id]"));
		List<WebElement> childElements= listElement.findElements(By.xpath("//*[@id]/a/span[text()]"));
		for (int i=0; i< childElements.size(); i++) {
			if (childElements.get(i).getText().equals(str)) {
				childElements.get(i).click();
			}
		}	
		dr.close();
	}

}
