package tests.webtable;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ElementsPage;
import pages.WebTablesPage;
import tests.base.BaseTests;
import tests.sources.DataProviderForTests;

import java.util.Map;

public class RegistrationFormTests extends BaseTests {
    private final int NEW_LINE_NUMBER = 4;
    private final int INPUT_FILED_NUMBER_IN_FORM = 6;

    @Description("Positive test")
    @Test
    public void testRegistrationFormAppeared() {
        ElementsPage elementsPage = this.basePage.clickElementsPageButton();
        WebTablesPage webTablesPage = elementsPage.clickOnWebTablesComponent();
        String actualTitleName = webTablesPage.getTitleNameOfTheRegistrationForm();
        String expectedTitleName = "Registration Form";
        Assert.assertEquals(actualTitleName, expectedTitleName, "Switched page is not opened with Title name");
    }

    @Description("Positive test")
    @Test(dataProviderClass = DataProviderForTests.class, dataProvider = "full-data-registration-form")
    public void testCheckAddedDateAvailableInTable(
            String firstName, String lastName, String email, Integer age, Integer salary, String department) {

        boolean isClientDataAddedInTable = false;

        ElementsPage elementsPage = this.basePage.clickElementsPageButton();
        WebTablesPage webTablesPage = elementsPage.clickOnWebTablesComponent();
        webTablesPage.setAllDataInRegistrationFormWithConfirmation(firstName, lastName, email, age, salary, department);

        if (webTablesPage.isAvailableElementWithSuchTextInTable(firstName)
                && webTablesPage.isAvailableElementWithSuchTextInTable(lastName)
                && webTablesPage.isAvailableElementWithSuchTextInTable(email)
                && webTablesPage.isAvailableElementWithSuchTextInTable(age.toString())
                && webTablesPage.isAvailableElementWithSuchTextInTable(salary.toString())
                && webTablesPage.isAvailableElementWithSuchTextInTable(department)) {
            isClientDataAddedInTable = true;
        }
        Assert.assertTrue(isClientDataAddedInTable, "Client Data is not found in table.");
    }

    @Description("Positive test")
    @Test(dataProviderClass = DataProviderForTests.class, dataProvider = "full-data-registration-form")
    public void testCheckAddedNumbersOfDataPositive(
            String firstName, String lastName, String email, Integer age, Integer salary, String department) {

        ElementsPage elementsPage = this.basePage.clickElementsPageButton();
        WebTablesPage webTablesPage = elementsPage.clickOnWebTablesComponent();
        int numberFillInCellsInTableBefore = webTablesPage.getAllFillInCellTexts().size();
        webTablesPage.setAllDataInRegistrationFormWithConfirmation(firstName, lastName, email, age, salary, department);
        int numberFillInCellsInTableAfter = webTablesPage.getAllFillInCellTexts().size();

        Assert.assertEquals(
                numberFillInCellsInTableAfter,
                numberFillInCellsInTableBefore + INPUT_FILED_NUMBER_IN_FORM,
                "Incorrect number of filled cells");
        Assert.assertEquals(
                webTablesPage.getDepartmentInTableInGivenLine(NEW_LINE_NUMBER),
                department,
                "Department is not correct in added employee data.");
    }

    @Description("Positive test")
    @Test(dataProviderClass = DataProviderForTests.class, dataProvider = "full-data-registration-form")
    public void testEveryAddedDataAvailible(
            String firstName, String lastName, String email, Integer age, Integer salary, String department) {

        ElementsPage elementsPage = this.basePage.clickElementsPageButton();
        WebTablesPage webTablesPage = elementsPage.clickOnWebTablesComponent();

        webTablesPage.setAllDataInRegistrationFormWithConfirmation(firstName, lastName, email, age, salary, department);
        Map<String, String> employeeDataFirstLine = webTablesPage.getAllEmployeeDataInLineViaEditorModal(NEW_LINE_NUMBER);

        Assert.assertEquals(
                employeeDataFirstLine.get("firstName"), firstName, "First name is not equal.");
        Assert.assertEquals(
                employeeDataFirstLine.get("lastName"), lastName, "Last name is not equal.");
        Assert.assertEquals(
                Integer.valueOf(employeeDataFirstLine.get("age")), age, "Age is not equal.");
        Assert.assertEquals(
                employeeDataFirstLine.get("email"), email, "E-mail is not equal.");
        Assert.assertEquals(
                employeeDataFirstLine.get("department"), department, "Department is not equal.");
        Assert.assertEquals(
                Integer.valueOf(employeeDataFirstLine.get("salary")), salary, "Salary is not equal.");
    }


}
