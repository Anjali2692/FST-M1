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

public class Activity2_SetDeadline {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setDeviceName("emulator-5554");
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        // Replace with actual APK location
        options.setApp("C:\\Appium\\ToDo.apk");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }


    @Test
    public void setDeadlineForFirstTask() {

        // ==========================================
        // Find first task
        // ==========================================

        WebElement firstTask = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.xpath(
                                "//*[@text='Complete Activity 1']"
                        )
                )
        );


        // ==========================================
        // Long press first task
        // ==========================================

        longPress(firstTask);


        // ==========================================
        // Open/Edit task details
        // ==========================================

        clickByText("Edit");


        // ==========================================
        // Open deadline/date picker
        // ==========================================

        /*
         * Replace this locator with the actual
         * Deadline/Date element from Appium Inspector.
         */

        clickByText("Deadline");


        // ==========================================
        // Select next Saturday
        // ==========================================

        selectNextSaturday();


        // ==========================================
        // Save edited task
        // ==========================================

        clickByText("Save");


        // ==========================================
        // ASSERTION
        // ==========================================

        /*
         * Replace "Saturday" with the exact date text
         * displayed by your application's UI if required.
         */

        Assert.assertTrue(
                isDisplayed("Saturday"),
                "Deadline was not set to Saturday"
        );

        System.out.println(
                "Deadline successfully set for the first task."
        );
    }


    /**
     * Performs a long press on an element.
     */
    private void longPress(WebElement element) {

        PointerInput finger = new PointerInput(
                PointerInput.Kind.TOUCH,
                "finger"
        );

        Sequence longPress = new Sequence(finger, 1);

        longPress.addAction(
                finger.createPointerMove(
                        Duration.ZERO,
                        PointerInput.Origin.fromElement(element),
                        0,
                        0
                )
        );

        longPress.addAction(
                finger.createPointerDown(
                        PointerInput.MouseButton.LEFT.asArg()
                )
        );

        longPress.addAction(
                new org.openqa.selenium.interactions.Pause(
                        finger,
                        Duration.ofSeconds(2)
                )
        );

        longPress.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()
                )
        );

        driver.perform(
                Collections.singletonList(longPress)
        );
    }


    /**
     * Select next Saturday from date picker.
     *
     * The exact implementation depends on the
     * date picker used by the APK.
     */
    private void selectNextSaturday() {

        /*
         * Example approach:
         *
         * 1. Click next-month arrow if necessary.
         * 2. Locate Saturday.
         * 3. Click Saturday.
         *
         * Replace these locators based on
         * Appium Inspector.
         */

        WebElement saturday = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath(
                                "//*[@text='Saturday']"
                        )
                )
        );

        saturday.click();
    }


    private void clickByText(String text) {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//*[@text='" + text + "']")
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