package QualityArc.Mobile;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.Base;

public class Browser extends Base {

//	public static void main(String[] args) throws MalformedURLException {
//// TODO Auto-generated method stub
//		AndroidDriver<AndroidElement> driver = capabilities();
//		driver.get("http://facebook.com");
//		driver.findElementByXPath("//*[@id='u_0_1']/div[1]/div/input").sendKeys("qwerty");
//		driver.findElementByName("pass").sendKeys("12345");
//		driver.findElementByXPath("//button[@value='Log In']").click();
//
//	}
//	

	@Test
	public void loginTest() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");
		driver.findElementByName("txtUsername").sendKeys("Admin");
		driver.findElementByName("txtPassword").sendKeys("admin123");
		driver.findElementById("btnLogin").click();

	}

}