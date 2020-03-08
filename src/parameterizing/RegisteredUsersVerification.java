package parameterizing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import carRentalPages.AdminLeftNavigation;
import carRentalPages.AdmingLogin;
import carRentalPages.Dashboard;
import carRentalPages.RegisteredUsers;


public class RegisteredUsersVerification {
	public static Logger log = LogManager.getLogger(RegisteredUsersVerification.class.getName());
	@Parameters({"URL"})
	@Test
	public void adminpage() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Teja\\Software\\Drivers\\chromedriver_ver80\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//create object for admin login page
		AdmingLogin adminLogin = new AdmingLogin(driver);

		//create object fot admin left navigation
		AdminLeftNavigation adminleftnavigation=new AdminLeftNavigation(driver);

		//create object for Dashboard
		Dashboard dashboard=new Dashboard(driver);
		//create object for Registeredusers
		RegisteredUsers registeredUsers=new RegisteredUsers(driver);



		//Opening the URL
		driver.get("http://localhost/carrental/admin");

		/*************************************************************
		 ****************** Login To Admin Page **********************
		 *************************************************************/
		//$$$$$$$$$$$$$$ info starts$$$$$$$$$$$$$$$$$$$$$$$$$$$$//
		//enter username:
		adminLogin.username().sendKeys("admin");
		log.info("enter keys on on username");
		//enter password:
		adminLogin.password().sendKeys("Test@12345");
		log.info("enter password  on password");
		//enter login:
		adminLogin.login().click();
		log.info("Clicked on login");

		/*********************************************************************
		 ***************** Clikc on Dashboard on Left Navigation *************
		 *********************************************************************/

		//enter  Dashboard:
		adminleftnavigation.Dashboard().click();
		log.info("Clicked on leftnavigation Dashboard");

		/************************************************************************ 
		 ***************** Get the Number of Users from Dashboard ****************
		 ************************************************************************/
		//enter registered users:
		String noOfUsersFromDashboard = dashboard.registeredusers().getText();
		System.out.println(noOfUsersFromDashboard);
		log.info("print noofusers in dashboard");

		/************************************************************************
		 ****** Get the No. of Reistered users from Registered Users Page *******
		 ************************************************************************/

		//Click on Registered Users link on Left Navigation
		adminleftnavigation.RegUsers().click();	
		log.info("Clicked on regusers");

		//GEt the number of rows from Registered users table
		int noOfUsersFromRegisteredUsersPage = registeredUsers.returnRegUsers().size();

		if(Integer.parseInt(noOfUsersFromDashboard) == noOfUsersFromRegisteredUsersPage) {
			System.out.println("No. of Users from Dashboard and Registered Users Page are matching");
			log.info("Dashboard and Registered Users Pages are Matching");
		}
		else {
			System.out.println("No. of Users from Dashboard and Registered Users Page are NOT matching");
			log.info("Dashboard and Registered Users Pages are not Matching");
		}
	}
}




	

