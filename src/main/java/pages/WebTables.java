package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebTables extends AbstractPage {

    private By addButton =  By.cssSelector("#addNewRecordButton");
    private By titleOfForm = By.cssSelector("#registration-form-modal");

    public WebTables(WebDriver driver) {
        super(driver);
    }

    public String clickOnAddButton(){
        this.findElementVisibleWithFluentWait(addButton).click();
        this.getDriver().switchTo().frame(1);
        return this.getDriver().findElement(titleOfForm).getText();
    }
    public String getTitleNameOfForm(){
        this.findElementVisibleWithFluentWait(addButton).click();
        this.getDriver().switchTo().frame(1);
        return this.getDriver().findElement(titleOfForm).getText();
    }

   


}
