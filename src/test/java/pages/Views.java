package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Views {
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Expandable Lists']")
	private WebElement expandablelists;

	public Views(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public Views clickexpandablelists() {
		expandablelists.click();
		return this;
	}

}
