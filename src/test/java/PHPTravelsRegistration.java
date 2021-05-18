import Web.Pages.HomePage;
import Web.Pages.RegisterPage;
import Web.Util.fakeDataGeneration;
import com.github.javafaker.Faker;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Epic("Registration Functionality")
@Feature("Registration Functionality")
public class PHPTravelsRegistration extends BaseTestClass {
    HomePage home;
    RegisterPage register;
    Faker fakeData = new Faker();
    String generatedPassword;
    //region Test Cases
    /*
        1-

     */
    //endregion


    @Test(priority = 1, description = "open registration page and enter correct data, then check that user is logged in successfully ")
    public void registrationFlow() {
        String firstName = setFirstName();
        String lastName = setLastName();

        register = new RegisterPage(driver);
        register.navigateToPHPTravels()
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .enterPhoneNumber(setPhoneNumber())
                .enterEmail(generateEmail())
                .enterPassword(generatePassword())
                .enterConfirmPassword(generatedPassword)
                .clickSignUpButton();

        home = new HomePage(driver);
        doAssertEqual(home.getAccountName(), "Hi, " + firstName + " " + lastName, "account name is not displayed as expected");
        doAssertEqual(home.getCurrentUrl().contains("account"), true, "URL is wrong, hence user is not registered successfully");

        //post condition
        home.clickOnAccountDropDownMenu()
                .clickOnLogout();
        softAssert.assertAll();

    }

    @Test(priority = 2, description = "enter different set of data {0}, {1}" ,dataProvider= "getData")
    public void enterDifferentWrongData(String firstName, String lastName){
        register = new RegisterPage(driver);
        register.navigateToPHPTravels()
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .enterPhoneNumber(setPhoneNumber())
                .enterEmail(generateEmail())
                .enterPassword(generatePassword())
                .enterConfirmPassword(generatedPassword)
                .clickSignUpButton();

        home = new HomePage(driver);
        doAssertEqual(home.getCurrentUrl().contains("register"), true, "URL is wrong, hence user is not registered successfully");
        softAssert.assertAll();
    }



    /*************** supportive functions ******************/

    private String setFirstName(){
        return fakeData.name().firstName();
    }

    private String setLastName(){
        return fakeData.name().lastName();
    }

    private String setPhoneNumber(){
        return fakeData.phoneNumber().toString();
    }

    private String generateEmail(){
        return setFirstName().concat(setLastName()).concat("@gmail.com");
    }

    public String generatePassword() {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String character = "!@#$%^&*-_=+|;:,<.>/?";
        String numbers = "123456789";
        generatedPassword = RandomStringUtils.random( 15, upper + character + numbers);
        System.out.println(generatedPassword);
        return generatedPassword;
    }

    @DataProvider
    public Object[][] getData(){
        //1st combination: T First Name, T Last Name
        //2nd combination: T First Name, f Last Name
        //3rd combination: f First Name, f Last Name
        Object [][] data = new Object[3][2];
        //[no. of combinations] [no. of values -First Name and Last Name-]
        data[0][0] = "Abc"; data[0][1] = "";
        data[1][0] = "   "; data[1][1] = "Abc";
        data[2][0] = "khalid"; data[2][1] = "محمد";
        return data;
    }

}
