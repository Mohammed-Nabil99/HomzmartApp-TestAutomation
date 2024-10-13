package Pages;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductsPage {
    AndroidDriver driver;
    AndroidTouchAction action;
    private By addToCartBtn= By.xpath("//android.widget.TextView[@text='Add to Cart']");
    private By checkoutBtn= By.xpath("//android.widget.TextView[@text='Checkout']");
    private By firstProduct= By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[3]");
    private By secondProduct= By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.TextView[3]");
    private By thirdProduct= By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView[3]");
    private By firstProductTxt= By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[1]");
    private By filter=By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[5]");
    private By homeBtn= AppiumBy.accessibilityId("Home, tab, 1 of 4");

    public ProductsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCartBtn() throws InterruptedException {
        Thread.sleep(2500);
     waitAndClick(addToCartBtn);
    }
    public CartPage clickCheckoutBtn() throws InterruptedException {
        Thread.sleep(5000);
        waitAndClick(checkoutBtn);
        return new CartPage(driver);
    }

    public void clickSortBy() throws InterruptedException {
        Thread.sleep(4000);
        action= new AndroidTouchAction(driver);
        action.tap(PointOption.point(1203,295)).perform();
    }

    public HomePage clickHome() {
        waitAndClick(homeBtn);
        return new HomePage(driver);
    }

    public void clickGoBack() throws InterruptedException {
        Thread.sleep(3000);
        action= new AndroidTouchAction(driver);
        action.tap(PointOption.point(70,170)).perform();
    }

    public void clickApplySorting(){
        action= new AndroidTouchAction(driver);
        action.tap(PointOption.point(700,1540)).perform();
    }

    public void clickHighToLow() throws InterruptedException {
        Thread.sleep(1000);
        action= new AndroidTouchAction(driver);
        action.tap(PointOption.point(250,1340)).perform();
    }

    public void clickLowToHigh() throws InterruptedException {
        Thread.sleep(1000);
        action= new AndroidTouchAction(driver);
        action.tap(PointOption.point(250,1180)).perform();
    }

    public Long getFirstProductPrice() throws InterruptedException  {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String fProduct= wait.until(ExpectedConditions.visibilityOfElementLocated(firstProduct)).getText();
        fProduct = fProduct.replace(",","");
        Long first = Long.valueOf(fProduct.substring(0,fProduct.indexOf("."))).longValue();
        return first;
    }

    public Long getSecondProductPrice() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String sProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(secondProduct)).getText();
        sProduct = sProduct.replace(",","");
        Long second = Long.valueOf(sProduct.substring(0,sProduct.indexOf("."))).longValue();
        return second;
    }

    public Long getThirdProductPrice() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String thProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(thirdProduct)).getText();
        thProduct = thProduct.replace(",","");
        Long third =Long.valueOf(thProduct.substring(0,thProduct.indexOf("."))).longValue();
        return third;
    }

    public void clickFilter() throws InterruptedException {
        Thread.sleep(1000);
        action= new AndroidTouchAction(driver);
        action.tap(PointOption.point(1340,290)).perform();
    }

    public void clickFirstFilter() throws InterruptedException {
        Thread.sleep(2000);
        action= new AndroidTouchAction(driver);
        action.tap(PointOption.point(130,285)).perform();
    }

    public void clickApplyFilter() throws InterruptedException {
        Thread.sleep(2000);
        action= new AndroidTouchAction(driver);
        action.tap(PointOption.point(1000,2450)).perform();
    }

    public String getFirstProductTxt() throws InterruptedException  {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductTxt)).getText();
    }

    private void waitAndClick(By by) {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }
}
