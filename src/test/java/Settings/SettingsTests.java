package Settings;
import Base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SettingsTests extends BaseTests {
    @Test(priority = 1,alwaysRun = true)
    public void testChangeCountry() throws InterruptedException {
        var profilePage = homePage.clickProfile();
       profilePage.clickSettings();
       profilePage.clickCountry();
       profilePage.clickEgypt();
       Thread.sleep(10000);
       var p=homePage.clickProfile();
       p.clickSettings();
       String countryName=p.getCountryName();
       String expectedCountry="Egypt";
       Assert.assertTrue(countryName.contains(expectedCountry));
       p.clickHome();
    }

    @Test(priority = 2)
    public void testChangeLanguage() throws InterruptedException {
        var profilePage = homePage.clickProfile();
        profilePage.clickSettings();
        profilePage.clickLanguage();
        profilePage.clickArabic();
        Thread.sleep(10000);
       String actualTxt = homePage.getTextHome();
        System.out.println(actualTxt);
        String expectedTxt="تسوق";
        Assert.assertTrue(actualTxt.contains(expectedTxt));
    }
}