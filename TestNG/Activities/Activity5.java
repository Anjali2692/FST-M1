package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
	    driver = new FirefoxDriver();
	    driver.manage().window().maximize();
	    driver.get("https://training-support.net/webelements/target-practice/");
	}

	@Test(groups = {"HeaderTests"})
	public void pageTitleTest() {
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        Assert.assertEquals(title,"Selenium: Target Practice");
    }
	
	@Test(groups = {"HeaderTests"})
    public void thirdHeaderTest() {
        WebElement thirdHeader = driver.findElement(By.xpath("//h3[contains(@class, 'orange')]"));
        System.out.println("Third Header: " + thirdHeader.getText());
        Assert.assertEquals(thirdHeader.getText(), "Heading #3");
    }
	
	@Test(groups = {"HeaderTests"})
    public void fifthHeaderColorTest() {
        WebElement fifthHeader = driver.findElement(By.cssSelector("h5.text-purple-600"));
        String color = fifthHeader.getCssValue("color");
        System.out.println("Fifth Header Color: " + color);
        Assert.assertEquals(color, "rgb(147, 51, 234)");
    }
	
	@Test(groups = {"ButtonTests"})
    public void emeraldButtonTest() {
        WebElement emeraldButton = driver.findElement(By.xpath("//button[contains(@class, 'emerald')]"));
        System.out.println("Emerald Button Text: " + emeraldButton.getText());
        Assert.assertEquals(emeraldButton.getText(), "Emerald");
    }
	
	@Test(groups = {"ButtonTests"})
    public void firstButtonThirdRowTest() {
        WebElement button = driver.findElement(
        		By.xpath("//button[contains(@class, 'purple')]"));
        String color = button.getCssValue("background-color");
        System.out.println("Button Color: " + color);
        Assert.assertEquals(color, "rgb(107, 33, 168)");
    }
	
	@AfterClass
	public void tearDown() {
	    driver.close();
	}
}
