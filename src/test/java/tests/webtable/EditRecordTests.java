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
    public void testEditSalaryInTablePositive(Integer line, Integer salary) {
        var elementsPage = basePage.clickElementsPageButton();
        var webTables = elementsPage.clickOnWebTablesComponent();
        Integer numbersOfGivenTextBeforeEdit = webTables.getNumbersOfGivenTextInList(salary.toString());

        webTables.editSalaryInAnyChosenLine(line, salary);
        Integer numbersOfGivenTextAfterEdit = webTables.getNumbersOfGivenTextInList(salary.toString());

        Assert.assertTrue(webTables.isAvailableElementWithSuchTextInTable(salary.toString()),
                "The given text of salary is not found in the table.");
        Assert.assertEquals(numbersOfGivenTextAfterEdit,
                numbersOfGivenTextBeforeEdit + 1,
                "The numbers of the given text do not increase in the table.");
    }

    @Description("Positive test")
    @Test(dataProviderClass = DataProviderForTests.class, dataProvider = "edit-age-form")
    public void testEditAgeInTablePositive(Integer line, Integer age){
        var elementsPage = basePage.clickElementsPageButton();
        var webTables = elementsPage.clickOnWebTablesComponent();
        Integer numbersOfGivenTextBeforeEdit = webTables.getNumbersOfGivenTextInList(age.toString());

        webTables.editAgeInAnyChosenLine(line, age);

        Integer numbersOfGivenTextAfterEdit = webTables.getNumbersOfGivenTextInList(age.toString());

        Integer editedAge = webTables.getAgeFromModalWindow();
        Assert.assertTrue(webTables.isAvailableElementWithSuchTextInTable(age.toString()),
                "The given text of age is not found in the table.");
        Assert.assertEquals(numbersOfGivenTextAfterEdit,
                numbersOfGivenTextBeforeEdit + 1,
                "The numbers of the given text do not increase in the table.");
        Assert.assertEquals(editedAge, age, "The age does not exist in age cell ");






    }
}
