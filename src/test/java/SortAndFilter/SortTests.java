package SortAndFilter;
import Base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortTests extends BaseTests {
    @Test(priority = 1,alwaysRun = true)
    public void testSortHighToLow() throws InterruptedException {
        var productPage= homePage.search("sofas");
        productPage.clickSortBy();
        productPage.clickHighToLow();
        productPage.clickApplySorting();
        Long thirdProduct = productPage.getThirdProductPrice();
        Long secondProduct = productPage.getSecondProductPrice();
        System.out.println(secondProduct);
        System.out.println(thirdProduct);
        Assert.assertTrue(secondProduct > thirdProduct);
    }

    @Test(priority = 2)
    public void testSortLowToHigh() throws InterruptedException {
        var productPage= homePage.search("home decor");
        productPage.clickSortBy();
        productPage.clickLowToHigh();
        productPage.clickApplySorting();
        Long firstProduct = productPage.getFirstProductPrice();
        Long secondProduct = productPage.getSecondProductPrice();
        System.out.println(firstProduct);
        System.out.println(secondProduct);
        Assert.assertTrue(firstProduct < secondProduct);
    }
}