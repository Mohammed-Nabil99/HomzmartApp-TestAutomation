package Pages;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CategoryPage {
    private AndroidDriver driver;
    private By furniture = By.xpath("//android.widget.TextView[@text='Furniture']");
    private By storage = By.xpath("//android.widget.TextView[@text='Storage']");
    private By homeDecor = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.View");
    private By officeFurniture = By.xpath("//android.widget.TextView[@text='Office Furniture']");
    private By Lighting = By.xpath("//android.widget.TextView[@text='Lighting']");
    private By fabricAndBedding= By.xpath("//android.widget.TextView[@text='Fabric & Bedding']");
    private By kitchenAndBathroom= By.xpath("//android.widget.TextView[@text='Kitchen & Bathroom']");
    private By appliances= By.xpath("//android.widget.TextView[@text='Appliances']");
    private By Sports= By.xpath("//android.widget.TextView[@text='Sports']");
    private By electronics= By.xpath("//android.widget.TextView[@text='Electronics']");
    private By outdoors= By.xpath("//android.widget.TextView[@text='Outdoors']");
    private By itemTxt=By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[1]");
    private By showResultsBtn=By.xpath("//android.widget.TextView[@text='Show Result']");
    private By homeBtn=AppiumBy.accessibilityId("Home, tab, 1 of 4");

    public CategoryPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public HomePage clickHome() {
        waitAndClick(homeBtn);
        return new HomePage(driver);
    }

    public void clickShowResults() throws InterruptedException {
        Thread.sleep(4000);
        waitAndClick(showResultsBtn);
    }

    public void clickFurniture() {
        waitAndClick(furniture);
    }

    public void clickStorage() {
        waitAndClick(storage);
    }

    public void clickOfficeFurniture() {
        waitAndClick(officeFurniture);
    }

    public void clickHomeDecor() {
        waitAndClick(homeDecor);
    }

    public void clickLighting() {
        waitAndClick(Lighting);
    }

    public void clickFabricAndBedding() {
        waitAndClick(fabricAndBedding);
    }

    public void clickKitchenAndBathroom() {
        waitAndClick(kitchenAndBathroom);
    }

    public void clickAppliances(){
        waitAndClick(appliances);
    }

    public void clickSports(){
        waitAndClick(Sports);
    }

    public void clickElectronics(){
        waitAndClick(electronics);
    }

    public void clickOutdoors(){
        waitAndClick(outdoors);
    }

    public ProductsPage clickItemTxt()
    {
        waitAndClick(itemTxt);
        return new ProductsPage(driver);
    }

    public String getItemTxt() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(itemTxt)).getText();
    }

    private void waitAndClick(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }
}