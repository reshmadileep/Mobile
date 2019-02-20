package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.ReusableFunctions;

public class WebView {

	@AndroidFindBy(xpath = "//android.view.View")
	private WebElement text;

	private AppiumDriver<WebElement> driver;
	ReusableFunctions rfunctions;

	public WebView(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		rfunctions = new ReusableFunctions(driver);
	}

	public WebView verifytext() {
		System.out.println(text.getAttribute("text"));
		Assert.assertTrue(text.getAttribute("text").contains("Hello World!"));
		return this;
	}

}
