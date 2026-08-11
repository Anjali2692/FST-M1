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

public class Activity3_CompleteTasks {

    private AndroidDriver driver;
    private WebDriverWait wait;


    @BeforeClass
    public void setUp() throws MalformedURLException {

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
    public void completeFirstTwoTasks() {

        // --------------------------------
        // Mark Activity 1 complete
        // --------------------------------

        markTaskComplete("Complete Activity 1");


        // --------------------------------
        // Mark Activity 2 complete
        // --------------------------------

        markTaskComplete("Complete Activity 2");


        // --------------------------------
        // Toggle completed tasks
        // --------------------------------

        clickCompletedTaskToggle();


        // --------------------------------
        // Verify Activity 3 exists
        // --------------------------------

        Assert.assertTrue(
                isDisplayed("Complete Activity 3"),
                "Activity 3 should be displayed"
        );


        // --------------------------------
        // Verify Activity 1 is NOT displayed
        // --------------------------------

        Assert.assertFalse(
                isDisplayed("Complete Activity 1"),
                "Activity 1 should not be displayed"
        );


        // --------------------------------
        // Verify Activity 2 is NOT displayed
        // --------------------------------

        Assert.assertFalse(
                isDisplayed("Complete Activity 2"),
                "Activity 2 should not be displayed"
        );
    }


    private void markTaskComplete(String taskName) {

        WebElement task = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath(
                                "//*[@text='" + taskName + "']"
                        )
                )
        );

        task.click();
    }


    private void clickCompletedTaskToggle() {

        /*
         * Replace this locator with the actual
         * completed-task toggle from Appium Inspector.
         */

        driver.findElement(
                AppiumBy.accessibilityId(
                        "Toggle completed tasks"
                )
        ).click();
    }


    private boolean isDisplayed(String text) {

        return !driver.findElements(
                AppiumBy.xpath("//*[@text='" + text + "']")
        ).isEmpty();
    }


    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}