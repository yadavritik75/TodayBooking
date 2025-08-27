package Booking.BookingCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class TeamComposition {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://hhhhteams.sharepoint.com/sites/HHHH/SP/SitePages/PX-Profile.aspx?ProjectId=7073");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		// Enter email
		WebElement emailField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".form-control.ltr_override")));
		emailField.sendKeys("ritik.yadav@hochhuth-consulting.de");
		// Click Next/Login button
		driver.findElement(By.cssSelector(".win-button.button_primary")).click();
		// Now wait for the password field to appear
		Thread.sleep(2000);
		WebElement PasswordField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".form-control.input.ext-input")));
		PasswordField.sendKeys("1z*G4m85a");
		// Click Sign In
		driver.findElement(By.id("idSIButton9")).click();
		// click finally Login Button
		WebElement finalSignin = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
		finalSignin.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
		driver.findElement(By.xpath("(//span[@title='Edit Project'])[1]")).click();
		// click on Team Composition Tab
		WebElement ClickOnTab = wait
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("team-tab"))));
		ClickOnTab.click();
		WebElement source = driver.findElement(By.xpath("(//span[@title='Prashant Kumar'])[2]"));
		WebElement target = driver.findElement(By.cssSelector(".UserTimeTabGray.assignUserBox.border-end.p-0"));

		// Create Actions object
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).build().perform();
		WebElement RoleSection = wait.until(
				ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Select Role']"))));
		Thread.sleep(5000);
		RoleSection.click();
		WebElement SelectRole = wait
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Lead ']"))));
		Thread.sleep(2000);
		System.out.println("SelectRole text: " + SelectRole.getText());

		SelectRole.click();
		driver.findElement(By.cssSelector(".form-control.w-100")).sendKeys("Lead of the Project");
		driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.float-end")).click();
		Thread.sleep(3000);

		WebElement OkButton=driver.findElement(By.xpath("//button[text()='OK']"));
		OkButton.click();

		driver.findElement(By.xpath("(//div[@class='CategoryBox-CategoryHeader'])[2]")).click();
		Thread.sleep(1000);
		WebElement source1 = driver.findElement(By.xpath("(//span[@title='Abhishek Tiwari'])[2]"));
		//WebElement target1 = driver.findElement(By.cssSelector(".UserTimeTabGray.assignUserBox.border-end.p-0"));
		actions.dragAndDrop(source1, target).build().perform();

		WebElement RoleSection1 = wait.until(
				ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Select Role']"))));
		Thread.sleep(2000);
		RoleSection1.click();


		WebElement SelectRole1 = wait
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Implementation Lead ']"))));
		Thread.sleep(5000);
		System.out.println("SelectRole text: " + SelectRole1.getText());

		SelectRole1.click();
		driver.findElement(By.cssSelector(".form-control.w-100")).sendKeys("Technical person of this Project");
		driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.float-end")).click();
		Thread.sleep(1000);

		WebElement OkButton1=driver.findElement(By.xpath("//button[text()='OK']"));
		OkButton1.click();
		WebElement SaveButton1 = wait.until(
				ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".btn.btn-primary.me-1"))));
		SaveButton1.click();


	}
}
