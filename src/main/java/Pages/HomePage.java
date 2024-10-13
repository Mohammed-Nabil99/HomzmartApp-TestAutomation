package Pages;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private AndroidDriver driver;
    AndroidTouchAction action;
    private By profile =AppiumBy.accessibilityId("Profile, tab, 4 of 4");
    private By cart=AppiumBy.accessibilityId("Cart, tab, 3 of 4");
    private By langTitle=By.xpath("//android.widget.TextView[@text='تسوق حسب المجموعة']");
    private By category=AppiumBy.accessibilityId("Categories, tab, 2 of 4");
    private By search=By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]");
    private By searchTxtArea=By.className("android.widget.EditText");
    private By homeBtn=AppiumBy.accessibilityId("Home, tab, 1 of 4");

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public ProfilePage clickProfile() {
        waitAndClick(profile);
        return new ProfilePage(driver);
    }

    public CartPage clickCart() {
        waitAndClick(cart);
        return new CartPage(driver);
    }

    public HomePage clickHome() {
        waitAndClick(homeBtn);
        return new HomePage(driver);
    }

    public MyProfilePage clickMyProfile() {
        waitAndClick(profile);
        return new MyProfilePage(driver);
    }

    public CategoryPage clickCategory() {
        waitAndClick(category);
        return new CategoryPage(driver);
    }

    public void clickOnBlank(){

        action= new AndroidTouchAction(driver);
        action.tap(PointOption.point(500,300)).perform();
    }

    public String getTextHome(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(langTitle)).getText();
    }

    public ProductsPage search(String text) throws InterruptedException {
        Thread.sleep(200);
        waitAndClick(search);
        waitAndSend(searchTxtArea,text);
        action = new AndroidTouchAction(driver);
        action.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).tap(PointOption.point(250,830))
                .tap(PointOption.point(250,830)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).perform();
        return new ProductsPage(driver);
    }

    private void waitAndClick(By by)
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }

    private void waitAndSend(By by,String string)
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(string);
    }
}
