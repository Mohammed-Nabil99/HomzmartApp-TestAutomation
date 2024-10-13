package Login;
import Base.BaseTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {
    SoftAssert softAssert = new SoftAssert();
    @Test(priority = 1,alwaysRun = true)
    public void testValidLogin()
    {var profilePage=homePage.clickProfile();
         var loginOrRegisterPage= profilePage.clickLogin();
         var loginPage=loginOrRegisterPage.setRegisteredEmail("testauto123@test.com");
         loginPage.setPassword("Test123!");
         String myName="John";
         String displayedName=loginPage.getUserName();
         softAssert.assertTrue(displayedName.contains(myName));
         logout();
         loginPage.clickHome();
    }

    @Test(priority = 2)
    public void testInValidPassword() {
        var profilePage=homePage.clickProfile();
        var loginOrRegisterPage= profilePage.clickLogin();
        var loginPage=loginOrRegisterPage.setRegisteredEmail("testauto123@test.com");
        loginPage.setPassword("Test123");
        String errorMessage=loginPage.getAlert();
        String expectedMessage="Invalid Email or Password";
        assertTrue(errorMessage.contains(expectedMessage),"Messages not matched");
    }

    @DataProvider(name ="invalidMailForms")
    public Object[] mails(){
        return new Object[][] {{"test@gmail"}, {"test@.com"},{"testgmail.com"},{"test@"}};
    }

    @Test(priority = 3,dataProvider = "invalidMailForms")
    public void testInValidMail(String invalidMail) {
        var profilePage=homePage.clickProfile();
        var loginOrRegisterPage= profilePage.clickLogin();
        String actualMsg=loginOrRegisterPage.setInvalidEmail(invalidMail);
        String expectedMsg="please enter your email";
        assertTrue(actualMsg.contains(expectedMsg),"Messages not matched");
    }
}