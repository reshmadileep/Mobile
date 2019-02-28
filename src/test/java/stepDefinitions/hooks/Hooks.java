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
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import stepDefinitions.World;

public class Hooks {
	private World world;
	private String testEnv = "dev";
	private Properties properties;
	private AppiumDriver<?> driver;
	DesiredCapabilities capabilities;
	HashMap<String, String> map;

	public Hooks(World world) {
		this.world = world;
		System.out.println("Value of TEST_ENV is " + System.getenv("TEST_ENV"));
		testEnv = (System.getenv("TEST_ENV") == null) ? testEnv : System.getenv("TEST_ENV");

	}

	@Before(order = 0)
	public void doSetupBeforeExecution() throws MalformedURLException {

		File appDir, app;
		capabilities = new DesiredCapabilities();
		properties = new Properties();
		String projectPath = System.getProperty("user.dir");

		try {
			properties.load(new FileInputStream(new File("./src/test/resources/config/global.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		map = new HashMap<String, String>();
		for (Map.Entry<Object, Object> entry : properties.entrySet()) {
			map.put((String) entry.getKey(), (String) entry.getValue());
		}

		world.context.put("config", map);

		capabilities.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);

		if (map.get("DeviceOS").equalsIgnoreCase("Android")) {
			capabilities.setCapability("platformName", "Android");
			if (map.get("Emulator").equalsIgnoreCase("NO")) {
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
			} else {
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
			}
			if (map.get("Executeon").equalsIgnoreCase("browser")) {
				capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
				capabilities.setCapability("chromedriverExecutable",
						projectPath + "\\src\\test\\resources\\drivers\\chromedriver.exe");
			} else {
				appDir = new File("src");
				app = new File(appDir, "ApiDemos-debug.apk");
				capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			}
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} else {
			capabilities.setCapability("platformName", "IOS");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone XR");
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);

			if (map.get("Emulator").equalsIgnoreCase("YES")) {
				capabilities.setCapability(MobileCapabilityType.UDID, map.get("IOSDeviceUDID"));
			}
			if (map.get("Executeon").equalsIgnoreCase("browser")) {
				capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
				capabilities.setCapability("safaridriverExecutable",
						projectPath + "\\src\\test\\resources\\drivers\\selenium-safari-driver-2.29.1.jar");
			} else {
				appDir = new File("src");
				app = new File(appDir, "UICatalog.app");
				capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			}
			driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		world.context.put("testEnv", testEnv.toLowerCase());
		world.context.put("driver", driver);
	}

	@After
	public void doCleanupAfterExecution(Scenario scenario) {
		if (map.get("DeviceOS").equalsIgnoreCase("Android")) {
			if (map.get("Executeon").equalsIgnoreCase("browser")) {
				driver = (AndroidDriver<WebElement>) driver;
			}
		}

		if (scenario.isFailed()) {
			TakesScreenshot screenshoti = (TakesScreenshot) new Augmenter().augment(driver);
			final byte[] screenshot = screenshoti.getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
			// scenario.write("URL: " + driver.getCurrentUrl());
		}
		if (map.get("DeviceOS").equalsIgnoreCase("Android")) {
			if (map.get("Executeon").equalsIgnoreCase("browser")) {
				driver.close();
			} else {
				driver.closeApp();
			}
		} else {
			driver.closeApp();
		}

	}

}
