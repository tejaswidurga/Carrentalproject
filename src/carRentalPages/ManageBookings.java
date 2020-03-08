package carRentalPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageBookings {
	WebDriver driver;
	public ManageBookings(WebDriver driver){
		this.driver = driver;
	}
	//return bookingusers list
	public List<WebElement> returnNoOfBookings() {
		return driver.findElements(By.xpath("//table[@id='zctb']/tbody/tr"));
	}

}
