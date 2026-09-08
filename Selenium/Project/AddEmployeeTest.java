package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import Setup.SetUp;

public class AddEmployeeTest extends SetUp{

	String firstName = "Nidhi123";
    String lastName = "D";
    @Test
    public void addEmployee() {

    	driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("5Nx#I6BK%r3$8vz0ch");
        driver.findElement(By.id("btnLogin")).click();

        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@id=\"btnAdd\"]")).click();

        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);

        String empId = driver.findElement(By.id("employeeId")).getAttribute("value");
        driver.findElement(By.id("btnSave")).click();

        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement empIdField = driver.findElement(By.id("empsearch_id"));
        empIdField.clear();
        empIdField.sendKeys(empId);

        driver.findElement(By.id("searchBtn")).click();
                
        WebElement row = driver.findElement(
                By.xpath("//table[@id='resultTable']/tbody/tr"));

        String rowText = row.getText();

        Assert.assertTrue(
                rowText.contains(firstName) &&
                rowText.contains(lastName),
                "Employee creation verification failed.");

        System.out.println("Employee created successfully.");
        
    }
}