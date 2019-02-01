package utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

	/*
	 * public WebElement findelement(By locator, int waittime) {
	 * 
	 * wdriver = new WebDriverWait(driver, waittime);
	 * 
	 * try { wdriver.until(ExpectedConditions.visibilityOfElementLocated(locator));
	 * return driver.findElement(locator); } catch (Exception e) { //
	 * System.out.println(elementname + " is not identified"); return null; }
	 * 
	 * }
	 */

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

	/*
	 * public WebElement findelement(By locator) { return findelement(locator,
	 * waitime); }
	 */

	public List<WebElement> findelements(By locator) {
		return findelements(locator, waitime);
	}

	/*
	 * public void click(By locator) { findelement(locator, waitime).click(); }
	 */

	/*
	 * public void click(By locator, int wait) { findelement(locator, wait).click();
	 * }
	 */

	public void input(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public String gettext(WebElement element) {
		return element.getText();
	}

	/*
	 * public Boolean iselementdisplayed(By locator) { try { findelement(locator);
	 * return true; } catch (Exception e) { return false; }
	 * 
	 * }
	 */

	/*
	 * public Boolean iselementenabled(By locator) { try {
	 * findelement(locator).isEnabled(); return true; } catch (Exception e) { return
	 * false; }
	 * 
	 * }
	 */

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

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
	}
	

	public void verifytext(WebElement element, String expectedvalue) {
		try {
			Assert.assertEquals(element.getText(), expectedvalue, "Page title is not a Match.");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void FileUpload() {

		// TODO Auto-generated method stub
		// String projectPath = System.getProperty("user.dir");
		// System.setProperty("webdriver.chrome.driver", projectPath +
		// "\\Driver\\ChromeDriver\\chromedriver.exe");
		String baseUrl = "http://demo.guru99.com/test/upload/";

		// WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// WebDriver driver = new ChromeDriver();
		driver.get(baseUrl);
		/*
		 * WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
		 * 
		 * // enter the file path onto the file-selection input field
		 * uploadElement.sendKeys("C://AB.png");
		 * 
		 * // check the "I accept the terms of service" check box
		 * driver.findElement(By.id("terms")).click();
		 * 
		 * // click the "UploadFile" button driver.findElement(By.name("send")).click();
		 */
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.close();
	}

}
