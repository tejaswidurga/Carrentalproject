package carRentalPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisteredUsers {
	
		WebDriver driver;
		public RegisteredUsers(WebDriver driver){
			this.driver = driver;
		}
		//return registeredusers list
		public List<WebElement> returnRegUsers() {
			return driver.findElements(By.xpath("//table[@id='zctb']/tbody/tr"));
		}

}
