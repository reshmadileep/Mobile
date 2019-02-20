package utils;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ReusableFunctions {

	private AppiumDriver<WebElement> driver;
	private TouchAction taction;

	public ReusableFunctions(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		taction = new TouchAction(driver);
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

	public void verifytext(WebElement element, String expectedvalue) {
		try {
			Assert.assertEquals(element.getText(), expectedvalue, "Page title is not a Match.");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/* Mobile Gestures */

	public void tapelement(WebElement welement) {
		taction.tap(tapOptions().withElement(element(welement))).perform();
	}

	public void longpress(WebElement welement) {
		taction.longPress(longPressOptions().withElement(element(welement)).withDuration(ofSeconds(2))).release()
				.perform();
	}

	public void swipe(WebElement first, WebElement second) {
		taction.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2)))
				.moveTo(element(second)).release().perform();
	}

	public void scrollDownapp() {
		Dimension size = driver.manage().window().getSize();

		Double scrollheightstart = size.getHeight() * 0.5;
		int scrollstart = scrollheightstart.intValue();

		Double scrollheightend = size.getHeight() * 0.2;
		int scrollend = scrollheightend.intValue();

		new TouchAction((PerformsTouchActions) driver).press(PointOption.point(0, scrollstart))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(0, scrollend))
				.release().perform();
	}

	public void draganddrop(WebElement source, WebElement destination) {
		taction.longPress(element(source)).moveTo(element(destination)).release().perform();
	}

	public void clickmobilebackbutton() {
		((AndroidDriver<WebElement>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
	}

	public void scrollDownBrowser() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0.480)", "");

	}

}
