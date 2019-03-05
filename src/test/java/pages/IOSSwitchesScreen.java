
package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class IOSSwitchesScreen {
	IOSDriver<?> driver;

	public IOSSwitchesScreen(AppiumDriver<?> driver) {
		this.driver = (IOSDriver<?>) driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@FindBy(xpath = "//XCUIElementTypeSwitch")
	public List<WebElement> tinted;
	
	public IOSSwitchesScreen toggletinted() {
		if(tinted.size()>0) {
		tinted.get(0).click();
		}
		return this;
	}


}
