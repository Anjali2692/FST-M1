package appium.activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity1_CreateTasks {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setDeviceName("emulator-5554");
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        // Replace with your actual APK path
        options.setApp("C:\\Appium\\ToDo.apk");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void createThreeTasks() {

        // ==========================================
        // TASK 1 - High Priority
        // ==========================================

        clickByText("New");

        enterTask("Complete Activity 1");

        selectPriority("High");

        clickByText("Save");


        // ==========================================
        // TASK 2 - Medium Priority
        // ==========================================

        clickByText("New");

        enterTask("Complete Activity 2");

        selectPriority("Medium");

        clickByText("Save");


        // ==========================================
        // TASK 3 - Low Priority
        // ==========================================

        clickByText("New");

        enterTask("Complete Activity 3");

        selectPriority("Low");

        clickByText("Save");


        // ==========================================
        // ASSERTIONS
        // ==========================================

        Assert.assertTrue(
                isTaskDisplayed("Complete Activity 1"),
                "Complete Activity 1 was not added"
        );

        Assert.assertTrue(
                isTaskDisplayed("Complete Activity 2"),
                "Complete Activity 2 was not added"
        );

        Assert.assertTrue(
                isTaskDisplayed("Complete Activity 3"),
                "Complete Activity 3 was not added"
        );

        System.out.println("All three tasks were successfully added.");
    }


    /**
     * Enter task name.
     *
     * Replace the EditText locator with the
     * actual locator from Appium Inspector.
     */
    private void enterTask(String taskName) {

        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.className("android.widget.EditText")
                )
        );

        input.clear();
        input.sendKeys(taskName);
    }


    /**
     * Select priority.
     *
     * Update this method according to the actual
     * priority control in your application.
     */
    private void selectPriority(String priority) {

        // Example:
        // Click priority dropdown
        //
        // driver.findElement(
        //     AppiumBy.id("your.package:id/priority")
        // ).click();

        clickByText(priority);
    }


    private void clickByText(String text) {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//*[@text='" + text + "']")
                )
        );

        element.click();
    }


    private boolean isTaskDisplayed(String taskName) {

        return !driver.findElements(
                AppiumBy.xpath("//*[@text='" + taskName + "']")
        ).isEmpty();
    }


    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}