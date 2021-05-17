package Web.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {
    public By searchField = By.name("q");



    public HomePage(WebDriver driver) {
        super(driver);
    }



}
