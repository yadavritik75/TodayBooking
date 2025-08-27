package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNg {
public static ExtentReports getReportObject()
{
	String path=System.getProperty("user.dir")+"//reports//index.html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	reporter.config().setReportName("Automation result");
	reporter.config().setDocumentTitle("Test Automation Result");


	ExtentReports extent=new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Ritik Yadav");
	return extent;


}
}
