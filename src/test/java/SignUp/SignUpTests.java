package SignUp;
import Base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class SignUpTests extends BaseTests {
    @Test(priority = 1,alwaysRun = true)
    public void testValidRegister(){
        var profilePage=homePage.clickProfile();
        var loginOrRegisterPage=profilePage.clickLogin();
        var signUpPage=loginOrRegisterPage.setNewEmail("testnew2052@gmail.com");
        String FirstName ="Adam";
        signUpPage.setFirstName(FirstName);
        signUpPage.setMobileNumber("10001234567");
        String pass="Test123!";
        signUpPage.setPassword(pass);
        signUpPage.setConfirmPassword(pass);
        String displayedName=signUpPage.getUserName();
        assertTrue(displayedName.contains(FirstName));
        logout();
    }

    @Test(priority = 2)
    public void testInValidRegister(){
        var profilePage=homePage.clickProfile();
        var loginOrRegisterPage=profilePage.clickLogin();
        var signUpPage=loginOrRegisterPage.setNewEmail("testnew15422@gmai.com");
        String FirstName ="Adam";
        signUpPage.setFirstName(FirstName);
        signUpPage.setMobileNumber("1003215488");
        String pass="Test";
        signUpPage.setPassword(pass);
        signUpPage.setConfirmPassword(pass);
        String errMessage=signUpPage.getErrMsg();
        assertTrue(errMessage.contains("too short"));
    }
}