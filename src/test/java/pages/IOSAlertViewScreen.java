package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class IOSAlertViewScreen {

	IOSDriver<?> driver;

	public IOSAlertViewScreen(AppiumDriver<?> driver) {
		this.driver = (IOSDriver<?>) driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@FindBy(xpath = "//*[@value = 'Text Entry']")
	public WebElement textentry;

	@FindBy(xpath = "//XCUIElementTypeOther")
	public WebElement shorttitle;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
	public WebElement btnok;

	public IOSAlertViewScreen clicktextentry() {
		textentry.click();
		return this;
	}

	public IOSAlertViewScreen entershorttitle(String shorttitlevalue) {
		shorttitle.click();
		shorttitle.sendKeys(shorttitlevalue);
		btnok.click();
		return this;
	}

	public IOSAlertViewScreen verifyshorttitle(String expectedshorttitlevalue) {
		Assert.assertFalse(shorttitle.isDisplayed(), "short title is not displayed.");
		return this;
	}

}
