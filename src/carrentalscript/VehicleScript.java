package carrentalscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import carRentalPages.AdmingLogin;

public class VehicleScript {
	public static  void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Teja\\Software\\Drivers\\chromedriver_ver80\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//create object:
		AdmingLogin pomexample1=new AdmingLogin(driver);
		
		//start the URL
		driver.get("http://localhost/carrental/admin");
		//enter username:
		pomexample1.username().sendKeys("admin");
		//enter password:
		pomexample1.password().sendKeys("Test@12345");
		//enter login:
		pomexample1.login().click();


	}

	
	}

