package carRentalPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PostAVehicle {
	WebDriver driver;
	public PostAVehicle(WebDriver driver){
		this.driver = driver;
	}
	//return vehicletitle:
	public WebElement vehicletitle() {
		return driver.findElement(By.xpath("//input[@name='vehicletitle']"));
	}
	//return vehicleoverview:
	public WebElement vehicleoverview() {
		return driver.findElement(By.xpath("//textarea[@name='vehicalorcview']"));
	}
	//return priceperday:
	public WebElement priceperday() {
		return driver.findElement(By.xpath("//input[@name='priceperday']"));
	}
	//return modelyear:
	public WebElement modelyear() {
		return driver.findElement(By.xpath("//input[@name='modelyear']"));
	}
	//return brand dropdown element
	public WebElement brand() {
		return driver.findElement(By.xpath("//select[@name='brandname']/parent::div[1]"));
	}
	//return brand name
	public WebElement brandName(String name) {
		return driver.findElement(By.xpath("//span[text()='"+name+"']"));
	}

	//return fueldropdownelement:
	public WebElement fueltype() {
		return driver.findElement(By.xpath("//select[@name='fueltype']/parent::div[1]"));
	}
	//return fuel type:
	public WebElement fueltype(String type) {
		return driver.findElement(By.xpath("//span[text()='"+type+"']"));
	}

	//return capacity:
	public WebElement seatingcapacity() {
		return driver.findElement(By.xpath("//input[@name='seatingcapacity']"));
	}
	//return image1
	public WebElement image1() {
		return driver.findElement(By.xpath("//input[@name='img1']"));
	}
	//return image2:
	public WebElement image2() {
		return driver.findElement(By.xpath("//input[@name='img2']"));
	}
	//return image3:
	public WebElement image3() {
		return driver.findElement(By.xpath("//input[@name='img3']"));
	}
	//return image4:

	public WebElement image4() {
		return driver.findElement(By.xpath("//input[@name='img4']"));
	}
	//return image5:
	public WebElement image5() {
		return driver.findElement(By.xpath("//input[@name='img5']"));
	}
	//return airconditioner:
	public WebElement airconditioner() {
		return driver.findElement(By.xpath("//input[@id='airconditioner']"));
	}

	//return powerwindows:
	public WebElement powerwindows() {
		return driver.findElement(By.xpath("//input[@id='powerwindow']"));
	}
	//return powerlocking:
	public WebElement centrallocking() {
		return driver.findElement(By.xpath("//input[@id='centrallocking']"));
	}
	//click submit:
	public WebElement submit() {
		return driver.findElement(By.xpath("//button[@name='submit']"));
	}
	//verify successfullyposted:
	public WebElement vehiclesuccessfullyposted() {
		return driver.findElement(By.xpath("//div[@class='succWrap']"));

	}

}
