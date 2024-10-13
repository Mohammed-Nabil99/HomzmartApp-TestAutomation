package SortAndFilter;
import Base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterTests extends BaseTests {

    @Test(priority = 1, alwaysRun = true)
    public void testFirstFilter() throws InterruptedException {
        var productsPage=homePage.search("home decor");
       productsPage.clickFilter();
       productsPage.clickFirstFilter();
       productsPage.clickApplyFilter();
       String Actualtxt= productsPage.getFirstProductTxt();
       String Expectedtxt="Wall";
       System.out.println(Actualtxt);
       Assert.assertTrue(Actualtxt.contains(Expectedtxt));
       productsPage.clickHome();
       productsPage.clickGoBack();
    }
}