package ritikyadav.Testcomponents;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ExtentReporterNg;

public class Listeners extends BaseTest implements ITestListener
{
	  ExtentTest test;
	  ExtentReports extent= ExtentReporterNg.getReportObject();
	    public void onTestStart(ITestResult result) {
	       test= extent.createTest(result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	    	test.log(Status.PASS, "status is passed");
	        
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        test.fail(result.getThrowable());
	       try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
	       
	        //take screenshot, Attach report 
	        String filepath =getScreenshot(result.getMethod().getMethodName(),driver);
	        test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	    }
	    
	    @Override
	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }
}
