package Booking.BookingCode;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class teamCompositionPXC {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hhhhteams.sharepoint.com/sites/HHHH/SP/SitePages/PX-Profile.aspx?ProjectId=7073");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

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

        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
        driver.findElement(By.xpath("(//span[@title='Edit Project'])[1]")).click();

        // click on Team Composition Tab
        WebElement ClickOnTab = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("team-tab"))));
        ClickOnTab.click();

        WebElement target = driver.findElement(By.cssSelector(".UserTimeTabGray.assignUserBox.border-end.p-0"));

        // Add first user
        addUserWithRole(driver, wait, "Prashant Kumar", target, "Lead ", "Lead of the Project");

        // Click category header before adding second user
        driver.findElement(By.xpath("(//div[@class='CategoryBox-CategoryHeader'])[2]")).click();
        Thread.sleep(1000);

        // Add second user
        addUserWithRole(driver, wait, "Abhishek Tiwari", target, "Implementation Lead ", "Technical person of this Project");
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//div[@class='CategoryBox-CategoryHeader'])[3]")).click();
        Thread.sleep(5000);

        // Add third  user
        addUserWithRole(driver, wait, "Ankita Pandit", target, "QA ", "Test the Project");

        driver.findElement(By.xpath("(//div[@class='CategoryBox-CategoryHeader'])[4]")).click();
        Thread.sleep(5000);

        // Add fourth  user
        addUserWithRole(driver, wait, "Kamal Kishore", target, "Designer", "Designer of this project");

        driver.findElement(By.xpath("(//div[@class='CategoryBox-CategoryHeader'])[5]")).click();
        Thread.sleep(5000);

        // Add fifth  user
        addUserWithRole(driver, wait, "Satyendra Kumar", target, "Members", "UX Member of this project");



        // Save changes
        WebElement SaveButton1 = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".btn.btn-primary.me-1"))));
        SaveButton1.click();

        // Optionally quit driver if needed
        // driver.quit();
    }

    private static void addUserWithRole(WebDriver driver, WebDriverWait wait, String userName, WebElement target, String roleName, String description) throws InterruptedException {
        WebElement source = driver.findElement(By.xpath("(//span[@title='" + userName + "'])[2]"));

        // Drag and drop user
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).build().perform();

        // Select role
        WebElement RoleSection = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Select Role']"))));
        Thread.sleep(5000);
        RoleSection.click();

        WebElement SelectRole = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='" + roleName + "']"))));
        Thread.sleep(2000);
        System.out.println("SelectRole text: " + SelectRole.getText());
        SelectRole.click();

        // Enter description and save
        driver.findElement(By.cssSelector(".form-control.w-100")).sendKeys(description);
        driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.float-end")).click();
        Thread.sleep(3000);

        WebElement OkButton = driver.findElement(By.xpath("//button[text()='OK']"));
        OkButton.click();
    }
}
