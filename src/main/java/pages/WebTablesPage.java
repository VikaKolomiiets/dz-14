package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTablesPage extends AbstractPage {

    private By addButton =  By.cssSelector("#addNewRecordButton");
    private By titleOfForm = By.cssSelector("#registration-form-modal");
    private By firstNameBy = By.id("firstName");
    private By lastNameBy = By.id("lastName");
    private By userEmailBy = By.id("userEmail");
    private By ageBy = By.id("age");
    private By salaryBy = By.id("salary");
    private By departmentBy = By.id("department");
    private By submitButton = By.cssSelector("#submit");

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }


    public String getTitleNameOfTheRegistrationForm(){
        this.clickOnAddButton();
        WebElement title = this.findElementVisibleWithFluentWait(titleOfForm);
        return title.getText();
    }

    public void setAllDataInRegistrationForm(){
        
    }


    public void setFirstName(String firstName){
        this.clickOnAddButton();
        WebElement firstNameElement = this.findElementVisibleWithFluentWait(firstNameBy);
        firstNameElement.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        this.clickOnAddButton();
        WebElement lastNameElement = this.findElementVisibleWithFluentWait(lastNameBy);
        lastNameElement.sendKeys(lastName);
    }

    public void setUserEmail(String email){
        this.clickOnAddButton();
        WebElement emailElement = this.findElementVisibleWithFluentWait(userEmailBy);
        emailElement.sendKeys(email);
    }

    public void setAge(String age){
        this.clickOnAddButton();
        WebElement agelement = this.findElementVisibleWithFluentWait(ageBy);
        agelement.sendKeys(age);
    }
    public void setSalary(String salary){
        this.clickOnAddButton();
        WebElement salaryElement = this.findElementVisibleWithFluentWait(salaryBy);
        salaryElement.sendKeys(salary);
    }

    public void setDepartment(String department){
        this.clickOnAddButton();
        WebElement departmentElement = this.findElementVisibleWithFluentWait(departmentBy);
        departmentElement.sendKeys(department);
    }









    private void clickOnAddButton(){
        this.findElementVisibleWithFluentWait(addButton).click();
    }

   


}
