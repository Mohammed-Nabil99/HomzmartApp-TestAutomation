package Pages;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SignUpPage {
    private AndroidDriver driver;
    private By fName=By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.EditText");
    private By mobNumber=By.xpath("//android.widget.EditText[@text='1xxxxxxxxx']");
    private By pass=By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[5]/android.widget.EditText");
    private By confPassword=By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[6]/android.widget.EditText");
    private By userName=By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[2]");
    private By errMsgPass=By.xpath("//android.widget.TextView[@text='Password is too short.']");
    private By homeBtn= AppiumBy.accessibilityId("Home, tab, 1 of 4");

    public SignUpPage(AndroidDriver driver) {
        this.driver=driver;
    }

    public void setFirstName(String firstName) {
        waitAndSend(fName,firstName);
    }

    public void setMobileNumber(String MobileNumber) {
        waitAndSend(mobNumber,MobileNumber);
    }

    public void setPassword(String Password) {
        waitAndSend(pass,Password);
    }

    public HomePage clickHome() {
        waitAndClick(homeBtn);
        return new HomePage(driver);
    }

    public void setConfirmPassword(String ConfirmPassword) {
        waitAndSend(confPassword,ConfirmPassword);
    }

    public String getUserName()
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(70));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userName)).getText();

    }

    public String getErrMsg() {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        String error=wait.until(ExpectedConditions.visibilityOfElementLocated(errMsgPass)).getText();
        return error;
    }

    private void waitAndSend(By by,String string) {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(string+"\n");
    }

    private void waitAndClick(By by) {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }
}
