package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public abstract class AbstractPage {
    private WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver getDriver() {
        return driver;
    }

    public WebElement findElementVisibleWithFluentWait(By by){
        FluentWait fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);

        fluentWait.until(ExpectedConditions.visibilityOf(this.driver.findElement(by)));
        return this.driver.findElement(by);
    }

    public List<WebElement> findElementsVisibleWithFluentWait(By by){
        FluentWait fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);

        fluentWait.until(ExpectedConditions.visibilityOf(this.driver.findElement(by)));
        List<WebElement> elements = this.driver.findElements(by);
        return elements;
    }

    public WebElement getElementFromElementsByText(By by, String text) {
        List<WebElement> elements = this.findElementsVisibleWithFluentWait(by);
        WebElement elementByTest = null;
        for (WebElement element : elements) {
            if (element.getText().equals(text)) {
                elementByTest = element;
                break;
            }
        }
        return elementByTest;
    }
 }
