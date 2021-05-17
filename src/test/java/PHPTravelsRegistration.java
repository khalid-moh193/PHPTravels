import Web.Pages.HomePage;
import Web.Pages.RegisterPage;
import Web.Util.fakeDataGeneration;
import com.github.javafaker.Faker;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("Registration Functionality")
@Feature("Registration Functionality")
public class PHPTravelsRegistration extends BaseTestClass {
    HomePage home;
    RegisterPage register;
    Faker fakeData = new Faker();
    //region Test Cases
    /*
        1-

     */
    //endregion


    @Test(priority = 1, description = "search by any keyword, then check that it's existed in the search result ")
    public void verifySearchFunctionality() throws InterruptedException {
        register = new RegisterPage(driver);
        register.navigateToPHPTravels()
                .enterFirstName(setFirstName())
                .enterLastName(setLastName())
                .enterPhoneNumber(setPhoneNumber())
                .enterEmail(generateEmail())
                .enterPassword("12345678")
                .enterConfirmPassword("12345678");

        Thread.sleep(3000);
        softAssert.assertAll();
    }




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
        return fakeData.name().firstName().concat("@").concat(fakeData.name().lastName().concat(".com"));
    }
}
