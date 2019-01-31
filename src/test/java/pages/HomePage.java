
package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.Base;

import javax.swing.*;

public class HomePage {

    @FindBy(id = "txtUsername")
    private WebElement txtUserName;

    @FindBy(id = "txtPassword")
    private WebElement txtPassword;

    @FindBy(id = "btnLogin")
    private WebElement btnLogin;
    private AndroidDriver<AndroidElement> driver;

    public HomePage(AndroidDriver<AndroidElement> driver) {
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

	public HomePage loginWithDefaultCredentials(){
        verifyTitle()
                .enterUsername("Admin")
                .enterPassword("admin123")
                .clickLoginBtn();
        return this;
    }

}
