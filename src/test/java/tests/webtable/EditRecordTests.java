package tests.webtable;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTests;
import tests.sources.DataProviderForTests;


public class EditRecordTests extends BaseTests {

    @Description("Positive test")
    @Test(dataProviderClass = DataProviderForTests.class, dataProvider = "edit-salary-form")
    public void testEditSalaryInTable(Integer salary) {
        var elementsPage = basePage.clickElementsPageButton();
        var webTables = elementsPage.clickOnWebTablesComponent();
        Integer numbersGivenTextBeforeEdit = webTables.getNumbersOfGivenTextInList(salary.toString());

        webTables.editSalaryInFirstLine(salary);
        Integer numbersGivenTextAfterEdit = webTables.getNumbersOfGivenTextInList(salary.toString());

        Assert.assertEquals(numbersGivenTextAfterEdit,
                numbersGivenTextBeforeEdit + 1,
                "Numbers of text Salary are not increased.");
        Assert.assertTrue(webTables.isAvailableElementWithSuchTextInTable(salary.toString()),
                "The text of given salary is not found in the table.");
    }
}
