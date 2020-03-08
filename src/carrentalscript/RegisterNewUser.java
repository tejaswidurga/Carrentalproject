package carrentalscript;


import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import carRentalPages.IndexPage;
import utilities.CommonFunctions;
import utilities.DatabaseConnection;
import utilities.GetExcelData;


public class RegisterNewUser {

	public static Logger log = LogManager.getLogger(RegisterNewUser.class.getName());
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\\\Teja\\\\Software\\\\Drivers\\\\chromedriver_ver80\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//Maximize Browser Window
		driver.manage().window().maximize();

		//Implicit Wait for 20 seconds
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//Creating Object for Index Page
		IndexPage indexPage = new IndexPage(driver);
		//Creating Object for GetExcelData to get Register User Data From Excel
		//GetExcelData regUserData = new GetExcelData();
		//Map<String, String> data = regUserData.getData("data/vehicledata.xlsx", "newuserdata");
		CommonFunctions cf = new CommonFunctions();
		
		//Create an object for Database Connection
		DatabaseConnection dc = new DatabaseConnection();
		
		//Open Car Rental Index Page
		driver.get("http://localhost/carrental/index.php");

		log.info("**************** Starting Regiser New User Test Case *****************");

		//Click on Login / Register button
		indexPage.loginRegisterButton().click();
		log.info("Clicked on Login / Register Button");
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(indexPage.signUpLink()));

		//Click on Sign Up Link
		indexPage.signUpLink().click();
		log.info("Clicked on Sign Up Link");

		//Enter Full Name
		//indexPage.fullName().sendKeys(data.get("fullname"));
		String fullName = cf.returnRandomString();
		System.out.println(fullName);
		//indexPage.fullName().click();
		//indexPage.fullName().sendKeys(fullName);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementsByName('fullname')[0].value = '"+fullName+"'");
		
		log.info("Entered Full Name in Full Name Text Box");
		
		Thread.sleep(15000);

		//Enter Mobile Name
		String mobileNo = cf.returnRandomNumber();
		System.out.println(mobileNo);
		indexPage.mobilenumber().sendKeys(mobileNo);
		log.info("Entered Mobile Number in Mobile Number Text Box");

		//Enter Email Address
		String emailAddress = cf.returnRandomString()+"@gmail.com";
		indexPage.emailaddress().sendKeys(emailAddress);
		log.info("Entered Email Address in Email Address Text Box");

		//Enter Password
		String password = cf.returnRandomString();
		indexPage.password().sendKeys(password);
		log.info("Entered Password in Password Text Box");

		//Enter Confirm Password
		indexPage.confirmpassword().sendKeys(password);
		log.info("Entered Password in Confirm Password Text Box");

		//Click on Sign UP Button
		indexPage.signUpButton().click();
		log.info("Clicked on Sign Up Button");

		//Verify the Alert Message
		String expectedAlertMessage = "Registration successfull. Now you can login";
		String actualAlertMessage = driver.switchTo().alert().getText();
		if(expectedAlertMessage.equalsIgnoreCase(actualAlertMessage)) {
			log.info("Successful Registration Alert Message is Verified Successfully");
		}
		else {
			log.error("Successful Registration Alert Message Can't be verified");
		}
		driver.switchTo().alert().dismiss();

		log.info("**************** Ending Regiser New User Test Case *****************");

		driver.close();

		Map<String, String> dbNewUserData = dc.getUserData(emailAddress);
		System.out.println(dbNewUserData.get("FullName"));
		System.out.println(dbNewUserData.get("ContactNo"));
		if(dbNewUserData.get("FullName").equalsIgnoreCase(fullName)) {
			System.out.println("Full Name is successfully loaded into database");
		}
		else {
			System.out.println("Full name is not successfully loaded into database");
		}
		
		if(dbNewUserData.get("ContactNo").equalsIgnoreCase(mobileNo)) {
			System.out.println("Contact Number is successfully loaded into database");
		}
		else {
			System.out.println("Contact Number is not successfully loaded into database");
		}
	}

}
