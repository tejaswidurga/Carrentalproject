package carRentalPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dashboard {
	WebDriver driver;
	public Dashboard(WebDriver driver){
		this.driver = driver;
	}
	//return list of registered users:
	public WebElement registeredusers() {
		return driver.findElement(By.xpath("//div[text()='Reg Users']/preceding-sibling::div[1]" ));
	}
	//return list of bookings:
	public WebElement bookings() {
		return driver.findElement(By.xpath("//div[text()='Total Bookings']/preceding-sibling::div[1]" ));
	}
	
}
