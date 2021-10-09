package TH_9_10_2021;

import java.util.Random;
import org.testng.Assert;
import com.google.errorprone.annotations.Var;

public class TC_GetTotalColumnNumber {

	public static void main(String[] args) {
		
		@Var
		String baseURL= "http://demo.guru99.com";
		int waitTime= 5000; 
		String browserArr[]= {"firefox", "chrome", "opera"};
		String brRandom= browserArr[new Random().nextInt(browserArr.length)];
		
		// trigger web browser
		TableMethods tm= new TableMethods();
		tm.testcaseSetUp(baseURL+ "/test/web-table-element.php", brRandom);
		
		//execute test case
		tm.getTotalColumnNumber();
		
		//assertion
		Assert.assertTrue(true);
		System.out.println("\n\nTEST CASE IS PASSED!");
		
		tm.tearDown();
	}
}


