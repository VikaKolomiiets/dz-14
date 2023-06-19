package tests.webtablepagetests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ElementsPage;
import pages.WebTablesPage;
import tests.base.BaseTests;
import tests.sources.DataProviderForTests;

public class RegistrationFormTests extends BaseTests {

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
    public void testFillInRegistrationFormPositive(
            String firstName, String lastName, String email, Integer age, Integer salary, String department) {

        boolean isClientDataAddedInTable = false;
        ElementsPage elementsPage = this.basePage.clickElementsPageButton();
        WebTablesPage webTablesPage = elementsPage.clickOnWebTablesComponent();
        webTablesPage.setAllDataInRegistrationForm(firstName, lastName, email, age, salary, department);

        boolean isFirstName = webTablesPage.isAvailableElementWithSuchTextInTable(firstName);
        boolean isLastName = webTablesPage.isAvailableElementWithSuchTextInTable(lastName);
        boolean isEmailName = webTablesPage.isAvailableElementWithSuchTextInTable(email);
        boolean isAgeName = webTablesPage.isAvailableElementWithSuchTextInTable(age.toString());
        boolean isSalaryName = webTablesPage.isAvailableElementWithSuchTextInTable(salary.toString());
        boolean isDepartmentInTable = webTablesPage.isAvailableElementWithSuchTextInTable(department);

        if (isFirstName && isLastName && isEmailName && isAgeName && isSalaryName && isDepartmentInTable) {
            isClientDataAddedInTable = true;
        }
        Assert.assertTrue(isClientDataAddedInTable, "All Client Data is not found in table.");
    }
}
