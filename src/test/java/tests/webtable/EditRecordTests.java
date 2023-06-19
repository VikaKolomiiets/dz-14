package tests.webtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.base.BaseTests;
import tests.sources.DataProviderForTests;

import java.util.List;
import java.util.stream.Collectors;

public class EditRecordTests extends BaseTests {


    @Test(dataProviderClass = DataProviderForTests .class, dataProvider = "edit-salary-form")
    public void testEditAgeInTable(Integer salary){
       var elementsPage = basePage.clickElementsPageButton();
       var webTables = elementsPage.clickOnWebTablesComponent();
       List<String> beforeSalaryTexts= webTables
               .getAllFillInCellTexts()
               .stream()
               .filter(t -> t.equals(salary.toString()))
               .collect(Collectors.toList());

       webTables.editSalaryInFirstLine(salary);

       List<String> afterSalaryTexts= webTables
               .getAllFillInCellTexts()
               .stream()
               .filter(t -> t.equals(salary.toString()))
               .collect(Collectors.toList());
        Assert.assertEquals(afterSalaryTexts.size(),
                beforeSalaryTexts.size() + 1,
                "Salary is not changed");
    }
}
