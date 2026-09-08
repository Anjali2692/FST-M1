package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Setup.SetUp;

public class HeaderImageUrlTest extends SetUp{
	@Test
    public void getHeaderImageURL() {

        // Locate the header image
//        WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));
        WebElement logo = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
        String imageURL = logo.getAttribute("src");
        System.out.println("Header Image URL:");
        System.out.println(imageURL);
    }
}
