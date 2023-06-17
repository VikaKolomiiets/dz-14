package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractPageObject {

    private WebDriver driver;

    public AbstractPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getWebElement(By by){
        return new WebDriverWait(this.driver, Duration.ofSeconds(25) )
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
