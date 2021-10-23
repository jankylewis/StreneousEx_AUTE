package TH_23_10_2021_APPLIED_TESTNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AppliedTestNGListerner implements ITestListener {
		
		public boolean checkTheOverriddenIsPerformed; 
	
		@Override
		public void onFinish(ITestContext df) {
			System.out.println("\r\r//-----**//-----TEST CASE ENDS-----//**-----//\r\r");
		}
		
		@Override
		public void onStart(ITestContext df) {
			System.out.println("\r\r//-----**//-----TEST CASE STARTS-----//**-----//\r\r");
		}
		
		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
			
		}
		
		@Override
		public void onTestFailure(ITestResult failedTestCaseName) {
			
			this.checkTheOverriddenIsPerformed=true;
			if (checkTheOverriddenIsPerformed==true) {
				
				//LISTENER IS CALLED
				
				System.out.println("Test case named"+ " "+
													
													failedTestCaseName.getName()+
													
													" "+ "being failed ");
			}
			
			else {
				this.checkTheOverriddenIsPerformed=false;
			}
			
			
		}
		
		@Override
		public void onTestSkipped(ITestResult skippedTestCaseName) {
			
			this.checkTheOverriddenIsPerformed=true;
			if (checkTheOverriddenIsPerformed==true) {
				System.out.println("Test case grouped "+ 
						
													skippedTestCaseName.getName()+
					
													" "+ "being skipped due to an unexpected reason");
			}
			else {
				this.checkTheOverriddenIsPerformed=false;
			}

		}
		
		@Override
		public void onTestStart(ITestResult beingStartedTestCaseName) {
			
			this.checkTheOverriddenIsPerformed=true;
			if (checkTheOverriddenIsPerformed!=false) {
				System.out.println("Test case named"+ " "+ 
						
													beingStartedTestCaseName.getName()+
					
									" "+ "being started by Selenium WebDriver");
			}
			else {
				this.checkTheOverriddenIsPerformed=false;
			}
		}
		
		@Override
		public void onTestSuccess(ITestResult beingPassedTestCaseName) {
			this.checkTheOverriddenIsPerformed=true;
			if (checkTheOverriddenIsPerformed==true) {
				System.out.println("Test case named"+ " "+
						
													beingPassedTestCaseName.getName()+
					
													" "+ "passed!!");
			}
			
			else {
				this.checkTheOverriddenIsPerformed=false;
			}
		}
}
