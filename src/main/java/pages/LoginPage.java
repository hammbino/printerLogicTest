package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.id("relogin_user");
    private By passwordField = By.id("relogin_password");
    private By loginBtn = By.id("admin-login-btn");
    private By errorMessage = By.id("logintext");
    private By forgotPasswordLink = By.id("forgot-password");
    private By privacyPolicyLink = By.cssSelector("#privacy-policy-container > a");

    private String errorMessage1 = "Please enter your username and password:";
    private String errorMessage2 = "Invalid username or password.";

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * This POM method will be exposed in test case to login in the application
     * @param username
     * @param password
     * @return boolean
     */
    public void tryLogin(String username, String password) {
        inputUsername(username);
        inputPassword(password);
        clickLogin();
    }

    //Sets username in textbox
    public void inputUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
        //WebDriverWait wait = new WebDriverWait(driver, 5);
            //wait.until(presenceOfElementLocated());
    }

    //Set password in textbox
    public void inputPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    //Click on login button
    public void clickLogin(){
        driver.findElement(loginBtn).click();
    }

    //Click forgot password link
    public void clickForgotPassword(){
        driver.findElement(forgotPasswordLink).click();
    }

    //Click privacy policy link
    public void clickPrivacy() {
        driver.findElement(privacyPolicyLink).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        //get window handlers as list
        List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(browserTabs.get(1));
        wait.until(ExpectedConditions.urlToBe("https://www.printerlogic.com/privacy-policy/"));
    }

    //Boolean for error message1 displayed
    public boolean isErrorMessage1Displayed(){
        String message = driver.findElement(errorMessage).getText();
        return driver.findElement(errorMessage).getText().equalsIgnoreCase(errorMessage1);
    }

    //Boolean for error message2 displayed
    public boolean isErrorMessage2Displayed(){
        WebDriverWait wait = new WebDriverWait(driver, 2);
        return wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(errorMessage), errorMessage2));
    }
}
