package tests.webtable;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTests;
import tests.sources.DataProviderForTests;


public class EditRecordTests extends BaseTests {

    @Description("Positive test")
    @Test(dataProviderClass = DataProviderForTests.class, dataProvider = "edit-salary-form")
    public void testEditAgeInTable(Integer salary) {
        var elementsPage = basePage.clickElementsPageButton();
        var webTables = elementsPage.clickOnWebTablesComponent();
        Integer numbersBeforeEdit = webTables.getNumbersOfGivenTextInList(salary.toString());

        webTables.editSalaryInFirstLine(salary);
        Integer numbersAfterEdit = webTables.getNumbersOfGivenTextInList(salary.toString());

        Assert.assertEquals(numbersAfterEdit,
                numbersBeforeEdit + 1,
                "Salary is not changed for given one.");
        Assert.assertTrue(webTables.isAvailableElementWithSuchTextInTable(salary.toString()),
                "New salary is not found in table data");
    }
}
