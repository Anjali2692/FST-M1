package appium_project;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
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
public void categoryTest() {

    driver.findElement(AppiumBy.accessibilityId("More options")).click();

    driver.findElement(AppiumBy.androidUIAutomator(
            "new UiSelector().text(\"Edit categories\")")).click();

    driver.findElement(AppiumBy.accessibilityId("New")).click();

    driver.findElement(By.id("text")).sendKeys("Office");

    driver.findElement(By.id("ok")).click();

    driver.navigate().back();

    WebElement secondTask =
            driver.findElements(By.id("taskText")).get(1);
    
    driver.longClickGesture(((RemoteWebElement) secondTask).getId());
    //driver.longClickGesture(((RemoteWebElement)secondTask).getId());

    driver.findElement(By.id("category")).click();

    driver.findElement(AppiumBy.androidUIAutomator(
            "new UiSelector().text(\"Office\")")).click();

    driver.findElement(By.id("ok")).click();

    driver.findElement(By.id("filter")).click();

    driver.findElement(AppiumBy.androidUIAutomator(
            "new UiSelector().text(\"Office\")")).click();

    List<WebElement> list =
            driver.findElements(By.id("taskText"));

    assertEquals(list.size(),1);
}
}
