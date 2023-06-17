package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

public class BaseTests {
    private WebDriver driver;
    private BasePage basePage;

    @BeforeMethod
    public void setUpTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        basePage = new BasePage(driver);
    }

    @AfterTest
    public void tearDownTest(){
        driver.quit();
    }
}
