package appium.activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
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

        // Configure your Appium capabilities here
        // Replace with your actual device/app configuration

        // Example:
        /*
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setApp("/path/to/ToDo.apk");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );
        */

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void createThreeTasks() {

        // -----------------------------
        // Task 1
        // -----------------------------

        click("New");

        enterTask("Complete Activity 1");

        selectPriority("1");

        selectDueDate("Wednesday");

        click("OK");


        // -----------------------------
        // Task 2
        // -----------------------------

        click("New");

        enterTask("Complete Activity 2");

        selectPriority("2");

        selectDueDate("Wednesday");

        click("OK");


        // -----------------------------
        // Task 3
        // -----------------------------

        click("New");

        enterTask("Complete Activity 3");

        selectPriority("3");

        selectDueDate("Thursday");

        click("OK");


        // -----------------------------
        // Assertions
        // -----------------------------

        Assert.assertTrue(
                isTaskDisplayed("Complete Activity 1"),
                "Activity 1 was not added"
        );

        Assert.assertTrue(
                isTaskDisplayed("Complete Activity 2"),
                "Activity 2 was not added"
        );

        Assert.assertTrue(
                isTaskDisplayed("Complete Activity 3"),
                "Activity 3 was not added"
        );
    }


    private void click(String text) {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//*[@text='" + text + "']")
                )
        ).click();
    }


    private void enterTask(String task) {

        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.className("android.widget.EditText")
                )
        );

        input.clear();
        input.sendKeys(task);
    }


    private void selectPriority(String priority) {

        // Replace this locator with the actual priority element
        // from Appium Inspector.

        driver.findElement(
                AppiumBy.xpath("//*[@text='" + priority + "']")
        ).click();
    }


    private void selectDueDate(String day) {

        // Replace with actual date picker implementation
        // based on your application.

        driver.findElement(
                AppiumBy.xpath("//*[@text='" + day + "']")
        ).click();
    }


    private boolean isTaskDisplayed(String task) {

        return !driver.findElements(
                AppiumBy.xpath("//*[@text='" + task + "']")
        ).isEmpty();
    }


    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}