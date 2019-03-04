package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSBy;

public class IOSAlertViewScreen {
	
	IOSDriver<?> driver;
	public IOSAlertViewScreen(AppiumDriver<?> driver) {
		this.driver = (IOSDriver<?>) driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSBy(xpath = "//*[@value = 'Text Entry']")
	public WebElement textentry;
	
	public IOSAlertViewScreen clicktextentry() {
		textentry.click();
		return this;
		
	}

}
