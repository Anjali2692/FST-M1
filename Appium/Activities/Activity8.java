package Activity;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity8 {
	public static void main(String[] args) throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Android Emulator");
        options.setApp("C:\\Apps\\ToDoList.apk"); // Change app path

        AndroidDriver driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"), options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Locate an element
        WebElement element = driver.findElement(By.id("com.example:id/item"));

        // 1. Tap
        element.click();

        // 2. Long Press
        driver.longClickGesture(((RemoteWebElement) element).getId());

        // 3. Drag
        driver.dragGesture(
                ((RemoteWebElement) element).getId(),
                500,
                800);

        // 4. Scroll to text
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Settings\"));"));

        driver.quit();
    }
}
