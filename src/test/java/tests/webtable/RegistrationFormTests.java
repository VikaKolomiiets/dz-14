package tests.webtable;

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
    public void testCheckAddedDateViaRegistrationFormPositive(
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
    public void testCheckNumberAddedNewDateViaRegistrationFormPositive(
            String firstName, String lastName, String email, Integer age, Integer salary, String department){

        ElementsPage elementsPage = this.basePage.clickElementsPageButton();
        WebTablesPage webTablesPage = elementsPage.clickOnWebTablesComponent();
        int numberFillInCellsInTableBefore = webTablesPage.getAllFillInCellTexts().size();
        webTablesPage.setAllDataInRegistrationFormWithConfirmation(firstName, lastName, email, age, salary, department);
        int numberFillInCellsInTableAfter = webTablesPage.getAllFillInCellTexts().size();
        Assert.assertEquals(numberFillInCellsInTableAfter,
                numberFillInCellsInTableBefore + 6,
                "Incorrect number of filled cells");
    }

}
