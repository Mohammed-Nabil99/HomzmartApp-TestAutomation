package Base;
import Pages.HomePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTests {
    private AndroidDriver driver;
    protected HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator1");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("deviceName", "S24 Ultra");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("appPackage","com.homzmart");
        capabilities.setCapability("appActivity",".MainActivity");
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("resetKeyboard","true");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        homePage=new HomePage(driver);
      }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

        public void login() {
        var profilePage=homePage.clickProfile();
            var loginOrRegisterPage= profilePage.clickLogin();
            var loginPage=loginOrRegisterPage.setRegisteredEmail("testauto123@test.com");
           var myProfilePage = loginPage.setPassword("Test123!");
           myProfilePage.clickHome();
        }

    public void logout() {
        var myProfilePage=homePage.clickMyProfile();
        myProfilePage.clickLogout();
        myProfilePage.clickHome();
        }
    }