package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ButtonsPage extends AbstractPage{

    private By buttons = By.xpath("//button[contains(@class, 'primary')]");
    private final String CLICK_ME_BUTTON = "Click Me";
    private By message = By.cssSelector("#dynamicClickMessage");

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public String getTestAfterClickOnButtonClickMe(){
        WebElement button = this.getElementFromElementsByText(buttons, CLICK_ME_BUTTON);
        button.click();
        return this.findElementVisibleWithFluentWait(message).getText();
    }

}
