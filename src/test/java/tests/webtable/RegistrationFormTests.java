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
        webTablesPage.setAllDataInRegistrationFormConfirm(firstName, lastName, email, age, salary, department);

        if (webTablesPage.isAvailableElementWithGivenTextInTable(firstName)
                && webTablesPage.isAvailableElementWithGivenTextInTable(lastName)
                && webTablesPage.isAvailableElementWithGivenTextInTable(email)
                && webTablesPage.isAvailableElementWithGivenTextInTable(age.toString())
                && webTablesPage.isAvailableElementWithGivenTextInTable(salary.toString())
                && webTablesPage.isAvailableElementWithGivenTextInTable(department)) {
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
        webTablesPage.setAllDataInRegistrationFormConfirm(firstName, lastName, email, age, salary, department);
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

        webTablesPage.setAllDataInRegistrationFormConfirm(firstName, lastName, email, age, salary, department);
        Map<String, String> employeeDataAddedLine = webTablesPage.getAllEmployeeDataInLineViaEditModalWindow(NEW_LINE_NUMBER);

        Assert.assertEquals(
                employeeDataAddedLine.get("firstName"), firstName, "First name is not equal.");
        Assert.assertEquals(
                employeeDataAddedLine.get("lastName"), lastName, "Last name is not equal.");
        Assert.assertEquals(
                Integer.valueOf(employeeDataAddedLine.get("age")), age, "Age is not equal.");
        Assert.assertEquals(
                employeeDataAddedLine.get("email"), email, "E-mail is not equal.");
        Assert.assertEquals(
                employeeDataAddedLine.get("department"), department, "Department is not equal.");
        Assert.assertEquals(
                Integer.valueOf(employeeDataAddedLine.get("salary")), salary, "Salary is not equal.");
    }

}
