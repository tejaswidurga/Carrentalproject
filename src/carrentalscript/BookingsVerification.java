package carrentalscript;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import carRentalPages.AdminLeftNavigation;
import carRentalPages.AdmingLogin;
import carRentalPages.Dashboard;
import carRentalPages.ManageBookings;

public class BookingsVerification {
	public static Logger log = LogManager.getLogger(BookingsVerification.class.getName());
	@Test(groups={"smoke"})
	public   void bookingsverifications()  throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Teja\\Software\\Drivers\\chromedriver_ver80\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//create object for admin login page
		AdmingLogin adminLogin = new AdmingLogin(driver);
		//create object fot admin left navigation
		AdminLeftNavigation adminleftnavigation=new AdminLeftNavigation(driver);
		//create object for Dashboard
		Dashboard dashboard=new Dashboard(driver);
		//create object for bookingusers
		ManageBookings bookingusers=new ManageBookings(driver);


		//Opening the URL
		driver.get("http://localhost/carrental/admin");
        //calling method from admingmethod:
		adminLogin.loginToAdmin();
         
		//enter  Dashboard:
		adminleftnavigation.Dashboard().click();
		log.info("click on dashboard on left navigation page");

		//enter booking users:
		String noOfBookingsFromDashboard = dashboard.bookings().getText();
		System.out.println(noOfBookingsFromDashboard);
		log.info("print noofbookings from dashboard");

		//Click on ManageBookings link on Left Navigation
		adminleftnavigation.ManageBookings().click();
		log.info("click on managebookings");

		//GEt the number of rows from bookings users table
		int noOfBookingsFromManageBookingsPage = bookingusers.returnNoOfBookings().size();

		if(Integer.parseInt(noOfBookingsFromDashboard) == noOfBookingsFromManageBookingsPage) {
			System.out.println("No. of Bookings from Dashboard and Manage Bookings Page are matching");
			log.info("noof bookings from dashboard is matching");
		}
		else {
			System.out.println("No. of Bookings from Dashboard and Manage Bookings Page are NOT matching");
			log.info("noof bookings from dashboard is not matching");
		}





	}
}
