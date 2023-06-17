package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ButtonsPage extends AbstractPage{

    private By clickMeButton = By.cssSelector("#yXuZR");
    private By message = By.cssSelector("#dynamicClickMessage");

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public String getTestAfterClickOnButtonClickMe(){
        this.findElementVisibleWithFluentWait(clickMeButton).click();
        return this.findElementVisibleWithFluentWait(message).getText();
    }


}
