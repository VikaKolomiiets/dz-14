import com.github.dockerjava.core.WebTarget;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementsPage {
    private WebDriver driver;
    private final By buttons = By.xpath("//li[@id='item-3']");
    private final String NAME_WEB_TABLES ="Web Tables";

    public ElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebTables clickOnWebTablesButton(){
        this.getButtonFromListButtons(NAME_WEB_TABLES).click();
        return new WebTables(driver);
    }

    private WebElement getButtonFromListButtons(String name) {
        List<WebElement> elements = driver.findElements(buttons);
        WebElement button = null;
        for (WebElement element : elements) {
            if (element.getText().equals(name)) {
                button = element;
                break;
            }
        }
        return button;
    }

}
