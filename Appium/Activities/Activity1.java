package Activity;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Activity1 {
		AppiumDriver driver;
		WebDriverWait wait;
		
		@BeforeClass
		public void setUp () throws MalformedURLException, URISyntaxException
		{
			File testApp = new File("src/test/resources/Calculator.apk");
			// Desired Capabilities
			UiAutomator2Options options = new UiAutomator2Options();   
			options.setPlatformName("android");
	        options.setAutomationName("UiAutomator2");
	        options.setApp(testApp.getAbsolutePath());
	        options.noReset();
	 
	        // Server Address
	        URL serverURL = new URI("http://localhost:4723").toURL();
	        
	        // Driver Initialization
	        driver = new AndroidDriver(serverURL, options);
	        
		}
		
		@BeforeMethod
		public void clearResult()
		{
			driver.findElement(AppiumBy.accessibilityId("clear")).click();
			
		}
		
		// Test method
	    @Test
	    public void addTest() {
	        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_7")).click();
	        driver.findElement(AppiumBy.accessibilityId("plus")).click();
	        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_3")).click();
	        driver.findElement(AppiumBy.accessibilityId("equals")).click();
	 
	        String result = driver.findElement(AppiumBy.id("result_final")).getText();
	        Assert.assertEquals(result, "10");
	    }
	    
	    
	 // Tear down method
	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
	    
	}
