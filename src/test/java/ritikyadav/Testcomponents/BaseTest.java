package ritikyadav.Testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ritikyadav.pageobjects.BookingTickets;

public class BaseTest {

	public WebDriver driver;

	public WebDriver initializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src/test/java/Resources/globaldata.properties");
		prop.load(fis);
		String browsername=System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
		
		if (browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		if (browsername.equalsIgnoreCase("Edge")) {
			
			//System.setProperty("webdriver.gecko.driver", "/Users/ritikyadav/Downloads/edgedriver_mac64/msedgedriver");
			System.setProperty("webdriver.edge.driver", "/Users/ritikyadav/Downloads/edgedriver_mac64/msedgedriver");

			driver = new EdgeDriver();
		}
		if (browsername.equalsIgnoreCase("Firefox")) {
			
			//System.setProperty("webdriver.edge.driver", "/Users/ritikyadav/Downloads/Firefox 141.0.dmg");
			System.setProperty("webdriver.gecko.driver", "/Users/ritikyadav/Downloads/geckodriver");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}

	public String getScreenshot(String testcasename, WebDriver driver2) {
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File src = ts.getScreenshotAs(OutputType.FILE);
	    File destination = new File(System.getProperty("user.dir") + "//reports//" + testcasename + ".png");
	    try {
	        FileUtils.copyFile(src, destination);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return System.getProperty("user.dir") + "//reports//" + testcasename + ".png" ;
	}


	public BookingTickets launchApp() throws IOException 
	{
		driver =initializeDriver();
		BookingTickets book=new BookingTickets(driver);
		book.landingPage();
		return book;
	}
	



}
