package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import Setup.SetUp;

public class LoginTest extends SetUp{
	@Test
    public void loginTest() {
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("5Nx#I6BK%r3$8vz0ch");
        driver.findElement(By.id("btnLogin")).click();
        String expectedUrl = "https://hrm.alchemy.hguy.co/symfony/web/index.php/dashboard";
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),
                "Login failed or Dashboard page not opened.");
        System.out.println("Login Successful. Dashboard opened.");
    }
    
}
