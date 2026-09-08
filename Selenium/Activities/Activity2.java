package activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        try {
              driver.get("https://training-support.net/webelements/login-form/");
              System.out.println("Page Title: " + driver.getTitle());
              driver.findElement(By.id("username")).sendKeys("admin");
              driver.findElement(By.id("password")).sendKeys("password");
              driver.findElement(By.xpath("//button[text()='Log in']")).click();

        } finally {
            driver.quit();
        }
    }
}
