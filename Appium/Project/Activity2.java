package appium.activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
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

public class Activity2_Category {

    private AndroidDriver driver;
    private WebDriverWait wait;

    private final String CATEGORY = "Work";


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
    public void createAndAssignCategory() {

        // --------------------------------
        // Open dropdown/menu
        // --------------------------------

        click("Menu");

        // --------------------------------
        // Select Edit categories
        // --------------------------------

        click("Edit categories");

        // --------------------------------
        // Add new category
        // --------------------------------

        click("New");

        WebElement categoryInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.className("android.widget.EditText")
                )
        );

        categoryInput.sendKeys(CATEGORY);

        click("OK");


        // --------------------------------
        // Long press Activity 2
        // --------------------------------

        WebElement task = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.xpath(
                                "//*[@text='Complete Activity 2']"
                        )
                )
        );

        longPress(task);


        // --------------------------------
        // Edit task
        // --------------------------------

        click("Edit");


        // --------------------------------
        // Select category
        // --------------------------------

        click(CATEGORY);

        click("OK");


        // --------------------------------
        // Open filter
        // --------------------------------

        click("Filter");

        click(CATEGORY);


        // --------------------------------
        // Verify Activity 2
        // --------------------------------

        Assert.assertTrue(
                isDisplayed("Complete Activity 2"),
                "Activity 2 was not found under category: " + CATEGORY
        );
    }


    private void longPress(WebElement element) {

        PointerInput finger =
                new PointerInput(
                        PointerInput.Kind.TOUCH,
                        "finger"
                );

        Sequence longPress =
                new Sequence(finger, 1);

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


    private void click(String text) {

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