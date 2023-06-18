package tests.webtablepagetests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.ElementsPage;
import pages.WebTablesPage;
import tests.base.BaseTests;
import tests.sources.DataProviderForTests;

public class RegistrationFormTests extends BaseTests {


    @Test
    public void testRegistrationFormAppeared() {
        ElementsPage elementsPage = this.basePage.clickElementsPageButton();
        WebTablesPage webTablesPage = elementsPage.clickOnWebTablesComponent();
        String actualTitleName = webTablesPage.getTitleNameOfTheRegistrationForm();
        String expectedTitleName = "Registration Form";
        Assert.assertEquals(actualTitleName, expectedTitleName, "Switched page is not opened with Title name");
    }

    @Test(dataProviderClass = DataProviderForTests.class, dataProvider = "full-data-registration-form")
    public void testFillInRegistrationFormPositive(
            String firstName, String lastName, String email, Integer age, Integer salary, String department) {

        ElementsPage elementsPage = this.basePage.clickElementsPageButton();
        WebTablesPage webTablesPage = elementsPage.clickOnWebTablesComponent();
        webTablesPage.setAllDataInRegistrationForm(firstName, lastName, email, age, salary, department);

        boolean isAvailible = webTablesPage.isAvailableElementWithSuchTextInTable(firstName);

        Assert.assertTrue(webTablesPage.isAvailableElementWithSuchTextInTable(firstName), "FirstName is not found in table.");
        Assert.assertTrue(webTablesPage.isAvailableElementWithSuchTextInTable(lastName), "FirstName is not found in table.");
        Assert.assertTrue(webTablesPage.isAvailableElementWithSuchTextInTable(email), "E-mail is not found in table.");
        Assert.assertTrue(webTablesPage.isAvailableElementWithSuchTextInTable(age.toString()), "Age is not found in table.");
        Assert.assertTrue(webTablesPage.isAvailableElementWithSuchTextInTable(salary.toString()), "Salary is not found.");
        Assert.assertTrue(webTablesPage.isAvailableElementWithSuchTextInTable(department), "Department is not found.");

    }
}
