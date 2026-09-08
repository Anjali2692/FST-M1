package appium_project;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
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
    public void addTasks() {

        String[] task = {
                "Complete Activity 1",
                "Complete Activity 2",
                "Complete Activity 3"
        };

        for(int i=0;i<task.length;i++) {

            driver.findElement(AppiumBy.accessibilityId("New")).click();

            driver.findElement(By.id("text")).sendKeys(task[i]);

            driver.findElement(By.id("priority")).click();

            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\""+(i+1)+"\")")).click();

            driver.findElement(By.id("date")).click();

            if(i<2)
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiSelector().text(\"Wednesday\")")).click();
            else
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiSelector().text(\"Thursday\")")).click();

            driver.findElement(By.id("ok")).click();
        }

        List<WebElement> tasks =
                driver.findElements(By.id("taskText"));

        assertEquals(tasks.size(),3);
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}
