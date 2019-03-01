package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.ReusableFunctions;

public class APIDemo {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Preference']")
	public List<WebElement> preference;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Views']")
	public List<WebElement> views;

	ReusableFunctions rfunctions;

	public APIDemo(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		rfunctions = new ReusableFunctions(driver);

	}

	public APIDemo clickpreference() {
		while (preference.size() == 0) {
			rfunctions.scrollDownapp();
		}
		if (preference.size() > 0) {
			preference.get(0).click();
		}
		return this;
	}

	public APIDemo tapviews() {

		while (views.size() == 0) {
			rfunctions.scrollDownapp();
		}
		if (views.size() > 0) {
			views.get(0).click();
		}
		return this;
	}

}
