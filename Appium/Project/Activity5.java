package appium_project;

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

import static org.testng.Assert.assertEquals;

public class Activity5 {
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
    public void validLogin() {

        driver.get("https://training-support.net/webelements");

        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                + ".scrollTextIntoView(\"Login Form\")"));

        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Login Form\")")).click();

        driver.findElement(By.id("username"))
                .sendKeys("admin");

        driver.findElement(By.id("password"))
                .sendKeys("password");

        driver.findElement(By.id("submit")).click();

        String msg =
                driver.findElement(By.id("action-confirmation"))
                        .getText();

        assertEquals(msg,
                "Welcome Back, admin");
    }
}
