package DeleteAccount;
import Base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteAccountTests extends BaseTests {

    @Test(priority = 1)
    public void testDeleteAccount() {
        var profilePage=homePage.clickProfile();
        var loginOrRegisterPage= profilePage.clickLogin();
        var loginPage=loginOrRegisterPage.setRegisteredEmail("testnew15422@gmail.com");
        var myProfilePage=loginPage.setPassword("Test123!");
        myProfilePage.clickDeleteAccount();
        myProfilePage.confirmDeleteAccount("Test123!");
       String actualTitle= myProfilePage.getProfilePageTitle();
       String expectedTitle="Welcome";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

}
