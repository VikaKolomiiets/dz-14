package tests.webtablepagetests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.WebTablesPage;
import tests.base.BaseTests;

public class RegistrationFormTests extends BaseTests {
    private  WebTablesPage webTablesPage;

    @BeforeMethod
    public void setUpTest(){
        ElementsPage elementsPage = basePage.clickElementPageButton();
        WebTablesPage webTablesPage = elementsPage.clickOnWebTablesComponent();
    }

    @Test
    public void testRegistrationFormAppeared(){
        String actualTitleName = webTablesPage.getTitleNameOfTheRegistrationForm();
        String expectedTitleName = "Registration Form";
        Assert.assertEquals(actualTitleName, expectedTitleName, "Switched page is not opened with Title name" );
    }

    @Test
    public void testFillInRegistrationFormPositive(){

    }
}
