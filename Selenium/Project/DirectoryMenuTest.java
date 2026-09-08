package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Setup.SetUp;

public class DirectoryMenuTest extends SetUp
{
	@Test
    public void editUserInfo() throws InterruptedException {
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("5Nx#I6BK%r3$8vz0ch");
        driver.findElement(By.id("btnLogin")).click();
        
        WebElement directoryMenu = driver.findElement(By.id("menu_directory_viewDirectory"));

        Assert.assertTrue(directoryMenu.isDisplayed(),"Directory menu is not visible");

        Assert.assertTrue(directoryMenu.isEnabled(),"Directory menu is not clickable");

        directoryMenu.click();

        //String actualHeading = driver.findElement(By.cssSelector("#content > div.box.searchForm.toggableForm > a")).getText();
        //Assert.assertEquals(actualHeading,"Search Directory","Page heading does not match");

        WebElement heading = driver.findElement(By.tagName("h1"));
        System.out.println("Heading: " + heading.getText());
        Assert.assertEquals(heading.getText().trim(),"Search Directory");

        System.out.println("Directory menu verified successfully.");
    }
}
