package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.ReusableFunctions;

public class CustomAdapter {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='People Names']")
	private WebElement peoplenames;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Sample menu']")
	private WebElement samplemenu;

	ReusableFunctions rfunctions;

	public CustomAdapter(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		rfunctions = new ReusableFunctions(driver);
	}

	public CustomAdapter longpresspeoplenames() {
		rfunctions.longpress(peoplenames);
		return this;
	}

	public CustomAdapter verifysamplemenu() {
		System.out.println("verify the sample menu");
		return this;
	}
}
