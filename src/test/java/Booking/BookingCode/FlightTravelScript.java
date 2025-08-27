package Booking.BookingCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FlightTravelScript {

public static void main(String[] args) throws InterruptedException {
// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
driver.findElement(By.xpath("//a[@value='MAA']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='BLR']")).click();
driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']")).click();
Thread.sleep(2000);
driver.findElement(By.cssSelector("a.ui-state-default.ui-state-active")).click();
driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
Thread.sleep(2000);
int i;
for(i=1;i<5;i++)
{
driver.findElement(By.cssSelector("#hrefIncAdt")).click();
}
Thread.sleep(2000);
int j=1;
while(j<5)
{
driver.findElement(By.xpath("//span[@id='hrefIncChd']")).click();
j++;

}
driver.findElement(By.xpath("//input[@id='btnclosepaxoption'][1]")).click();
driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']")).click();
WebElement staticDropdown=driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
Thread.sleep(2000);
Select dropdown=new Select(staticDropdown);
dropdown.selectByIndex(3);
staticDropdown.click();
driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();










}

}
