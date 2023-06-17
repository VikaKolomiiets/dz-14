package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage extends AbstractPage {
    private By elementButton = By.xpath("//h5[contains(text(), 'Elements')]");

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public ElementsPage clickElementsForm(){
        this.findElementVisibleWithFluentWait(elementButton).click();
        return new ElementsPage(this.getDriver());
    }


}
