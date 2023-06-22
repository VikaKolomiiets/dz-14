package tests.webtable;

import io.qameta.allure.Description;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.WebTablesPage;
import tests.base.BaseTests;
import tests.sources.DataProviderForTests;
import utils.ColorUtils;

import java.util.regex.Pattern;

public class RegistrationFormNegativeTests extends BaseTests {

    private static final String BORDER_COLOR_RED = "rgb(220, 53, 69)";

    @Description("Negative test")
    @Test
    public void testRedBorderAlertOfAllElements() {
        ElementsPage elementsPage = this.basePage.clickElementsPageButton();
        WebTablesPage webTablesPage = elementsPage.clickOnWebTablesComponent();
        Assert.assertTrue(webTablesPage.isRedBorderColorAllElementsWithEmptySubmit(),
                "All Elements didn't change their border color");
    }


    @Description("Negative test")
    @Test(dataProviderClass = DataProviderForTests.class, dataProvider = "email-red-alert")
    public void testEmailExceptionByRedBorderAlert(
            String firstName, String lastName, String email, Integer age, Integer salary, String department) {
        ElementsPage elementsPage = this.basePage.clickElementsPageButton();
        WebTablesPage webTablesPage = elementsPage.clickOnWebTablesComponent();
        webTablesPage.setAllDataInFormConfirmToCheckEmailAlert(firstName, lastName, email, age, salary, department);
        String actualBorderColor = webTablesPage.getEmailBorderColor();

        Assert.assertTrue(
            ColorUtils.isColorInGivenRange(actualBorderColor, BORDER_COLOR_RED),
                String.format("Alert is not appeared via incorrect email %s", email));
    }

    @Description("Negative test")
    @Test(dataProviderClass = DataProviderForTests.class, dataProvider = "age-red-alert")
    public void testAgeExceptionByRedBorderAlert(
            String firstName, String lastName, String email, String age, Integer salary, String department
    ){
        ElementsPage elementsPage = this.basePage.clickElementsPageButton();
        WebTablesPage webTablesPage = elementsPage.clickOnWebTablesComponent();
        webTablesPage.setAllDataInFormToCheckAgeAlert(firstName, lastName, email, age, salary, department);
        String actualBorderColor = webTablesPage.getAgeBorderColor();
        Assert.assertTrue(
                ColorUtils.isColorInGivenRange(actualBorderColor, BORDER_COLOR_RED),
                String.format("Alert is not appeared via incorrect age %s", age));
    }

    @Description("Negative test")
    @Test(dataProviderClass = DataProviderForTests.class, dataProvider = "salary-red-alert")
    public void testSalaryExceptionByRedBorderAlert(
            String firstName, String lastName, String email, Integer age, String salary, String department
    ){
        ElementsPage elementsPage = this.basePage.clickElementsPageButton();
        WebTablesPage webTablesPage = elementsPage.clickOnWebTablesComponent();
        webTablesPage.setAllDataInFormToCheckSalaryAlert(firstName, lastName, email, age, salary, department);
        String actualBorderColor = webTablesPage.getSalaryBorderColor();
        Assert.assertTrue(
                ColorUtils.isColorInGivenRange(actualBorderColor, BORDER_COLOR_RED),
                String.format("Alert is not appeared via incorrect salary %s", salary));
    }

}
