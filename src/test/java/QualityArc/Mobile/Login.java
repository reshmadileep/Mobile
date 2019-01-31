package QualityArc.Mobile;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.HomePage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.Base;


public class Login extends Base {
	
	private AndroidDriver<AndroidElement> driver;
	private HomePage homePage;


	public Login() {
		
		System.out.println("Starting Test");

	}
		@Test
		public void loginTest() throws MalformedURLException {
			AndroidDriver<AndroidElement> driver = capabilities();
			driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");
			homePage = new HomePage(driver);
		    homePage.enterUsername("Admin");	
		    homePage.enterPassword("admin123");
		    homePage.clickLoginBtn();
	
	}
}