package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WebTablesPage extends AbstractPage {

    private By addButton = By.cssSelector("#addNewRecordButton");
    private By titleOfForm = By.cssSelector("#registration-form-modal");
    private By firstNameBy = By.id("firstName");
    private By lastNameBy = By.id("lastName");
    private By userEmailBy = By.id("userEmail");
    private By ageBy = By.id("age");
    private By salaryBy = By.id("salary");
    private By departmentBy = By.id("department");
    private By submitButton = By.cssSelector("#submit");
    private By closeButton = By.cssSelector(".close");
    private By tableCells = By.cssSelector(".rt-td");
    private By editButtonFirstLine = By.id("edit-record-1");
    private By editButtonSecondLine = By.id("edit-record-1");
    private By editButtonThirdLine = By.id("edit-record-3");

    private final String EMPTY_CELL_TEXT = "&nbsp;";

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleNameOfTheRegistrationForm() {
        this.clickOnAddButton();
        WebElement title = this.findElementVisibleWithFluentWait(titleOfForm);
        return title.getText();
    }

    public void setAllDataInRegistrationFormWithConfirmation(String firstName,
                                                             String lastName,
                                                             String email,
                                                             Integer age,
                                                             Integer salary,
                                                             String department) {
        this.clickOnAddButton();
        this.setFirstNameInModalWindow(firstName);
        this.setLastNameInModalWindow(lastName);
        this.setUserEmailInModalWindow(email);
        this.setAgeInModalWindow(age);
        this.setSalaryInModalWindow(salary);
        this.setDepartmentInModalWindow(department);
        this.clickOnSubmitButton();
    }

    public void editAllDataInAnyChosenLine(int line,
                                           String firstName,
                                           String lastName,
                                           String email,
                                           Integer age,
                                           Integer salary,
                                           String department ){
        this.clickOnEditorInLine(line);
        this.setFirstNameInModalWindow(firstName);
        this.setLastNameInModalWindow(lastName);
        this.setUserEmailInModalWindow(email);
        this.setAgeInModalWindow(age);
        this.setSalaryInModalWindow(salary);
        this.setDepartmentInModalWindow(department);
        this.clickOnSubmitButton();
    }

    public void editSalaryInAnyChosenLine(int line, Integer salary) {
        this.clickOnEditorInLine(line);
        this.setSalaryInModalWindow(salary);
        this.clickOnSubmitButton();
    }
    public void editAgeInAnyChosenLine(int line, Integer age) {
        this.clickOnEditorInLine(line);
        this.setAgeInModalWindow(age);
        this.clickOnSubmitButton();
    }

    public void editFirstNameInAnyChosenLine(int line, String firstName) {
        this.clickOnEditorInLine(line);
        this.setFirstNameInModalWindow(firstName);
        this.clickOnSubmitButton();
    }
    public void editLastNameInAnyChosenLine(int line, String lastName) {
        this.clickOnEditorInLine(line);
        this.setLastNameInModalWindow(lastName);
        this.clickOnSubmitButton();
    }
    public void editEmailInAnyChosenLine(int line, String email) {
        this.clickOnEditorInLine(line);
        this.setUserEmailInModalWindow(email);
        this.clickOnSubmitButton();
    }

    public void editDepartmentInAnyChosenLine(int line, String department) {
        this.clickOnEditorInLine(line);
        this.setDepartmentInModalWindow(department);
        this.clickOnSubmitButton();
    }


    public boolean isAvailableElementWithSuchTextInTable(String text) {
        String byPath = String.format("//div[contains(text(), '%s')]", text);
        WebElement cellWithText = this.findElementVisibleWithFluentWait(By.xpath(byPath));
        if (cellWithText != null) {
            return true;
        } else {
            return false;
        }
    }

    public List<String> getAllFillInCellTexts() {

        List<WebElement> allTableCells = findElementsVisibleWithFluentWait(tableCells);
        List<String> allExistedTexts = allTableCells
                .stream()
                .map(e -> e.getText())
                .filter(t -> !t.isEmpty() && !t.equals(" "))
                .collect(Collectors.toList());
        return allExistedTexts;
    }

    public Integer getNumbersOfGivenTextInList(String text) {
        List<String> givenTexts = getAllFillInCellTexts()
                .stream()
                .filter(t -> t.equals(text))
                .collect(Collectors.toList());
        return givenTexts.size();
    }

    public String getDepartmentInTableInGivenLine(int line) {
        String chosenLine = String.format("edit-record-%d", line);
        WebElement editButton = findElementVisibleWithFluentWait(By.id(chosenLine));

        WebElement departmentElement = this.getDriver()
                .findElement(RelativeLocator
                        .with(By.className("rt-td"))
                        .toLeftOf(editButton));
        String departmentName = departmentElement.getText();

        return departmentName;
    }

    public Map<String, String> getAllEmployeeDataInLineViaEditModalWindow(int line) {
        String chosenLine = String.format("edit-record-%d", line);
        findElementVisibleWithFluentWait(By.id(chosenLine)).click();

        Map<String, String> employeeDataMap = new HashMap<>();
        employeeDataMap.put("firstName", getFirstNameFromModalWindow());
        employeeDataMap.put("lastName", getLastNameFromModalWindow());
        employeeDataMap.put("age", getAgeFromModalWindow().toString());
        employeeDataMap.put("email", getEmailFromModalWindow());
        employeeDataMap.put("salary", getSalaryFromModalWindow().toString());
        employeeDataMap.put("department", getDepartmentFromModalWindow());

        return employeeDataMap;
    }


    //region Getter&Setter_in_ModalWindow
    public String getFirstNameFromModalWindow(int line) {
        this.clickOnEditorInLine(line);
        WebElement firstNameElement = this.findElementVisibleWithFluentWait(firstNameBy);
        return firstNameElement.getAttribute("value");
    }
    public String getLastNameFromModalWindow(int line) {
        this.clickOnEditorInLine(line);
        WebElement lastNameElement = this.findElementVisibleWithFluentWait(lastNameBy);
        return lastNameElement.getAttribute("value");
    }
    public Integer getAgeFromModalWindow(int line) {
        this.clickOnEditorInLine(line);
        WebElement ageElement = this.findElementVisibleWithFluentWait(ageBy);
        return Integer.valueOf(ageElement.getAttribute("value"));
    }
    public String getEmailFromModalWindow(int line) {
        this.clickOnEditorInLine(line);
        WebElement emailElement = this.findElementVisibleWithFluentWait(userEmailBy);
        return emailElement.getAttribute("value");
    }
    public Integer getSalaryFromModalWindow(int line) {
        this.clickOnEditorInLine(line);
        WebElement ageElement = this.findElementVisibleWithFluentWait(salaryBy);
        return Integer.valueOf(ageElement.getAttribute("value"));
    }
    public String getDepartmentFromModalWindow(int line) {
        this.clickOnEditorInLine(line);
        WebElement emailElement = this.findElementVisibleWithFluentWait(departmentBy);
        return emailElement.getAttribute("value");
    }

    public void setFirstNameInModalWindow(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            throw new NullPointerException("Please, fill the first name in");
        }
        WebElement firstNameElement = this.findElementVisibleWithFluentWait(firstNameBy);
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);
    }
    public void setLastNameInModalWindow(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            throw new NullPointerException("Please, fill the last name in");
        }
        WebElement lastNameElement = this.findElementVisibleWithFluentWait(lastNameBy);
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);
    }
    public void setUserEmailInModalWindow(String email) {
        if (email == null || email.isEmpty()) {
            throw new NullPointerException("Please, fill the e-mail in");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException(String.format("%s is not correct name for e-mail, please check for @.", email));
        }
        WebElement emailElement = this.findElementVisibleWithFluentWait(userEmailBy);
        emailElement.clear();
        emailElement.sendKeys(email);
    }
    public void setAgeInModalWindow(Integer age) {
        if (age == null) {
            throw new NullPointerException("Please, fill the age in");
        }
        if (age < 14) {
            throw new IllegalArgumentException(String.format("$d is not acceptable age for employee for this place", age));
        }
        WebElement ageElement = this.findElementVisibleWithFluentWait(ageBy);
        ageElement.clear();
        ageElement.sendKeys(age.toString());
    }
    public void setSalaryInModalWindow(Integer salary) {
        if (salary == null) {
            throw new NullPointerException("Please, fill the salary in");
        }
        if (salary < 100) {
            throw new IllegalArgumentException(String.format("$d should be more than 100.00 or more", salary));
        }
        WebElement salaryElement = this.findElementVisibleWithFluentWait(salaryBy);
        salaryElement.clear();
        salaryElement.sendKeys(salary.toString());
    }
    public void setDepartmentInModalWindow(String department) {
        if (department == null || department.isEmpty()) {
            throw new NullPointerException("Please, fill in the Department");
        }
        if (department.length() < 2) {
            throw new IllegalArgumentException("Please, check Department name: it should contain more than 1 letter");
        }
        WebElement departmentElement = this.findElementVisibleWithFluentWait(departmentBy);
        departmentElement.clear();
        departmentElement.sendKeys(department);
    }

    private String getFirstNameFromModalWindow() {
        WebElement firstNameElement = this.findElementVisibleWithFluentWait(firstNameBy);
        return firstNameElement.getAttribute("value");
    }
    private String getLastNameFromModalWindow() {
        WebElement lastNameElement = this.findElementVisibleWithFluentWait(lastNameBy);
        return lastNameElement.getAttribute("value");
    }
    private Integer getAgeFromModalWindow() {
        WebElement ageElement = this.findElementVisibleWithFluentWait(ageBy);
        return Integer.valueOf(ageElement.getAttribute("value"));
    }
    private String getEmailFromModalWindow() {
        WebElement emailElement = this.findElementVisibleWithFluentWait(userEmailBy);
        return emailElement.getAttribute("value");
    }
    private Integer getSalaryFromModalWindow() {
        WebElement ageElement = this.findElementVisibleWithFluentWait(salaryBy);
        return Integer.valueOf(ageElement.getAttribute("value"));
    }
    private String getDepartmentFromModalWindow() {
        WebElement emailElement = this.findElementVisibleWithFluentWait(departmentBy);
        return emailElement.getAttribute("value");
    }
    //endregion

    //region Click_Buttons
    private void clickOnAddButton() {
        this.findElementVisibleWithFluentWait(addButton).click();
    }
    private void clickOnSubmitButton() {
        this.findElementVisibleWithFluentWait(submitButton).click();
    }
    private void clickOnCloseButtonModalWindow() {
        this.findElementVisibleWithFluentWait(closeButton).click();
    }
    private void clickOnEditorInLine(int line) {
        String chosenLine = String.format("edit-record-%d", line);
        this.findElementVisibleWithFluentWait(By.id(chosenLine)).click();
    }
    //endregion

}
