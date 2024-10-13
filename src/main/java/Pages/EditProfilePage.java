package Pages;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class EditProfilePage {
    private AndroidDriver driver;
    private By fName=By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText");
    private By lName=By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText");
    private By num=By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.EditText");
    private By email=By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]");
    private By submitBtn=By.xpath("//android.widget.TextView[@text='Submit']");
    private By homeBtn= AppiumBy.accessibilityId("Home, tab, 1 of 4");

    public EditProfilePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public HomePage clickHome() {
        waitAndClick(homeBtn);
        return new HomePage(driver);
    }

    public void editFirstName(String FirstName) {
        waitAndSend(fName, FirstName);

    }

    public void editLastName(String LastName) {
        waitAndSend(lName, LastName);
    }

    public void editEmail(String Email) {
        waitAndSend(email, Email);
    }

    public void editMobile(String Mobile) {
        waitAndSend(num, Mobile);
    }

    public String getFirstName()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
       return  wait.until(ExpectedConditions.visibilityOfElementLocated(fName)).getText();
    }

    public String getLastName(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(lName)).getText();
    }

    public String getEmail(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(email)).getText();
    }

    public String getMobile(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(num)).getText();
    }

    public MyProfilePage clickSubmit() {
     waitAndClick(submitBtn);
     driver.findElement(submitBtn).click();
     return new MyProfilePage(driver);
    }

    private void waitAndSend(By by,String string)
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).clear();
        driver.findElement(by).sendKeys(string);
    }

    private void waitAndClick(By by)
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }
}
