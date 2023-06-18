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
    private By closeButton = By.cssSelector(".close");

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }


    public String getTitleNameOfTheRegistrationForm(){
        this.clickOnAddButton();
        WebElement title = this.findElementVisibleWithFluentWait(titleOfForm);
        return title.getText();
    }

    public void setAllDataInRegistrationForm(String firstName, String lastName, String email, Integer age, Double salary, String department ){
        this.clickOnAddButton();
        this.setFirstNameInModalWindow(firstName);
        this.setLastNameInModalWindow(lastName);
        this.setUserEmailInModalWindow(email);
        this.setAgeInModalWindow(age);
        this.setSalaryInModalWindow(salary);
        this.setDepartmentInModalWindow(department);
        this.clickOnSubmitButton();
    }


    public void setFirstNameInModalWindow(String firstName){
        WebElement firstNameElement = this.findElementVisibleWithFluentWait(firstNameBy);
        firstNameElement.sendKeys(firstName);
    }

    public void setLastNameInModalWindow(String lastName){
        WebElement lastNameElement = this.findElementVisibleWithFluentWait(lastNameBy);
        lastNameElement.sendKeys(lastName);
    }

    public void setUserEmailInModalWindow(String email){
        if(!email.contains("@")){
            throw new IllegalArgumentException(String.format("%s is not correct for e-mail, please check for @.", email));
        }
        WebElement emailElement = this.findElementVisibleWithFluentWait(userEmailBy);
        emailElement.sendKeys(email);
    }

    public void setAgeInModalWindow(Integer age){
        if(age < 14){
            throw new IllegalArgumentException(String.format("$d is not acceptable age for employee for this place", age ));
        }
        WebElement ageElement = this.findElementVisibleWithFluentWait(ageBy);
        ageElement.sendKeys(age.toString());
    }
    public void setSalaryInModalWindow(Double salary){
        if(salary < 500.00){
            throw new IllegalArgumentException(String.format("$d should be more than 500.00 or more", salary ));
        }
        WebElement salaryElement = this.findElementVisibleWithFluentWait(salaryBy);
        salaryElement.sendKeys(salary.toString());
    }

    public void setDepartmentInModalWindow(String department){
        if(department == null || department.isEmpty()){
            throw new NullPointerException("Please, fill in the Department");
        }
        if(department.length() < 2){
            throw new IllegalArgumentException("Please, check Department name: it should contain more than 1 letter");
        }
        WebElement departmentElement = this.findElementVisibleWithFluentWait(departmentBy);
        departmentElement.sendKeys(department);
    }

    public void clickOnAddButton(){
        this.findElementVisibleWithFluentWait(addButton).click();
    }
    public void clickOnSubmitButton(){
        this.findElementVisibleWithFluentWait(submitButton);
    }
    public void clickOnCloseButton(){
        this.findElementVisibleWithFluentWait(closeButton);
    }

}
