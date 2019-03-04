package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.ReusableFunctions;

public class WebView {

	@AndroidFindBy(xpath = "//android.view.View")
	private WebElement text;

	private AppiumDriver<?> driver;
	ReusableFunctions rfunctions;

	public WebView(AppiumDriver<?> driver2) {
		this.driver = driver2;
		PageFactory.initElements(new AppiumFieldDecorator(driver2), this);
		rfunctions = new ReusableFunctions(driver2);
	}

	public WebView verifytext() {
		System.out.println(text.getAttribute("text"));
		// Assert.assertTrue(text.getAttribute("text").contains("Hello World!"));
		return this;
	}

}
