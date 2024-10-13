package Cart;
import Base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTests {

    @Test(priority = 1,alwaysRun = true)
    public void testAddItemToCart() throws InterruptedException {
        var categoryPage=  homePage.clickCategory();
        categoryPage.clickHomeDecor();
        categoryPage.clickShowResults();
        String ItemTxt= categoryPage.getItemTxt();
        var productPage= categoryPage.clickItemTxt();
        productPage.clickAddToCartBtn();
        var cartPage=  productPage.clickCheckoutBtn();
        String cartItem= cartPage.getCartItemTxt();
        Assert.assertEquals(ItemTxt,cartItem);
        cartPage.clickHome();
    }

    @Test(priority = 4)
    public void testDeleteItemFromCart() throws InterruptedException {
        var categoryPage=  homePage.clickCategory();
        categoryPage.clickHomeDecor();
        categoryPage.clickShowResults();
        var productPage= categoryPage.clickItemTxt();
        productPage.clickAddToCartBtn();
        var cartPage=  productPage.clickCheckoutBtn();
        cartPage.clickDeleteItem();
        String cartStatus= cartPage.getCartMsg();
        System.out.println(cartStatus);
        Assert.assertTrue(cartStatus.contains("You haven’t added"));
        cartPage.clickHome();
    }


    @Test(priority = 3,alwaysRun = true)
    public void testCheckout() throws InterruptedException {
        login();
        var categoryPage=  homePage.clickCategory();
        categoryPage.clickHomeDecor();
        categoryPage.clickShowResults();
        var productPage= categoryPage.clickItemTxt();
        productPage.clickAddToCartBtn();
        var cartPage=  productPage.clickCheckoutBtn();
        cartPage.clickContinue();
        cartPage.clickContinue();
        cartPage.clickCash();
        Boolean PayBtnStatus= cartPage.isEnabledPayNowBtn();
        System.out.println(PayBtnStatus);
        Assert.assertTrue(PayBtnStatus);
        logout();
    }

    @Test(priority = 2,alwaysRun = true )
    public void testAddValidPromoCode() throws InterruptedException {
        var categoryPage=  homePage.clickCategory();
        categoryPage.clickHomeDecor();
        categoryPage.clickShowResults();
        var productPage= categoryPage.clickItemTxt();
        productPage.clickAddToCartBtn();
        var cartPage=  productPage.clickCheckoutBtn();
        String validPromo ="ax1911";
        cartPage.setPromoCode(validPromo);
        cartPage.clickApplyPromo();
        String PromoStatus= cartPage.getPromoCodeStatus();
        System.out.println(PromoStatus);
        Assert.assertTrue(PromoStatus.contains("You Saved"));
        cartPage.clickRemovePromo();
        cartPage.clickHome();
    }
}
