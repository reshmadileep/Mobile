package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class IOSUICatalogScreen {
	
	IOSDriver<?> driver;
	public IOSUICatalogScreen(AppiumDriver<?> driver) {
		this.driver = (IOSDriver<?>) driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Alert Views']")
	public WebElement alertviews;
	
	public IOSUICatalogScreen clickalertviews() {
		alertviews.click();
		return this;
		
	}

}
