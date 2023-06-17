package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementsPage extends AbstractPage{

    private final By components = By.xpath("//li[@id='item-3']");
    private final String NAME_WEB_TABLES ="Web Tables";

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public WebTables clickOnWebTablesButton(){
        this.getButtonFromButtons(NAME_WEB_TABLES).click();
        return new WebTables(this.getDriver());
    }

    private WebElement getButtonFromButtons(String text) {
        List<WebElement> elements = this.findElementsVisibleWithFluentWait(components);
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
