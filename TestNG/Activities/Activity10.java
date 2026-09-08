package Activities;


import static org.testng.Assert.assertEquals;
import java.io.FileReader;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;

public class Activity10 {	WebDriver driver;
	WebDriverWait wait;
 
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
		driver.get("https://training-support.net/webelements/simple-form");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
 
	@DataProvider(name = "csvDataProvider")
	public static Object[][] readCsv() throws Exception {

	    List<Object[]> data = new java.util.ArrayList<>();
	    java.io.BufferedReader br =
	            new java.io.BufferedReader(new FileReader("src/test/resources/userData.csv"));

	    br.readLine();
	    String line;
	    while ((line = br.readLine()) != null) {
	        String[] values = line.split(",");
	        System.out.println(Arrays.toString(values));
	        data.add(values);
	    }

	    br.close();
	    return data.toArray(new Object[0][]);
	}
 
	@Test(dataProvider = "csvDataProvider")
	public void testForm(String fullName, String email, String date, String details) {
		driver.findElement(By.id("full-name")).sendKeys(fullName);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.name("event-date")).sendKeys(date);
		driver.findElement(By.id("additional-details")).sendKeys(details);
 
		System.out.println("--------------------------------");
		System.out.println("Full Name : " + fullName);
		System.out.println("Email     : " + email);
		System.out.println("Date      : " + date);
		System.out.println("Details   : " + details);

		String message = driver.findElement(By.id("action-confirmation")).getText();
		System.out.println("Confirmation Message: " + message);
		
		driver.navigate().refresh();
	}
 
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
 
}
