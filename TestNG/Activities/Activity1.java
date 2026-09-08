package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity1  {

	WebDriver driver;
	
  @BeforeTest
  public void setUp() {

      driver = new FirefoxDriver();
      driver.manage().window().maximize();
      driver.get("https://training-support.net");
  }
  
  @Test
  public void verifyTitle() {

      String title = driver.getTitle();
      System.out.println(title);
      Assert.assertEquals(title, "Training Support");
      driver.findElement(By.linkText("About Us")).click();
      String aboutTitle = driver.getTitle();
      System.out.println(aboutTitle);
      Assert.assertEquals(aboutTitle, "About Training Support");
  }
  
  @AfterTest
  public void tearDown() {
      driver.quit();
  }
}
