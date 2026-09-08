package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Setup.SetUp;

public class ApplyLeaveTest extends SetUp
{
	@Test
    public void applyLeave() throws InterruptedException {
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("5Nx#I6BK%r3$8vz0ch");
        driver.findElement(By.id("btnLogin")).click();

        driver.findElement(By.id("menu_leave_viewLeaveModule")).click();
        driver.findElement(By.id("menu_leave_applyLeave")).click();
        Select leaveType = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
        leaveType.selectByVisibleText("Holiday");

        driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2026-03-10");
        driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2026-05-12");
        driver.findElement(By.id("applyleave_txtComment")).sendKeys("Personal");
        driver.findElement(By.id("applyBtn")).click();

        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
        WebElement heading =driver.findElement(By.xpath("//div[@class='head']/h1"));
        Assert.assertEquals(heading.getText(),"My Leave List","Failed to navigate to My Leave page");

        System.out.println("Leave application submitted successfully.");
    }
}