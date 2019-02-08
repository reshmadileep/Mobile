
package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;

public class HomePage {

	@FindBy(id = "txtUsername")
	private AndroidElement txtUserName;

	@FindBy(id = "txtPassword")
	private AndroidElement txtPassword;

	@FindBy(id = "btnLogin")
	private WebElement btnLogin;
	private AppiumDriver<WebElement> driver;

	public HomePage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage enterUsername(String username) {
		txtUserName.clear();
		txtUserName.sendKeys(username);
		return this;
	}

	public HomePage enterPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);
		return this;
	}

	public HomePage clickLoginBtn() {
		btnLogin.click();
		return this;
	}

	public HomePage verifyTitle() {
		if (driver.getTitle().equals("OrangeHRM")) {
			System.out.println("Home page is launched successfully");
		} else {
			System.out.println("Home page is not launched");
		}
		return this;
	}

	public HomePage loginWithDefaultCredentials() {
		verifyTitle().enterUsername("Admin").enterPassword("admin123").clickLoginBtn();
		return this;
	}

}
