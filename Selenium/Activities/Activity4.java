package activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {

	public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();


        driver.get("https://training-support.net/webelements/target-practice");
        System.out.println("Page Title: " + driver.getTitle());

        WebElement thirdHeader = driver.findElement(By.xpath("//h3[@class='text-3xl font-bold text-orange-600']"));
        System.out.println("3rd HeaderText: " + thirdHeader.getText());

        WebElement fifthHeader = driver.findElement(By.xpath("//h5[@class='text-3xl font-bold text-purple-600']"));
        System.out.println("5th HeaderText: " + fifthHeader.getText());
        String color = fifthHeader.getCssValue("color");
        System.out.println("5th Header Color: " + color);
        
        String purpleButtonClass  = driver.findElement(By.xpath("//button[text()='Purple']")).getDomAttribute("class");
        System.out.println(purpleButtonClass );
        
        String slateButtonText = driver.findElement(By.xpath("//button[contains(@class, 'slate')]")).getText();
        System.out.println(slateButtonText);
        
        //driver.quit();
    }
}
