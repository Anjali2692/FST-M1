package Setup;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SetUp {

	public WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://hrm.alchemy.hguy.co/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
