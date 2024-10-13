package Logout;
import Base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTests extends BaseTests {
    @Test(priority = 1,alwaysRun = true)
    public void testLogout()
    {   var profilePage=homePage.clickProfile();
        var loginOrRegisterPage= profilePage.clickLogin();
        var loginPage=loginOrRegisterPage.setRegisteredEmail("testauto123@test.com");
        var myProfilePage = loginPage.setPassword("Test123!");
        myProfilePage.clickLogout();
        String actualTitle= myProfilePage.getProfilePageTitle();
        String expectedTitle="Welcome";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        myProfilePage.clickHome();
    }
}
