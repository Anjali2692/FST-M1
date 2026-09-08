package appium_project;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity3 {
	AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Android Emulator");
        options.setApp("C:\\Apps\\ToDoList.apk");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"), options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

	
@Test
public void completeTasks() {

    List<WebElement> checkbox =
            driver.findElements(By.id("completed"));

    checkbox.get(0).click();
    checkbox.get(1).click();

    driver.findElement(AppiumBy.accessibilityId("Show completed")).click();

    List<WebElement> remaining =
            driver.findElements(By.id("taskText"));

    assertEquals(remaining.size(),1);
}
}
