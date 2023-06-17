import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage extends AbstractPage {
    private final String URL_Base_PAGE = "https://demoqa.com/";
    private By elementButton = By.xpath("//h5[contains(text(), 'Elements')]");

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public ElementsPage clickElementsForm(){
        this.getDriver().findElement(elementButton).click();
        return new ElementsPage(this.getDriver());
    }


}
