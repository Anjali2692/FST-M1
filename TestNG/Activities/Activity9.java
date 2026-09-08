package Activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {
    WebDriver driver;
 
    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        Reporter.log("Starting Test", true);
        driver.get("https://training-support.net/webelements/alerts");
        Reporter.log("Opened Browser |");
        Reporter.log("Page title is " + driver.getTitle() + " |");
    }
 
    @BeforeMethod
    public void beforeMethod() {
        Reporter.log("Test Case Setup started |",true);
        driver.switchTo().defaultContent();
    }
 
    @Test(priority = 1)
    public void simpleAlertTestCase() {
        Reporter.log("simpleAlertTestCase() started |",true);
        driver.findElement(By.id("simple")).click();
        Reporter.log("Simple Alert opened |",true);
        
 
        Alert simpleAlert = driver.switchTo().alert();
        Reporter.log("Switched foucs to alert |",true);
 
        String alertText = simpleAlert.getText();
        Reporter.log("Alert text is: " + alertText + " |",true);
 
        Assert.assertEquals("You've just triggered a simple alert!", alertText);
 
        simpleAlert.accept();
        Reporter.log("Alert closed",true);
 
        Reporter.log("Test case ended |",true);
    }
 
    @Test(priority = 2)
    public void confirmAlertTestCase() {
        Reporter.log("confirmAlertTestCase() started |",true);
        driver.findElement(By.id("confirmation")).click();
        Reporter.log("Confirm Alert opened |",true);
 
        Alert confirmAlert = driver.switchTo().alert();
        Reporter.log("Switched foucs to alert |",true);
 
        String alertText = confirmAlert.getText();
        Reporter.log("Alert text is: " + alertText + " |",true);
 
        Assert.assertEquals("You've just triggered a confirmation alert!", alertText);
 
        confirmAlert.accept();
        Reporter.log("Alert closed |",true);
 
        Reporter.log("Test case ended |",true);
    }
 
    @Test(priority = 3)
    public void promptAlertTestCase() {
        Reporter.log("promptAlertTestCase() started |",true);
        driver.findElement(By.id("prompt")).click();
        Reporter.log("Prompt Alert opened |",true);
 
        Alert promptAlert = driver.switchTo().alert();
        Reporter.log("Switched foucs to alert |",true);
 
        String alertText = promptAlert.getText();
        Reporter.log("Alert text is: " + alertText + " |",true);
 
        Assert.assertEquals("I'm a Prompt! Type something into me!", alertText);
        promptAlert.sendKeys("Awesome!");
        Reporter.log("Text entered in prompt alert |",true);
        promptAlert.accept();
        Reporter.log("Alert closed |",true);
 
        Reporter.log("Test case ended |",true);
    }
 
    @AfterClass
    public void tearDown() {
        Reporter.log("Ending Test |");
        driver.close();
    }
}
