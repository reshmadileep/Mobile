package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class APIDemo {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Preference']")
	public WebElement preference;

	public APIDemo(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public APIDemo clickpreference() {
		preference.click();
		return this;
	}

}
