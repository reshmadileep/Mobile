package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Preference {

	@AndroidFindBy(id = "3. Preference dependencies")
	private WebElement preferencedependencies;

	public Preference(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public Preference clickpreferencedependencies() {
		preferencedependencies.click();
		return this;
	}

}
