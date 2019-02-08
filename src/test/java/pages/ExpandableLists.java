package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ExpandableLists {
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='1. Custom Adapter']")
	private WebElement customadaptor;

	public ExpandableLists(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public ExpandableLists clickcustomadaptor() {
		customadaptor.click();
		return this;
	}
}
