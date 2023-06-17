import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebTables extends AbstractPage {

    private By addButton =  By.cssSelector("#addNewRecordButton");

    public WebTables(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddButton(){
        this.findElementVisibleWithFluentWait(addButton).click();
        this.getDriver().switchTo().frame(1);
    }


}
