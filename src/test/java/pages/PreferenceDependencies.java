
package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PreferenceDependencies {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='3. Preference dependencies']")
	private WebElement preferencedependencies;

	@AndroidFindBy(id = "android:id/checkbox")
	private WebElement wificheckbox;

	@AndroidFindBy(xpath = "(//android.widget.RelativeLayout)[2]")
	private WebElement wifisetting;

	@AndroidFindBy(className = "//android.widget.EditText")
	private WebElement wifieditbox;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	private WebElement wifieditokbutton;

	public PreferenceDependencies(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public PreferenceDependencies clickwificheckbox() {
		wificheckbox.click();
		return this;
	}

	public PreferenceDependencies clickwifisetting() {
		wifisetting.click();
		return this;
	}

	public PreferenceDependencies enterwifisetting(String value) {
		wifieditbox.sendKeys(value);
		return this;
	}

	public PreferenceDependencies savewifisetting() {
		wifieditokbutton.click();
		return this;
	}

}
