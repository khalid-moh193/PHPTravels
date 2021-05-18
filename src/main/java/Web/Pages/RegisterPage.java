package Web.Pages;

import Web.Util.URLs;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends Page {
    public By firstNameField1 = By.xpath("//span[normalize-space()='First Name']");
    public By firstNameField = By.name("firstname");
    public By lastNameField = By.name("lastname");
    public By phoneNumberField = By.name("phone");
    public By emailField = By.name("email");
    public By passwordField = By.name("password");
    public By confirmPasswordField = By.name("confirmpassword");
    public By signupButton = By.cssSelector("button[class='signupbtn btn_full btn btn-success btn-block btn-lg']");



    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("-Navigate to register PHP travels ")
    public RegisterPage navigateToPHPTravels() {
        openURL(URLs.PHP_TRAVELS.getValue());
        return this;
    }

    @Step("-enter first name {0} ")
    public RegisterPage enterFirstName(String firstName) {
        sendText(firstNameField, firstName);
        return this;
    }

    @Step("-enter last name {0} ")
    public RegisterPage enterLastName(String lastName) {
        sendText(lastNameField, lastName);
        return this;
    }

    @Step("-enter phone number {0} ")
    public RegisterPage enterPhoneNumber(String phoneNumber) {
        sendText(phoneNumberField, phoneNumber);
        return this;
    }

    @Step("-enter email {0} ")
    public RegisterPage enterEmail(String email) {
        sendText(emailField, email);
        return this;
    }

    @Step("-enter password {0} ")
    public RegisterPage enterPassword(String password) {
        sendText(passwordField, password);
        return this;
    }

    @Step("-enter confirm password {0} ")
    public RegisterPage enterConfirmPassword(String confirmPassword) {
        sendText(confirmPasswordField, confirmPassword);
        return this;
    }

    @Step("-click sign up button ")
    public HomePage clickSignUpButton() {
        clickElement(signupButton);
        return new HomePage(driver);
    }



}
