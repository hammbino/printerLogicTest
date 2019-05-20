package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
    private WebDriver driver;
    private By logo = By.id("logo");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //Returns if the Logo from the Home Page is displayed
    public boolean getHomePageLogo(){
        return driver.findElement(logo).isDisplayed();
    }
}
