package Booking.BookingCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//@@@@@@@@@@@@@@@@@@@@Testing
public class CreateItemsPXC {
public static void main(String[] args) throws InterruptedException {
	 WebDriver driver = new ChromeDriver();
     driver.get("https://hhhhteams.sharepoint.com/sites/HHHH/SP/SitePages/PX-Profile.aspx?ProjectId=3637");
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//test comment for Jenkins cicd testing
     // Login steps
     WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".form-control.ltr_override")));
     emailField.sendKeys("ritik.yadav@hochhuth-consulting.de");
     driver.findElement(By.cssSelector(".win-button.button_primary")).click();
     Thread.sleep(2000);
     WebElement PasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".form-control.input.ext-input")));
     PasswordField.sendKeys("1z*G4m85a");
     driver.findElement(By.id("idSIButton9")).click();
     WebElement finalSignin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
     finalSignin.click();
}
}
