package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Setup.SetUp;

public class AddingQualificationTest extends SetUp
{
	@Test
    public void addingqualification() throws InterruptedException {
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("5Nx#I6BK%r3$8vz0ch");
        driver.findElement(By.id("btnLogin")).click();
        
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();

        driver.findElement(By.xpath("//*[@id=\"sidenav\"]/li[9]/a")).click();
        driver.findElement(By.id("addWorkExperience")).click();
        driver.findElement(By.id("experience_employer")).sendKeys("New Technologies");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("Tester");
        driver.findElement(By.id("experience_from_date")).sendKeys("2020-01-01");
        driver.findElement(By.id("experience_to_date")).sendKeys("2026-01-01");
        driver.findElement(By.id("experience_comments")).sendKeys("Selenium Project");
        driver.findElement(By.id("btnWorkExpSave")).click();

        System.out.println("Work Experience added successfully.");
	}
}
