package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Setup.SetUp;

public class EmergencyContactTest extends SetUp{
	
	@Test
    public void getEmergencyContacts() {
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("5Nx#I6BK%r3$8vz0ch");
        driver.findElement(By.id("btnLogin")).click();
        
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        
        driver.findElement(By.linkText("Emergency Contacts")).click();

        List<WebElement> rows = driver.findElements(
                By.xpath("//table[@id='emgcontact_list']/tbody/tr"));

        System.out.println("===== Emergency Contacts =====");

        for (WebElement row : rows) {

            List<WebElement> cols =
                    row.findElements(By.tagName("td"));

            for (WebElement col : cols) {
                System.out.print(col.getText() + " | ");
            }

            System.out.println();
        }
           
        
	}

}
