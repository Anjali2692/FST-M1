package activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        // Initialize WebDriver
        WebDriver driver = new FirefoxDriver();

        try {
            driver.get("https://training-support.net");
            System.out.println("Home Page Title: " + driver.getTitle());
            driver.findElement(By.linkText("About Us")).click();
            System.out.println("About Us Page Title: " + driver.getTitle());

        } finally {
            driver.quit();
        }
    }
}
