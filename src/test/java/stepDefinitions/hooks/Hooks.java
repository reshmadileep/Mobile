package stepDefinitions.hooks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import stepDefinitions.World;

public class Hooks {
	private World world;
	private String testEnv = "dev";
	private Properties properties;
	private AppiumDriver<WebElement> driver;

	public Hooks(World world) {
		this.world = world;
		System.out.println("Value of TEST_ENV is " + System.getenv("TEST_ENV"));
		testEnv = (System.getenv("TEST_ENV") == null) ? testEnv : System.getenv("TEST_ENV");

	}

	@Before(order = 0)
	public void doSetupBeforeExecution() throws MalformedURLException {
		File appDir, app;
		String deviceos, executeon, browser, url;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		properties = new Properties();

		try {
			properties.load(new FileInputStream(new File("./src/test/resources/config/global.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		deviceos = properties.getProperty("DeviceOS");
		browser = properties.getProperty("Browser");
		url = properties.getProperty("URL");
		executeon = properties.getProperty("Executeon");

		if (executeon.equalsIgnoreCase("browser")) {
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

		} else {
			appDir = new File("src");
			app = new File(appDir, "ApiDemos-debug.apk");
			capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		}

		if (deviceos.equalsIgnoreCase("Android")) {
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
			// caps.setCapability("platformVersion", "6.0");
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} else {
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
			capabilities.setCapability("platformName", "iOS");
			// caps.setCapability("platformVersion", "6.0");
			driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		}

		HashMap<String, String> map = new HashMap<String, String>();
		for (Map.Entry<Object, Object> entry : properties.entrySet()) {
			map.put((String) entry.getKey(), (String) entry.getValue());
		}
		this.world.context.put("config", map);
		this.world.context.put("testEnv", testEnv.toLowerCase());
		world.context.put("driver", driver);
	}

	/*
	 * @After public void doCleanupAfterExecution(Scenario scenario) { if
	 * (scenario.isFailed()) { TakesScreenshot browser = (TakesScreenshot) new
	 * Augmenter().augment(driver); final byte[] screenshot =
	 * browser.getScreenshotAs(OutputType.BYTES); scenario.embed(screenshot,
	 * "image/png"); scenario.write("URL: " + driver.getCurrentUrl()); }
	 * driver.close(); }
	 */
}
