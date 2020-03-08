package carRentalPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminLeftNavigation {
	
		WebDriver driver;
		public AdminLeftNavigation(WebDriver driver){
			this.driver = driver;
		}
		
		//return Dashboard:
		public WebElement Dashboard() {
			return driver.findElement(By.xpath("//a[@href='dashboard.php']"));
		}
		//return getusers:
		public WebElement RegUsers() {
			return driver.findElement(By.xpath("//a[@href='reg-users.php']"));
		}
		//return managebookings:
		public WebElement ManageBookings() {
			return driver.findElement(By.xpath("//a[@href='manage-bookings.php']"));
								
		}
		//return vehicle
		public WebElement vehicles() {
			return driver.findElement(By.xpath("(//div[@class='more'])[2]"));
		}
		//return post a vehical
		public WebElement postavehicle() {
			return driver.findElement(By.xpath("//a[@href='post-avehical.php']"));
		}

}
