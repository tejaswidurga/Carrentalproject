package carrentalscript;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import carRentalPages.AdminLeftNavigation;
import carRentalPages.AdmingLogin;
import carRentalPages.AdminHeader;
import carRentalPages.PostAVehicle;
import utilities.GetExcelData;

public class EnterVehicaldatafromExcel {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\\\Teja\\\\Software\\\\Drivers\\\\chromedriver_ver80\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//create object for admin login page
		AdmingLogin adminLogin = new AdmingLogin(driver);
		//create object fot admin left navigation
		AdminLeftNavigation adminleftnavigation=new AdminLeftNavigation(driver);
		//create object for post a vehicle
		PostAVehicle postavehicle=new PostAVehicle(driver);
		//create object for excel
		GetExcelData getExcelData=new GetExcelData();
		//create object for logout using drag
		AdminHeader adminHeader = new AdminHeader(driver);

		driver.get("http://localhost/carrental/admin/post-avehical.php");
		//calling method from admin method:
		adminLogin.loginToAdmin();

		//click on vehicle
		adminleftnavigation.vehicles().click();
		//click on post a vehicle
		adminleftnavigation.postavehicle().click();
		//enter data on vehicle title
		Map<String, String> Data = getExcelData.getData("data\\vehicledata.xlsx", "vehicledata");
		postavehicle.vehicletitle().sendKeys(Data.get("VehicleTitle"));
		//enter data on vehicleoverview
		postavehicle.vehicleoverview().sendKeys(Data.get("VehicleOverview"));
		//enter data on priceperday
		postavehicle.priceperday().sendKeys(Data.get("Priceperday"));
		//enter data on modelyear
		postavehicle.modelyear().sendKeys(Data.get("Modelyear"));
		//select brand type
		postavehicle.brand().click();
		//Select brand name
		postavehicle.brandName("BMW").click();
		//select fuel type
		postavehicle.fueltype().click();
		//Select fuel name
		postavehicle.fueltype("Diesel").click();
		//enter capacity
		postavehicle.seatingcapacity().sendKeys(Data.get("capacity"));
		//enter image1
		postavehicle.image1().sendKeys(Data.get("image1"));
		//enter image2
		postavehicle.image2().sendKeys(Data.get("image2"));
		//enter image3
		postavehicle.image3().sendKeys(Data.get("image3"));
		//enter image4
		postavehicle.image4().sendKeys(Data.get("image4"));
		//click on airconditioner
		if(Data.get("airconditioner").equalsIgnoreCase("N")){
			postavehicle.airconditioner().click();
		}
		//click on powerwindows
		if(Data.get("PowerWindows").equalsIgnoreCase("Y")) {
			postavehicle.powerwindows().click();
		}
		//click on centrallocking
		if(Data.get("CentralLocking").equalsIgnoreCase("Y")) {
			postavehicle.centrallocking().click();
		}
		//click on submit
		postavehicle.submit().click();
		
		//print vehicalsuccessully posted:
		System.out.println(postavehicle.vehiclesuccessfullyposted().getText());
		if(postavehicle.vehiclesuccessfullyposted().getText().trim().equalsIgnoreCase("SUCCESS:Vehicle posted successfully")) {
			System.out.println("Vehicle Successfully Posted");
		}
		else {
			System.out.println("Vehicle is not posted");
		}
		
		//Click on My Account
		adminHeader.account().click();
		
		WebDriverWait d=new WebDriverWait(driver,20);
		d.until(ExpectedConditions.elementToBeClickable(adminHeader.logout()));
		//click on logout
		adminHeader.logout().click();
		
	}
}
