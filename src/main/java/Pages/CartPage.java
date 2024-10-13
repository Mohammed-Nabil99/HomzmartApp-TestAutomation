package Pages;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {
    AndroidDriver driver;
    private By continueBtn= By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup");
    private By cashBtn= By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup");
    private By payNowBtn= By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup");
    private By cartItemTx= By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]");
    private By deleteItemBtn=By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]");
    private By emptyCartMsg=By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView");
    private By promoCodeField=By.xpath("//android.widget.EditText[@text='Promo code']");
    private By applyPromo=By.xpath("//android.widget.TextView[@text='Apply']");
    private By removePromo=By.xpath("//android.widget.TextView[@text='Remove']");
    private By promoMsg=By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[2]");
    private By homeBtn=AppiumBy.accessibilityId("Home, tab, 1 of 4");

    public CartPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public HomePage clickHome() {
        waitAndClick(homeBtn);
        return new HomePage(driver);
    }

    public void clickContinue() {
        waitAndClick(continueBtn);
    }

    public void clickCash() {
        waitAndClick(cashBtn);
    }

    public void clickDeleteItem() {
        waitAndClick(deleteItemBtn);
    }

    public String getCartMsg() throws InterruptedException {
        Thread.sleep(6000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMsg)).getText();
    }

    public String getCartAlert() throws InterruptedException {
        Thread.sleep(2000);

        return driver.switchTo().alert().getText();
    }

    public String getCartItemTxt()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemTx)).getText();
    }

    public Boolean isEnabledPayNowBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
       return wait.until(ExpectedConditions.elementToBeClickable(payNowBtn)).isEnabled();
    }


    public void setPromoCode(String promoCode) {
        waitAndSend(promoCodeField,promoCode);
    }

    public void clickApplyPromo(){
        waitAndClick(applyPromo);

    }

    public void clickRemovePromo(){
        waitAndClick(removePromo);
    }

    public String getPromoCodeStatus(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(promoMsg)).getText();

    }

    private void waitAndClick(By by)
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();

    }

    private void waitAndSend(By by,String string)
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(string+"\n");

    }
}
