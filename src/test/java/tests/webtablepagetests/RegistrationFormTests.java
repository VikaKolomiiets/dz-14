package tests.webtablepagetests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ElementsPage;
import pages.WebTablesPage;
import tests.base.BaseTests;
import tests.sources.DataProviderForTests;

public class RegistrationFormTests extends BaseTests {
    private WebTablesPage webTablesPage;

    @BeforeMethod
    public void setUpMethod(){
        ElementsPage elementsPage = this.basePage.clickElementsPageButton();
        webTablesPage = elementsPage.clickOnWebTablesComponent();
    }



    @Description("Positive test")
    @Test
    public void testRegistrationFormAppeared() {
        String actualTitleName = webTablesPage.getTitleNameOfTheRegistrationForm();
        String expectedTitleName = "Registration Form";
        Assert.assertEquals(actualTitleName, expectedTitleName, "Switched page is not opened with Title name");
    }

    @Description("Positive test")
    @Test(dataProviderClass = DataProviderForTests.class, dataProvider = "full-data-registration-form")
    public void testCheckAddedDateViaRegistrationFormPositive(
            String firstName, String lastName, String email, Integer age, Integer salary, String department) {

        boolean isClientDataAddedInTable = false;

        webTablesPage.setAllDataInRegistrationFormWithComfirmation(firstName, lastName, email, age, salary, department);

        if (webTablesPage.isAvailableElementWithSuchTextInTable(firstName)
                && webTablesPage.isAvailableElementWithSuchTextInTable(lastName)
                && webTablesPage.isAvailableElementWithSuchTextInTable(email)
                && webTablesPage.isAvailableElementWithSuchTextInTable(age.toString())
                && webTablesPage.isAvailableElementWithSuchTextInTable(salary.toString())
                && webTablesPage.isAvailableElementWithSuchTextInTable(department)) {
            isClientDataAddedInTable = true;
        }
        Assert.assertTrue(isClientDataAddedInTable, "All Client Data is not found in table.");
    }

    @Description("Positive test")
    @Test(dataProviderClass = DataProviderForTests.class, dataProvider = "full-data-registration-form")
    public void testCheckNumberAddedNewDateViaRegistrationFormPositive(
            String firstName, String lastName, String email, Integer age, Integer salary, String department){

        int numberFillInCellsInTableBefore = webTablesPage.getAllFillInCellTexts().size();
        webTablesPage.setAllDataInRegistrationFormWithComfirmation(firstName, lastName, email, age, salary, department);
        int numberFillInCellsInTableAfter = webTablesPage.getAllFillInCellTexts().size();
        Assert.assertEquals(numberFillInCellsInTableAfter,
                numberFillInCellsInTableBefore + 6,
                "There was not filled in 6 cells in table");

    }

}
