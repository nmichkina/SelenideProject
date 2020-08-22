import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverFactory;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class LoginTest {
    WebDriver driver = null;
    LoginPage loginPage = null;
    HomePage homePage = null;


    @Parameters("browserName")
    @BeforeMethod
    public void setUp(String browserName){
        Configuration.browser = "chrome";
        driver = WebDriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void loginTest(){
        homePage.navigateTo();
        loginPage.enterUserName("NataliiaMichkina");
        loginPage.enterPassword("NataliiaMichkina");
        loginPage.clickLogin();
        loginPage.userFullNameIsDisplayed();


        /*$(By.id("login-form-username")).setValue("NataliiaMichkina");
        $(By.id("login-form-password")).setValue("NataliiaMichkina");
        $("#login").click();
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        $(By.id("header-details-user-fullname")).shouldBe(Condition.visible);
        *//*Configuration.assertionMode = Configuration.AssertionMode.SOFT;
        Configuration.assertionMode = Configuration.AssertionMode.STRICT;*/
    }

    @AfterMethod

    public void tearDown() { closeWebDriver();
    }
}

