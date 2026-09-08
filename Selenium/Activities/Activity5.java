package activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity5 {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/dynamic-controls");
        System.out.println("Page Title: " + driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));                 
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();
        System.out.println("Checkbox is displayed: " + checkbox.isDisplayed());
        driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();
        System.out.println("Checkbox is displayed: " + checkbox.isDisplayed());
        driver.quit();
    }
}
