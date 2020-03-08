package carRentalPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import carrentalscript.RegisteredUsersVerification;

public class AdmingLogin {
	public static Logger log = LogManager.getLogger(AdmingLogin.class.getName());
	WebDriver driver;
	public AdmingLogin(WebDriver driver){
		this.driver = driver;
	}
	//return username:
	public WebElement username() {
		return driver.findElement(By.xpath("//input[@name='username']"));
	}
	//return password:
	public WebElement password() {
		return driver.findElement(By.xpath("//input[@name='password']"));
	}
	//return login:
	public  WebElement login() {
		return driver.findElement(By.xpath("//button[@name='login']"));
	}


	public void loginToAdmin() {
		username().sendKeys("admin");
		log.info("enter keys on on username");
		//enter password:
		password().sendKeys("Test@12345");
		log.info("enter password on password");
		//enter login:
		login().click();
		log.info("click on ");
	}
}











