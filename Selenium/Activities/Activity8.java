package activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity8 {

	public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/dynamic-controls");
        driver.manage().window().maximize();
        System.out.println("Page Title: " + driver.getTitle());
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        By checkboxLocator = By.id("checkbox");
        By toggleButton = By.xpath("//button[text()='Toggle Checkbox']");

        driver.findElement(toggleButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkboxLocator));
        System.out.println("Checkbox removed");
        driver.findElement(toggleButton).click();
        
        WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(checkboxLocator));
        System.out.println("Checkbox appeared");

        checkbox.click();
        System.out.println("Checkbox selected");
        driver.quit();      
    }
}
