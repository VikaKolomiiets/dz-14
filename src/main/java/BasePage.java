import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    private WebDriver driver;
    private final String URL_Base_PAGE = "https://demoqa.com/";
    private By elementButton = By.xpath("//h5[contains(text(), 'Elements')]");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public ElementsPage clickElementsForm(){
        driver.findElement(elementButton).click();
        return new ElementsPage(driver);
    }


}
