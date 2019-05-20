package base;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.HomePage;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest {


    protected static WebDriver driver;
    protected static LoginPage page;

    @Before
    public void setUp() {
        Properties props = System.getProperties();
        try {
            props.load(new FileInputStream(new File("resources/test.properties")));
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

        driver = new ChromeDriver();
        driver.get(System.getProperty("login.url"));
        page = new LoginPage(driver);
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
