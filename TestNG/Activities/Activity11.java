package Activities;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity11 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/webelements/simple-form");
    }

    public static List<List<String>> readExcel(String filePath) {

        List<List<String>> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook excelFile = new XSSFWorkbook(fis)) {

            Sheet sheet1 = excelFile.getSheetAt(0);

            for (Row rows : sheet1) {

                if (rows.getRowNum() == 0) {
                    continue;
                }

                List<String> rowData = new ArrayList<>();

                for (Cell cell : rows) {

                    switch (cell.getCellType()) {

                    case STRING:
                        rowData.add(cell.getStringCellValue().trim());
                        break;

                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            rowData.add(cell.getLocalDateTimeCellValue()
                                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                        } else {
                            rowData.add(String.valueOf((long) cell.getNumericCellValue()));
                        }
                        break;

                    default:
                        rowData.add("");
                    }
                }

                data.add(rowData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    @DataProvider(name = "excelDataProvider")
    public Object[][] inputData() {

        List<List<String>> inputData = readExcel("C://Users//NidhiDhande//Desktop//TestData.xlsx");

        Object[][] data = new Object[inputData.size()][4];

        for (int i = 0; i < inputData.size(); i++) {
            data[i] = inputData.get(i).toArray();
        }

        return data;
    }

    @Test(priority = 1)
    public void verifyPageTitle() {
        assertEquals(driver.getTitle(), "Selenium: Simple Form");
    }

    @Test(priority = 2, dataProvider = "excelDataProvider")
    public void registerTest(String fullName, String email, String date, String details) {

        driver.findElement(By.id("full-name")).sendKeys(fullName);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.name("event-date")).sendKeys(date);
        driver.findElement(By.id("additional-details")).sendKeys(details);

        // Click Submit
        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        String message = driver.findElement(By.id("action-confirmation")).getText();

        System.out.println("--------------------------------");
        System.out.println("Full Name : " + fullName);
        System.out.println("Email     : " + email);
        System.out.println("Date      : " + date);
        System.out.println("Details   : " + details);
        System.out.println("Confirmation Message : " + message);

        assertEquals(message, "Your event has been scheduled!");

        driver.navigate().refresh();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
