package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Setup.SetUp;

public class VerifyWebsiteTitleTest extends SetUp
{
	@Test
	public void verifyLogin(){
        
     	String actualTitle = driver.getTitle();
        System.out.println("Website Title: " + actualTitle);
        Assert.assertEquals(actualTitle, "OrangeHRM");
    }
}