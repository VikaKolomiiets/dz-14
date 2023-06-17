package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage extends AbstractPage {
    private By buttons = By.xpath("//div[@class='card-body']");
    private By buttons2 = By.cssSelector(".card-body");


    public BasePage(WebDriver driver) {
        super(driver);
    }

    public ElementsPage clickElementPageButton(){
        List<WebElement> elements = this.findElementsVisibleWithFluentWait(buttons2);
        WebElement temp = null;
        for(WebElement element: elements){
            if(element.getText().equals("Elements")){
               temp = element;
               break;
            }
        }
        temp.click();
        return new ElementsPage(this.getDriver());
    }


}
