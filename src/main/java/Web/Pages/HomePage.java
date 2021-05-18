package Web.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public By dropDownMenu = By.xpath("//div[@class='dropdown dropdown-login dropdown-tab']/a");
    public By accountName = By.className("text-align-left");
    public By logout = By.xpath("//a[normalize-space()='Logout']");


    @Step("get account name text")
    public String getAccountName(){
        return getElementText(accountName);
    }

    @Step("- click on logout button")
    public HomePage clickOnAccountDropDownMenu(){
        clickElement(dropDownMenu);
        return this;
    }

    @Step("- click on logout button")
    public RegisterPage clickOnLogout(){
        clickElement(logout);
        return new RegisterPage(driver);
    }
}
