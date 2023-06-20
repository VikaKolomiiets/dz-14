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
    public void testEditSalaryInTablePositive(Integer salary) {
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
    @Description("Positive test")
    @Test(dataProviderClass = DataProviderForTests.class, dataProvider = "edit-age-form")
    public void testEditAgePlusYearInTablePositive(Integer line){
        var elementsPage = basePage.clickElementsPageButton();
        var webTables = elementsPage.clickOnWebTablesComponent();
        //= webTables.getAgeFromModalWindow(Integer line);
        Integer actualAgeFirstLine = webTables.editAgePlusOneInAnyChosenFilledLine(1);
        Integer actualAgeSecondLine = webTables.editAgePlusOneInAnyChosenFilledLine(2);
        Integer actualAgeThirdLine = webTables.editAgePlusOneInAnyChosenFilledLine(3);





    }
}
