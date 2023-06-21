package tests.sources;

import org.testng.annotations.DataProvider;

public class DataProviderForTests {

    @DataProvider(name = "full-data-registration-form")
    public static Object[][] setUpAllDataForRegistrationPositive() {
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

    @DataProvider(name = "edit-name-form")
    public static Object[][] setUpNameInLineForPositiveTests() {
        return new Object[][]{
                {3, "Aawaa"},
                {1, "Krown"},
                {2, "Wolf"}};
    }

    @DataProvider(name="edit-email-form")
    public Object[][] setUpEmailInLineForPositiveTests(){
        return new Object[][]{
                {2, "ihb@gmail.com"},
                {1, "krown@ukr.net"},
                {3, "wolf@ii.com"}};
    }
    @DataProvider(name = "edit-department-form")
    public Object[][] setDepartmentInLineForPositiveTests(){
        return new Object[][]{
                {1, "Pharmaceutical"},
                {2, "Surgery"},
                {3, "Laboratory"}};
    }

    @DataProvider(name = "edit-all-form")
    public Object[][] setUpAllDataInLineForPositiveTest(){
        return new Object[][]{
            {1, "Agnesa", "Wolf", "agwf@gmail.com", 58, 5000, "Medicine"},
            {2, "Boris", "Red", "boris@gmail.com", 60, 8000, "IT"},
            {3, "Assa", "Bob", "11@22.ua", 21, 1122, "Surgery"}};
    }


}
