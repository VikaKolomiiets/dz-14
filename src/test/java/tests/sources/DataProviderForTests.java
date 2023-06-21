package tests.sources;

import org.testng.annotations.DataProvider;

public class DataProviderForTests {

    @DataProvider(name = "full-data-registration-form")
    public static Object[][] setUpAllDataForRegistrationFormPositive() {
        return new Object[][]{
                {"Agnesa", "Wolf", "agwf@gmail.com", 58, 5000, "Medicine"},
                {"Boris", "Red", "boris@gmail.com", 60, 8000, "IT"}};
    }

    @DataProvider(name = "edit-salary-form")
    public static Object[][] setUpSalaryInLineForForPositiveTest() {
        return new Object[][]{
                {1, 1580},
                {2, 1110},
                {3, 2415}};
    }

    @DataProvider(name = "edit-age-form")
    public static Object[][] setUpAgeInLineForPositiveTests() {
        return new Object[][]{
                {1, 15},
                {2, 29},
                {3, 90}};
    }

    @DataProvider(name = "edit-firstname-form")
    public static Object[][] setUpFirstNameInLineForPositiveTests() {
        return new Object[][]{
                {3, "Aawaa"},
                {1, "Krown"},
                {2, "Wolf"}};
    }


}
