package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.ReusableFunctions;

public class APIDemo {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Preference']")
	public WebElement preference;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Views']")
	public WebElement views;

	ReusableFunctions rfunctions;

	public APIDemo(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		rfunctions = new ReusableFunctions(driver);
	}

	public APIDemo clickpreference() {
		preference.click();
		return this;
	}

	public APIDemo tapviews() {
		rfunctions.tapelement(views);
		return this;
	}

}
