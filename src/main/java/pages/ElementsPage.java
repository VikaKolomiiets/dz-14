package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementsPage extends AbstractPage{

    private By firstGroupComponents = By.xpath("//li[@id='item-3']");
    private By secondGroupComponents = By.cssSelector("#item-4>.text");

    private final String TEXT_WEB_TABLES ="Web Tables";
    private final String TEXT_BUTTONS ="Buttons";

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public WebTablesPage clickOnWebTablesComponent(){
        WebElement button = this.getElementFromElementsByText(firstGroupComponents, TEXT_WEB_TABLES);
        button.click();
        return new WebTablesPage(this.getDriver());
    }
    public ButtonsPage clickOnButtonPageComponent(){
        WebElement button = this.getElementFromElementsByText(secondGroupComponents, TEXT_BUTTONS);
        button.click();
        return new ButtonsPage(this.getDriver());
    }


}
