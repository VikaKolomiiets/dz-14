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
    public void testEditSalaryInChosenLineOfTablePositive(Integer line, Integer salary) {
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
    public void testEditAgeInChosenLineOfTablePositive(int line, Integer age){
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
    public void testEditFirstNameInChosenLineOfTablePositive(int line, String firstName){
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
    public void testEditLastNameInChosenLineOfTablePositive(int line, String lastName){
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
    public void testEditEmailInChosenLineOfTablePositive(int line, String email){
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
    public void testEditDepartmentInChosenLineOfTablePositive(int line, String department){
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

    @Description("Positive test")
    @Test(dataProviderClass = DataProviderForTests.class, dataProvider = "edit-all-form")
    public void testEditAllDataInChosenLineOfTablePositive(
            int line, String firstName, String lastName, String email, Integer age, Integer salary, String department){
        var elementsPage = basePage.clickElementsPageButton();
        var webTables = elementsPage.clickOnWebTablesComponent();

        webTables.editAllDataInAnyChosenLine(line, firstName, lastName, email, age, salary, department);

        Map<String, String> editedData = webTables.getAllEmployeeDataInLineViaEditModalWindow(line);

        Assert.assertEquals(
                editedData.get("firstName"), firstName, "Given text is not exist in first Name cell.");
        Assert.assertEquals(
                editedData.get("lastName"), lastName, "Given text is not exist in last Name cell.");
        Assert.assertEquals(
                editedData.get("email"), email, "Given text is not exist in e-mail cell.");
        Assert.assertEquals(
                editedData.get("department"), department, "Given text is not exist in department cell.");
        Assert.assertEquals(
                editedData.get("age"), age.toString(), "Given text is not exist in age cell.");
        Assert.assertEquals(
                editedData.get("salary"), salary.toString(), "Given text is not exist in salary cell.");

    }

}
