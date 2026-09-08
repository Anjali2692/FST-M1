package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Setup.SetUp;

public class EditUserInformationTest extends SetUp
{
	@Test
    public void editUserInfo() throws InterruptedException {
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("5Nx#I6BK%r3$8vz0ch");
        driver.findElement(By.id("btnLogin")).click();
        
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
    	WebElement editBtn = driver.findElement(By.xpath("//input[@type='button' and @value='Edit']"));
    	editBtn.click();

        WebElement firstName = driver.findElement(By.id("personal_txtEmpFirstName"));
        firstName.clear();
        firstName.sendKeys("Nidhi");

        WebElement lastName = driver.findElement(By.id("personal_txtEmpLastName"));
        lastName.clear();
        lastName.sendKeys("Dh");

        driver.findElement(By.id("personal_optGender_2")).click();

        Select nationality = new Select(
                driver.findElement(By.id("personal_cmbNation")));
        nationality.selectByVisibleText("Indian");

        WebElement dob = driver.findElement(By.id("personal_DOB"));
        dob.clear();
        dob.sendKeys("1998-05-15");
        
        WebElement saveButton = driver.findElement(By.id("btnSave"));
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", saveButton);
        saveButton = driver.findElement(By.id("btnSave"));
        saveButton.click();
        System.out.println("User information updated successfully.");
    }
}