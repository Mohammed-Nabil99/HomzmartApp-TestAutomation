package Pages;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private AndroidDriver driver;
    private By pass=By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText");
    private By userName=By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[2]");
    private By passErrMessage=By.xpath("    //android.view.ViewGroup[@resource-id=\"toastAnimatedContainer\"]/android.view.ViewGroup/android.widget.TextView[2]");
    private By homeBtn= AppiumBy.accessibilityId("Home, tab, 1 of 4");

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public HomePage clickHome() {
        waitAndClick(homeBtn);
        return new HomePage(driver);
    }

    public MyProfilePage setPassword(String password) {
        waitAndSend(pass,password);
        return new MyProfilePage(driver);
    }

    public String getUserName()
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userName)).getText();

    }

    public String getAlert(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(35));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passErrMessage)).getText();
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
