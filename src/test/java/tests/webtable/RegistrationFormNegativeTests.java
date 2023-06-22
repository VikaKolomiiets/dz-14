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
    private static final String ALERT_IMAGE = "fill='none' stroke='%23dc3545'";

    @Description("Negative test")
    @Test
    public void testRedBorderAlertOfAllElements() {
        ElementsPage elementsPage = this.basePage.clickElementsPageButton();
        WebTablesPage webTablesPage = elementsPage.clickOnWebTablesComponent();
        Assert.assertTrue(webTablesPage.isAlertImageExistsWhenAllElementsEmptySubmit(),
                "All Elements didn't change their border color");
    }

    @Description("Negative test")
    @Test(dataProviderClass = DataProviderForTests.class, dataProvider = "email-red-alert")
    public void testEmailExceptionByRedBorderAlert(
            String firstName, String lastName, String email, Integer age, Integer salary, String department) {
        ElementsPage elementsPage = this.basePage.clickElementsPageButton();
        WebTablesPage webTablesPage = elementsPage.clickOnWebTablesComponent();
        webTablesPage.setAllDataInFormConfirmToCheckEmailAlert(firstName, lastName, email, age, salary, department);
        String actualImage = webTablesPage.getEmailAlertImage();

        Assert.assertTrue(
                actualImage.contains(ALERT_IMAGE),
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
        String actualImage = webTablesPage.getAgeAlerImage();
        Assert.assertTrue(
                actualImage.contains(ALERT_IMAGE),
                String.format("Alert is not appeared via incorrect age %s", age));
    }


    @Description("Negative test")
    @Test(dataProviderClass = DataProviderForTests.class, dataProvider = "salary-red-alert")
    public void testSalaryExceptionByAlertImageExists(
            String firstName, String lastName, String email, Integer age, String salary, String department){
        ElementsPage elementsPage = this.basePage.clickElementsPageButton();
        WebTablesPage webTablesPage = elementsPage.clickOnWebTablesComponent();
        webTablesPage.setAllDataInFormToCheckSalaryAlert(firstName, lastName, email, age, salary, department);
        String actualImage = webTablesPage.getSalaryAlertImage();
        Assert.assertTrue(
                actualImage.contains(ALERT_IMAGE),
                String.format("Alert is not appeared via incorrect salary %s", salary));
    }
}


