package activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity9 {

	public static void main(String[] args) {
 
	        WebDriver driver = new FirefoxDriver();
            driver.get("https://training-support.net/webelements/dynamic-content");
	        driver.manage().window().maximize();
            System.out.println("Page Title: " + driver.getTitle());

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement clickButton = driver.findElement(By.xpath("//button[text()='Click me!']"));
	        clickButton.click();

            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"),"release"));
            String pageText = driver.findElement(By.tagName("body")).getText();
            System.out.println("Page Text contains 'release':");
            System.out.println(pageText);

            driver.quit();
	        
	    }
	}
