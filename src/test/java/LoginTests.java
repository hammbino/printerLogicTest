import base.BaseTest;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTests extends BaseTest {

    /**
     * <h1>This tests a successful login</h1>
     * Login to application
     * Verify the user menu is being displayed
     */
    @Test
    public void successfulLogin(){
        String username = System.getProperty("username");
        String password = System.getProperty("password");
        page.tryLogin(username, password);
        Assert.assertTrue(driver.findElement(By.id("user-menu")).isDisplayed());
    }

    /**
     * <h1>This tests an attempt to login without a username</h1>
     * Login to application
     * Verify error message is displayed
     */
    @Test
    public void missingUsernameLogin(){
        String username = "";
        String password = System.getProperty("password");
        page.tryLogin(username, password);
        Assert.assertTrue(page.isErrorMessage1Displayed());
    }

    /**
     * <h1>This tests an attempt to login without a password</h1>
     * Login to application
     * Verify error message is displayed
     */
    @Test
    public void missingPasswordLogin(){
        String username = System.getProperty("username");
        String password = "";
        page.tryLogin(username, password);
        Assert.assertTrue(page.isErrorMessage1Displayed());
    }

    /**
     * <h1>This tests an attempt to login without a password</h1>
     * Login to application
     * Verify error message is displayed
     */
    @Test
    public void invalidPasswordLogin() {
        String username = System.getProperty("username");
        String password = "badPassword";
        page.tryLogin(username, password);
        Assert.assertTrue(page.isErrorMessage2Displayed());
    }

    /**
     * <h1>This tests clicking forgot password</h1>
     * Click forgot password link
     * Verify redirection to forgot password page
     */
    @Test
    public void forgotPassword() {
        page.clickForgotPassword();
        Assert.assertTrue(driver.findElement(By.id("password-modal")).isDisplayed());
    }

    /**
     * <h1>This tests clicking privacy policy</h1>
     * Click privacy policy link
     * Verify new tab opens to privacy policy
     */
    @Ignore
    @Test
    public void privacyPolicy() {
        page.clickPrivacy();
        String url = driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertEquals(url, "https://www.printerlogic.com/privacy-policy/");
        //Assert.assertTrue(driver.findElement(By.className("title mr2")).getText().equalsIgnoreCase("Privacy Policy"));
    }
}
