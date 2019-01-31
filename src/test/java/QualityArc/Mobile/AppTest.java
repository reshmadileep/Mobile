package QualityArc.Mobile;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.Base;

public class AppTest extends Base {

	public AndroidDriver<AndroidElement> driver;

	@Test
	public void accessibility() throws MalformedURLException {
		driver = capabilities();

	}

}
