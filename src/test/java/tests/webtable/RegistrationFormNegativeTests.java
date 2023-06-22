package tests.webtable;

import io.qameta.allure.Description;

import java.awt.Color;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.WebTablesPage;
import tests.base.BaseTests;
import tests.sources.DataProviderForTests;
import utils.ColorUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationFormNegativeTests extends BaseTests {

    private static final String BORDER_COLOR_RED = "rgb(207, 196, 203)";

    @Description("Negative test")
    @Test
    public void testRedBorderAlertOfAllElements() {
        ElementsPage elementsPage = this.basePage.clickElementsPageButton();
        WebTablesPage webTablesPage = elementsPage.clickOnWebTablesComponent();
        Assert.assertTrue(webTablesPage.isRedBorderColorAllElementsWithEmptySubmit(),
                "All Elements didn't change their border color");
    }

    @Test
    public void test() {
        ElementsPage elementsPage = this.basePage.clickElementsPageButton();
        WebTablesPage webTablesPage = elementsPage.clickOnWebTablesComponent();
        String text = "ugu@niknh.jkh";
        Pattern endPattern = Pattern.compile(".[A-Za-z]{2,5}");
        Pattern startPattern = Pattern.compile("[a-zA-Z0-9]@");
        Pattern meddlePattern = Pattern.compile("@[a-zA-Z0-9].");
        boolean isEnd = endPattern.matcher(text).find();
        boolean isStart = startPattern.matcher(text).find();
        boolean isMiddle = meddlePattern.matcher(text).find();

        System.out.println(text);
        System.out.println(isEnd);
        System.out.println(isStart);
        System.out.println(isMiddle);
    }

    @Description("Negative test")
    @Test(dataProviderClass = DataProviderForTests.class, dataProvider = "email-red-alert")
    public void testEmailExceptionByRedBorderAlert(
            String firstName, String lastName, String email, Integer age, Integer salary, String department) {
        ElementsPage elementsPage = this.basePage.clickElementsPageButton();
        WebTablesPage webTablesPage = elementsPage.clickOnWebTablesComponent();
        webTablesPage.setAllDataInRegistrationFormConfirmForEmailChecking(firstName, lastName, email, age, salary, department);
        String actualBorderColor = webTablesPage.getEmailBorderColor();

        Assert.assertTrue(
            ColorUtils.isColorInGivenRange(actualBorderColor, BORDER_COLOR_RED),
                String.format("Alert is not appe" +
                        "ared via incorrect email %s", email));
    }


}
