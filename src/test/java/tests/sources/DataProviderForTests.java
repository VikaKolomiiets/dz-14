package tests.sources;

import org.testng.annotations.DataProvider;

public class DataProviderForTests {
//String firstName, String lastName, String email, Integer age, Double salary, String department

    @DataProvider(name ="full-data-registration-form" )
    public static Object[][] setUpAllDataForRegistrationFormPositive(){
        return new Object[][]{
                {"Agnesa", "Wolf", "agwf@gmail.com", 58, 5000, "Medicine"},
                {"Boris", "Red", "boris@gmail.com", 60, 8000, "IT"}};
    }


}
