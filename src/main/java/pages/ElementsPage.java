package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementsPage extends AbstractPage{

    private By firstGroupComponents = By.xpath("//li[@id='item-3']");
    private By secondGroupComponents = By.cssSelector("#item-4>.text");
    //private By buttonsComponent = By.xpath("(//li[@id='item-4']//span[@class= 'text'])[1]");
    private final String TEXT_WEB_TABLES ="Web Tables";
    private final String TEXT_BUTTONS ="Buttons";

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public WebTables clickOnWebTablesComponent(){
        this.getButtonFromButtons(firstGroupComponents, TEXT_WEB_TABLES).click();
        return new WebTables(this.getDriver());
    }
    public ButtonsPage clickOnButtonPageComponent(){
        this.getButtonFromButtons(secondGroupComponents, TEXT_BUTTONS).click();
        return new ButtonsPage(this.getDriver());
    }

    private WebElement getButtonFromButtons(By by, String text) {
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
