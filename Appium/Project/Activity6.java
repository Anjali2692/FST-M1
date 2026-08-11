package appium.activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class Activity3_CompleteTasks {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setDeviceName("emulator-5554");
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        // Replace with actual APK path
        options.setApp("C:\\Appium\\ToDo.apk");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }


    @Test
    public void completeTasksAndVerify() {

        // ==========================================
        // STEP 1 - Complete Activity 1
        // ==========================================

        markTaskComplete("Complete Activity 1");


        // ==========================================
        // STEP 2 - Complete Activity 2
        // ==========================================

        markTaskComplete("Complete Activity 2");


        // ==========================================
        // STEP 3 - Long press Activity 3
        // ==========================================

        WebElement thirdTask = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.xpath(
                                "//*[@text='Complete Activity 3']"
                        )
                )
        );

        longPress(thirdTask);


        // ==========================================
        // STEP 4 - Edit task
        // ==========================================

        clickByText("Edit");


        // ==========================================
        // STEP 5 - Set progress to 50%
        // ==========================================

        setProgressTo50Percent();


        // ==========================================
        // STEP 6 - Save
        // ==========================================

        clickByText("Save");


        // ==========================================
        // STEP 7 - Open options
        // ==========================================

        clickOptions();


        // ==========================================
        // STEP 8 - Select Completed tasks
        // ==========================================

        clickByText("Completed tasks");


        // ==========================================
        // STEP 9 - Verify exactly 2 tasks
        // ==========================================

        List<WebElement> completedTasks =
                driver.findElements(
                        AppiumBy.xpath(
                                "//android.widget.TextView[contains(@text,'Complete Activity')]"
                        )
                );

        Assert.assertEquals(
                completedTasks.size(),
                2,
                "Expected exactly 2 completed tasks"
        );

        System.out.println(
                "Assertion passed: exactly 2 completed tasks are displayed."
        );
    }


    /**
     * Mark a task as complete.
     *
     * Depending on the application, clicking the task,
     * checkbox, or completion icon may be required.
     */
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


    /**
     * Long press an element.
     */
    private void longPress(WebElement element) {

        PointerInput finger = new PointerInput(
                PointerInput.Kind.TOUCH,
                "finger"
        );

        Sequence sequence = new Sequence(finger, 1);

        sequence.addAction(
                finger.createPointerMove(
                        Duration.ZERO,
                        PointerInput.Origin.fromElement(element),
                        0,
                        0
                )
        );

        sequence.addAction(
                finger.createPointerDown(
                        PointerInput.MouseButton.LEFT.asArg()
                )
        );

        sequence.addAction(
                new org.openqa.selenium.interactions.Pause(
                        finger,
                        Duration.ofSeconds(2)
                )
        );

        sequence.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()
                )
        );

        driver.perform(
                Collections.singletonList(sequence)
        );
    }


    /**
     * Set progress bar to 50%.
     *
     * This uses the element's coordinates and moves
     * the slider to approximately the midpoint.
     *
     * Replace the locator with the actual ProgressBar/
     * SeekBar resource-id from Appium Inspector.
     */
    private void setProgressTo50Percent() {

        WebElement progressBar = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.className(
                                "android.widget.SeekBar"
                        )
                )
        );

        int startX = progressBar.getLocation().getX();
        int width = progressBar.getSize().getWidth();

        int centerX = startX + (width / 2);

        int centerY =
                progressBar.getLocation().getY()
                        + (progressBar.getSize().getHeight() / 2);

        PointerInput finger = new PointerInput(
                PointerInput.Kind.TOUCH,
                "finger"
        );

        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(
                finger.createPointerMove(
                        Duration.ZERO,
                        PointerInput.Origin.viewport(),
                        centerX,
                        centerY
                )
        );

        swipe.addAction(
                finger.createPointerDown(
                        PointerInput.MouseButton.LEFT.asArg()
                )
        );

        swipe.addAction(
                finger.createPointerMove(
                        Duration.ofMillis(500),
                        PointerInput.Origin.viewport(),
                        centerX,
                        centerY
                )
        );

        swipe.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()
                )
        );

        driver.perform(
                Collections.singletonList(swipe)
        );
    }


    private void clickOptions() {

        /*
         * Replace this with the actual resource-id
         * or accessibility ID from Appium Inspector.
         */

        driver.findElement(
                AppiumBy.accessibilityId("Options")
        ).click();
    }


    private void clickByText(String text) {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//*[@text='" + text + "']")
                )
        ).click();
    }


    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}