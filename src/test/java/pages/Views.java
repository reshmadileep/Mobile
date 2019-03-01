package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.ReusableFunctions;

public class Views {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Expandable Lists']")
	private WebElement expandablelists;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='WebView']")
	private List<WebElement> webviews;

	private AppiumDriver<?> driver;
	ReusableFunctions rfunctions;

	public Views(AppiumDriver<?> driver2) {
		this.driver = driver2;
		PageFactory.initElements(new AppiumFieldDecorator(driver2), this);
		rfunctions = new ReusableFunctions(driver2);
	}

	public Views clickexpandablelists() {
		expandablelists.click();
		return this;
	}

	public Views clickWebView() {
		while (webviews.size() == 0) {
			rfunctions.scrollDownapp();
		}
		if (webviews.size() > 0) {
			webviews.get(0).click();
		}
		return this;
	}

}
