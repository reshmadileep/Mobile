package pages;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.ReusableFunctions;


public class IOSUICatalogScreen {
	
	IOSDriver<?> driver;
	ReusableFunctions rfunctions;
	public IOSUICatalogScreen(AppiumDriver<?> driver) {
		this.driver = (IOSDriver<?>) driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		rfunctions = new ReusableFunctions(driver);
	}
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Alert Views']")
	public WebElement alertviews;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Switches']")
	private List<WebElement> switches;
	
	public IOSUICatalogScreen clickalertviews() {
		alertviews.click();
		return this;
		
	}
	
	public IOSUICatalogScreen clickswitches() {
	
		for (int i=0;switches.size() == 0;i++) {
			rfunctions.scrollDownapp();
			if(i==7) {
				break;
			}
		}
		if (switches.size() > 0) {
			switches.get(0).click();
		}
		return this;
	}

}
