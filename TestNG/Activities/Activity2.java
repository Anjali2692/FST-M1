package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
	WebDriver driver;

@BeforeClass
public void setUp() {
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.get("https://training-support.net/webelements/target-practice/");
}

@Test
public void verifyTitle() {
    String title = driver.getTitle();
    System.out.println("Page Title: " + title);
    Assert.assertEquals(title, "Selenium: Target Practice");
}

@Test
public void verifyBlackButton() {
    String buttonText = driver.findElement(By.cssSelector(".black")).getText();
    System.out.println("Black Button Text: " + buttonText);
    Assert.assertEquals(buttonText, "White");
}

@Test(enabled = false)
public void disabledTest() {
    System.out.println("This test is disabled.");
}

@Test
public void skippedTest() {
    throw new SkipException("Skipping this test intentionally.");
}

@AfterClass
public void tearDown() {
    driver.close();
}
}
