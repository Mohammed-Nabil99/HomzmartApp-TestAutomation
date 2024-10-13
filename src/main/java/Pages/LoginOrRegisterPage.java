package Pages;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginOrRegisterPage {
    private AndroidDriver driver;
    private By mail=By.className("android.widget.EditText");
    private By errMessageMail=By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.TextView");
    private By homeBtn= AppiumBy.accessibilityId("Home, tab, 1 of 4");

    public LoginOrRegisterPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public HomePage clickHome() {
        waitAndClick(homeBtn);
        return new HomePage(driver);
    }

    public LoginPage setRegisteredEmail(String email) {
        waitAndSend(mail,email);
        return new LoginPage(driver);
    }

    public String setInvalidEmail(String email) {
        waitAndSend(mail,email);
        return driver.findElement(errMessageMail).getText();
    }

    public SignUpPage setNewEmail(String email) {
        waitAndSend(mail,email);
        return new SignUpPage(driver);
    }

    private void waitAndSend(By by,String string)
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(string+"\n");

    }

    private void waitAndClick(By by)
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }
}
