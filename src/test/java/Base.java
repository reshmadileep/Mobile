
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {
	public static AndroidDriver<AndroidElement> driver;
	public static DesiredCapabilities capabilities;

	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {

// TODO Auto-generated method stub
		/*
		 * File appDir = new File("src"); File app = new File(appDir,
		 * "ApiDemos-debug.apk");
		 */
		capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");

		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

		// capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		return driver;
	}

}

//Testcase
