package ritikyadav.pageobjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BookingTickets extends UtilityClass {
	WebDriver driver;

	public BookingTickets(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "ctl00_mainContent_ddl_originStation1_CTXTaction")
	WebElement source;

	@FindBy(xpath = "//a[@value='MAA']")
	WebElement From;

	@FindBy(xpath = "//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='BLR']")
	WebElement Destination;

	@FindBy(xpath = "(//a[text()='15'])[1]")
	WebElement ToDate;

	@FindBy(xpath = "//div[@id='divpaxinfo']")
	WebElement passengersDropdown;

	@FindBy(css = "#hrefIncAdt")
	WebElement SelectAdult;

	@FindBy(xpath = "//span[@id='hrefIncChd']")
	WebElement SelectChild;

	@FindBy(xpath = "//input[@id='btnclosepaxoption'][1]")
	WebElement OkButton;

	@FindBy(xpath = "//select[@id='ctl00_mainContent_DropDownListCurrency']")
	WebElement staticDropdown;

	@FindBy(xpath = "//input[@id='ctl00_mainContent_btn_FindFlights']")
	WebElement search;

	public void landingPage() {
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

	}

	public void SubmitDetails() throws InterruptedException {
		source.click();
		From.click();
		Destination.click();
		ToDate.click();
		Thread.sleep(1000);

	}

	public void SelectPassengers() throws InterruptedException {

//		ElementToBeClick(By.id("divpaxinfo")); // or whatever element you actually want to wait for
		Thread.sleep(1000);
		passengersDropdown.click();

		List<Integer> clicks = Arrays.asList(1, 2, 3, 4);
		// Click 4 times on element with id 'hrefIncAdt'
		clicks.stream().forEach(i -> SelectAdult.click());

		// Thread.sleep(2000);

		// Click 4 times on element with id 'hrefIncChd'
		clicks.stream().forEach(i -> SelectChild.click());
		OkButton.click();

	}

	public void SelectCurrency() {
		staticDropdown.click();

		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(3);

	}

	public void SelectCurrencyForError() {
		staticDropdown.click();

		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(5);

	}

	public void SearchFlight() {
		search.click();
	}

}
