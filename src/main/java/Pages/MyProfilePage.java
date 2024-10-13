package Pages;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MyProfilePage {
    AndroidDriver driver;
    private By deleteAcc= By.xpath("    //android.widget.TextView[@text='Delete Account']");
    private By passField= By.xpath("//android.widget.EditText[@text='*******']");
    private By agreeCheckBox= By.xpath("//android.widget.CheckBox");
    private By confirmDeletionBtn= By.xpath("//android.widget.TextView[@text='Confirm Deletion']");
    private By profileTitle= By.xpath("//android.widget.TextView[@text='Welcome To Homzmart']");
    private By logout=By.xpath("//android.widget.TextView[@text='Logout']");
    private By settings = By.xpath("//android.widget.TextView[@text='Settings']");
    private By country= By.xpath("//android.widget.TextView[@text='Country']");
    private By saudiArabia=By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[4]") ;
    private By egypt=By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[5]");
    private By selectedCountry=By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView[2]");
    private By editProfile=By.xpath("//android.widget.TextView[@text='Edit Profile']");
    private By myProfileTxt=By.xpath("//android.widget.TextView[@text='My Profile']");
    private By userName=By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[2]");
    private By homeBtn=AppiumBy.accessibilityId("Home, tab, 1 of 4");

    public MyProfilePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void clickLogout(){
        waitAndClick(logout);
    }

    public void clickDeleteAccount() {
        waitAndClick(deleteAcc);
    }

    public EditProfilePage clickEditProfile() {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(myProfileTxt));
        waitAndClick(editProfile);
        return new EditProfilePage(driver);
    }

    public void clickSettings() {
        waitAndClick(settings);
    }

    public void clickCountry() {
        waitAndClick(country);
    }

    public void clickSaudiArabia() {
        waitAndClick(saudiArabia);
    }

    public void clickEgypt() {
        waitAndClick(egypt);
    }

    public HomePage clickHome() {
        waitAndClick(homeBtn);
        return new HomePage(driver);
    }

    public String getCountryName(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(selectedCountry)).getText();
    }

    public void confirmDeleteAccount(String password) {
        waitAndSend(passField,password);
        driver.findElement(agreeCheckBox).click();
        waitAndClick(confirmDeletionBtn);
    }

    public String getProfilePageTitle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(profileTitle)).getText();
    }

    public String getDisplayedName(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userName)).getText();
    }

    private void waitAndClick(By by) {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }

    private void waitAndSend(By by,String string) {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(string+"\n");
    }
}
