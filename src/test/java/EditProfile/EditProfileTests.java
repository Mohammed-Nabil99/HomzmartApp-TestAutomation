package EditProfile;
import Base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditProfileTests extends BaseTests {

    @Test(priority =1,alwaysRun = true)
    public void testEditFirstName() throws InterruptedException {
        login();
        var myProfilePage=homePage.clickMyProfile();
        var editProfile= myProfilePage.clickEditProfile();
        String fName="karim";
        editProfile.editFirstName(fName);
         myProfilePage= editProfile.clickSubmit();
        Thread.sleep(10000);
        String displayedName=myProfilePage.getDisplayedName();
        Assert.assertTrue(displayedName.contains(fName));
        logout();
    }

    @Test(priority = 2)
    public void testEditLastName() throws InterruptedException {
        login();
        var myProfilePage=homePage.clickMyProfile();
        var editProfile= myProfilePage.clickEditProfile();
        String lName="karim";
        editProfile.editLastName(lName);
        myProfilePage= editProfile.clickSubmit();
        Thread.sleep(10000);
        String displayedName=myProfilePage.getDisplayedName();
        Assert.assertTrue(displayedName.contains(lName));
        logout();
    }

    @Test(priority = 3)
    public void testEditMobile() throws InterruptedException {
        login();
        var myProfilePage=homePage.clickMyProfile();
        var editProfile1= myProfilePage.clickEditProfile();
        String num="1000808090";
        editProfile1.editMobile(num);
        myProfilePage= editProfile1.clickSubmit();
        Thread.sleep(10000);
        var editProfile2= myProfilePage.clickEditProfile();
        String displayedNum=editProfile2.getMobile();
        Assert.assertTrue(displayedNum.contains(num));
        logout();
    }
}
