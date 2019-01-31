package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {

	public static AndroidDriver<AndroidElement> driver;
	public static DesiredCapabilities capabilities;

	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {

// TODO Auto-generated method stub

		File appDir;
		File app;
		capabilities = new DesiredCapabilities();
		Properties properties;
		String deviceos;
		String executeon;
		String browser;
		// String url;
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
		// url = properties.getProperty("URL");
		executeon = properties.getProperty("Executeon");

		System.out.println(deviceos + "||" + executeon + "||" + browser);

		if (deviceos.equalsIgnoreCase("Android")) {
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
			if (executeon.equalsIgnoreCase("browser")) {
				if (browser.equalsIgnoreCase("chrome")) {
					capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

				} else if (browser.equalsIgnoreCase("firefox")) {
					capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Firefox");

				} else {
					capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "IE");
				}

			} else {
				appDir = new File("src");
				app = new File(appDir, "ApiDemos-debug.apk");
				capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

			}
		}

		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		return driver;
	}

}

//Testcase
