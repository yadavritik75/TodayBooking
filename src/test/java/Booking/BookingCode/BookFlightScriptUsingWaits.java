package Booking.BookingCode;

import java.io.IOException;

import org.testng.annotations.Test;

import ritikyadav.Testcomponents.BaseTest;
import ritikyadav.pageobjects.BookingTickets;

public class BookFlightScriptUsingWaits extends BaseTest {

@Test(groups="Regression")
public void TicketBooking() throws IOException, InterruptedException {
	BookingTickets book =launchApp();
	book.SubmitDetails();
	book.SelectPassengers();
	book.SelectCurrency();
	book.SearchFlight();
	System.out.println("Flight successfully booked");
}

@Test(dependsOnMethods="TicketBooking", groups="Regression For Error")

public void ErrorValidation() throws IOException, InterruptedException {
	BookingTickets book =launchApp();
	book.SubmitDetails();
	book.SelectPassengers();
	book.SelectCurrencyForError();
	book.SearchFlight();
}
}
