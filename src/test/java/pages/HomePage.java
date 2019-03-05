
package pages;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import stepDefinitions.World;

public class HomePage {

	@FindAll({ @FindBy(id = "txtUsername"), @FindBy(id = "credentials.j_username") })
	private WebElement txtUserName;

	@FindAll({ @FindBy(id = "txtPassword"), @FindBy(id = "credentials.j_password") })
	private WebElement txtPassword;

	@FindAll({ @FindBy(id = "btnLogin"), @FindBy(xpath = "//button[@class='btn btn-primary pull-right']") })
	private WebElement btnLogin;

	@FindBy(id = "dashboardTab")
	private WebElement dashboardTab;

	private AppiumDriver<?> driver;
	private World world;
	private HashMap<String, String> map;

	@SuppressWarnings("unchecked")
	public HomePage(World world) {
		this.world = world;
		driver = (AppiumDriver<?>) this.world.context.get("driver");
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		map = (HashMap<String, String>) world.context.get("config");
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

	public HomePage verifyLogin() {

		/*
		 * if (dashboardTab.isDisplayed()) System.out.println("Logged in Successfully");
		 * else System.out.println("Login Unsuccessful ");
		 */
		return this;

	}
}
