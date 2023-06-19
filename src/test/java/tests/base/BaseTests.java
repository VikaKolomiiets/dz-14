package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

public class BaseTests {
    private WebDriver driver;
    protected BasePage basePage;

    @BeforeClass
    public void setUpClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }
    @BeforeMethod
    public void setUpMethod(){
        driver.get("https://demoqa.com/");
        basePage = new BasePage(driver);
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @AfterClass
    public void tearDownClass(){
        driver.quit();
    }
}
