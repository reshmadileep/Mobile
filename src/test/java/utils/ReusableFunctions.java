package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ReusableFunctions {

	private WebDriver driver;
	private int waitime = 10;
	private WebDriverWait wdriver;

	public ReusableFunctions(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> findelements(By locator, int waittime) {
		wdriver = new WebDriverWait(driver, waittime);

		try {
			// TODO: Fix the below line
			wdriver.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
			return driver.findElements(locator);
		} catch (Exception e) {
			// System.out.println(elementname + " is not identified");
			return null;
		}
	}

	public List<WebElement> findelements(By locator) {
		return findelements(locator, waitime);
	}

	public void input(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public String gettext(WebElement element) {
		return element.getText();
	}

	public Boolean iselementselected(WebElement element) {
		try {
			element.isSelected();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void selectfromdropdownbyindex(WebElement element, int value) {
		Select dropdownlist = new Select(element);
		dropdownlist.selectByIndex(value);
	}

	public void selectfromdropdownbyvisibletext(WebElement element, String s) {

		Select dropdownlist = new Select(element);
		dropdownlist.selectByVisibleText(s);
	}

	public void scrolldown() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");
	}

	public void verifytext(WebElement element, String expectedvalue) {
		try {
			Assert.assertEquals(element.getText(), expectedvalue, "Page title is not a Match.");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/* Mobile Gestures */

}
