package Web.Util;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class fakeDataGeneration {

    Faker fakeData = new Faker();


    public String setFirstName(){
        return fakeData.name().firstName();
    }

    public String setLastName(){
        return fakeData.name().lastName();
    }

    public String setPhoneNumber(){
        return fakeData.phoneNumber().toString();
    }

    public String generateEmail(){
        return fakeData.name().firstName().concat("@").concat(fakeData.name().lastName().concat(".com"));
    }
}
