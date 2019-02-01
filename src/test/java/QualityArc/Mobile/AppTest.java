package QualityArc.Mobile;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AppTest {

	public AndroidDriver<AndroidElement> driver;

	public AppTest(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	@Test
	public void accessibility() throws MalformedURLException {

	}

}
