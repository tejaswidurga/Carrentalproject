package carRentalPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminHeader {

	WebDriver driver;
	public AdminHeader(WebDriver driver){
		this.driver = driver;
	}

	//return account
	public WebElement account() {
		return driver.findElement(By.xpath("//li[@class='ts-account']"));
	}

	//return logout
	public WebElement logout() {
		return driver.findElement(By.xpath("//a[@href='logout.php']"));
	}

}
