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


public class Activity4 {
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
	public void todoList() {

	    driver.get("https://training-support.net/webelements");

	    driver.findElement(AppiumBy.androidUIAutomator(
	            "new UiScrollable(new UiSelector().scrollable(true))"
	            + ".scrollTextIntoView(\"To-Do List\")"));

	    driver.findElement(AppiumBy.androidUIAutomator(
	            "new UiSelector().text(\"To-Do List\")")).click();

	    WebElement input =
	            driver.findElement(By.id("todo-input"));

	    input.sendKeys("Add tasks to list");
	    driver.findElement(By.id("todo-add")).click();

	    input.sendKeys("Get number of tasks");
	    driver.findElement(By.id("todo-add")).click();

	    input.sendKeys("Clear the list");
	    driver.findElement(By.id("todo-add")).click();

	    List<WebElement> tasks =
	            driver.findElements(By.xpath("//li"));

	    tasks.get(2).click();
	    tasks.get(3).click();
	    tasks.get(4).click();

	    assertEquals(tasks.size(),5);
	}
}
