package tests.webtable;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTests;
import tests.sources.DataProviderForTests;

import java.util.Map;


public class EditRecordTests extends BaseTests {

    @Description("Positive test")
    @Test(dataProviderClass = DataProviderForTests.class, dataProvider = "edit-salary-form")
    public void testEditSalaryInTablePositive(Integer line, Integer salary) {
        var elementsPage = basePage.clickElementsPageButton();
        var webTables = elementsPage.clickOnWebTablesComponent();
        Integer numbersOfGivenTextBeforeEdit = webTables.getNumbersOfGivenTextInList(salary.toString());

        webTables.editSalaryInAnyChosenLine(line, salary);
        Integer numbersOfGivenTextAfterEdit = webTables.getNumbersOfGivenTextInList(salary.toString());
        Integer editedSalary = webTables.getSalaryFromModalWindow(line);

        Assert.assertTrue(webTables.isAvailableElementWithSuchTextInTable(salary.toString()),
                "The given text of salary is not found in the table.");
        Assert.assertEquals(numbersOfGivenTextAfterEdit,
                numbersOfGivenTextBeforeEdit + 1,
                "The numbers of the given text do not increase in the table.");
        Assert.assertEquals(editedSalary, salary, "Given text doesn't exist in Salary input cell.");
    }

    @Description("Positive test")
    @Test(dataProviderClass = DataProviderForTests.class, dataProvider = "edit-age-form")
    public void testEditAgeInTablePositive(int line, Integer age){
        var elementsPage = basePage.clickElementsPageButton();
        var webTables = elementsPage.clickOnWebTablesComponent();
        Integer numbersOfGivenTextBeforeEdit = webTables.getNumbersOfGivenTextInList(age.toString());

        webTables.editAgeInAnyChosenLine(line, age);

        Integer numbersOfGivenTextAfterEdit = webTables.getNumbersOfGivenTextInList(age.toString());
        Integer editedAge = webTables.getAgeFromModalWindow(line);

        Assert.assertTrue(webTables.isAvailableElementWithSuchTextInTable(age.toString()),
                "Given Age is not found in the table.");
        Assert.assertEquals(numbersOfGivenTextAfterEdit,
                numbersOfGivenTextBeforeEdit + 1,
                "The numbers of the given text do not increase in the table.");
        Assert.assertEquals(editedAge, age, "Given text does not exist in Age input cell.");
    }

    @Description("Positive test")
    @Test(dataProviderClass = DataProviderForTests.class, dataProvider = "edit-name-form")
    public void testEditFirstNameInTablePositive(int line, String firstName){
        var elementsPage = basePage.clickElementsPageButton();
        var webTables = elementsPage.clickOnWebTablesComponent();
        Integer numbersOfGivenTextBeforeEdit = webTables.getNumbersOfGivenTextInList(firstName);

        webTables.editFirstNameInAnyChosenLine(line, firstName);

        Integer numbersOfGivenTextAfterEdit = webTables.getNumbersOfGivenTextInList(firstName);
        String editedFirstName = webTables.getFirstNameFromModalWindow(line);
        Assert.assertTrue(webTables.isAvailableElementWithSuchTextInTable(firstName),
                "Given FirstName is not found in the table.");
        Assert.assertEquals(numbersOfGivenTextAfterEdit,
                numbersOfGivenTextBeforeEdit + 1,
                "The numbers of the given text do not increase in the table.");
        Assert.assertEquals(editedFirstName, firstName, "Given text does not exist in FirstName input cell");

    }

    @Description("Positive test")
    @Test(dataProviderClass = DataProviderForTests.class, dataProvider = "edit-name-form")
    public void testEditLastNameInTablePositive(int line, String lastName){
        var elementsPage = basePage.clickElementsPageButton();
        var webTables = elementsPage.clickOnWebTablesComponent();
        Integer numbersOfGivenTextBeforeEdit = webTables.getNumbersOfGivenTextInList(lastName);

        webTables.editLastNameInAnyChosenLine(line, lastName);

        Integer numbersOfGivenTextAfterEdit = webTables.getNumbersOfGivenTextInList(lastName);
        String editedLastName = webTables.getLastNameFromModalWindow(line);
        Assert.assertTrue(webTables.isAvailableElementWithSuchTextInTable(lastName),
                "Given LastName is not found in the table.");
        Assert.assertEquals(numbersOfGivenTextAfterEdit,
                numbersOfGivenTextBeforeEdit + 1,
                "The numbers of the given text do not increase in the table.");
        Assert.assertEquals(editedLastName, lastName, "Given text does not exist in LastName input cell");
    }

    @Description("Positive test")
    @Test(dataProviderClass = DataProviderForTests.class, dataProvider = "edit-email-form")
    public void testEditEmailInTablePositive(int line, String email){
        var elementsPage = basePage.clickElementsPageButton();
        var webTables = elementsPage.clickOnWebTablesComponent();
        Integer numbersOfGivenTextBeforeEdit = webTables.getNumbersOfGivenTextInList(email);

        webTables.editEmailInAnyChosenLine(line, email);

        Integer numbersOfGivenTextAfterEdit = webTables.getNumbersOfGivenTextInList(email);
        String editedEmail = webTables.getEmailFromModalWindow(line);
        Assert.assertTrue(webTables.isAvailableElementWithSuchTextInTable(email),
                "Given LastName is not found in the table.");
        Assert.assertEquals(numbersOfGivenTextAfterEdit,
                numbersOfGivenTextBeforeEdit + 1,
                "The numbers of the given text do not increase in the table.");
        Assert.assertEquals(editedEmail, email, "Given text does not exist in E-mail input cell");
    }

    @Description("Positive test")
    @Test(dataProviderClass = DataProviderForTests.class, dataProvider = "edit-department-form")
    public void testEditDepartmentInTablePositive(int line, String department){
        var elementsPage = basePage.clickElementsPageButton();
        var webTables = elementsPage.clickOnWebTablesComponent();
        Integer numbersOfGivenTextBeforeEdit = webTables.getNumbersOfGivenTextInList(department);

        webTables.editDepartmentInAnyChosenLine(line, department);

        Integer numbersOfGivenTextAfterEdit = webTables.getNumbersOfGivenTextInList(department);
        String editedDepartment = webTables.getDepartmentFromModalWindow(line);
        Assert.assertTrue(
                webTables.isAvailableElementWithSuchTextInTable(department),
                "Given LastName is not found in the table.");
        Assert.assertEquals(
                numbersOfGivenTextAfterEdit,
                numbersOfGivenTextBeforeEdit + 1,
                "The numbers of the given text do not increase in the table.");
        Assert.assertEquals(
                editedDepartment,
                department,
                "Given text does not exist in Department input cell");
    }


}
