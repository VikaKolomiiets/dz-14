package pageobject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.getPageSource();

    }


}
