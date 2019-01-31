package stepDefinitions;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.Base;

public class Hooks extends Base{
	  private World world;
	    private String testEnv = "dev";


	    		public Hooks(World world) {
	        this.world = world;
	        System.out.println("Value of TEST_ENV is " + System.getenv("TEST_ENV"));
	        testEnv = (System.getenv("TEST_ENV") == null) ? testEnv : System.getenv("TEST_ENV");

	    }
	    @Before(order=0)
	    public void doSetupBeforeExecution() throws MalformedURLException {
	    	
	        Properties properties;
	        properties = new Properties();
		    AndroidDriver<AndroidElement> driver = capabilities();
	   		
	    	 HashMap<String, String> map= new HashMap<String, String>();
	         for (Map.Entry<Object, Object> entry : properties.entrySet()) {
	             map.put((String) entry.getKey(), (String) entry.getValue());
	         }
	         this.world.context.put("config", map);
	         this.world.context.put("testEnv", testEnv.toLowerCase());
	         world.context.put("driver", driver);
}
}

