package tests.buttons;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ButtonsPage;
import pages.ElementsPage;
import tests.base.BaseTests;

public class ButtonsMessageTest extends BaseTests {

    @Test
    public void testClickMeButtonPositive(){
        ElementsPage elementsPage = basePage.clickElementsPageButton();
        ButtonsPage buttonsPage = elementsPage.clickOnButtonPageComponent();

        String actualText = buttonsPage.getTestAfterClickOnButtonClickMe();
        String expectedText = "You have done a dynamic click";

        Assert.assertEquals(actualText, expectedText, "Text is not equal to expected after click on ClickMe button.");
    }
}
