import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalTime;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class LoginTest {
    WebDriver driver = null;
    LoginPage loginPage = null;
    HomePage homePage = null;


    @Parameters("browserName")
    @BeforeMethod
    public void setUp(String browserName){
        //Configuration.browser = "chrome";
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
        newScreenshot();


    }
    public void newScreenshot() {
        File screenshotsFolder = new File(System.getProperty("user.dir") + "/screenshots");

        if (!screenshotsFolder.exists()) {
            screenshotsFolder.mkdir();
        }

        File screenshot = captureScreenshot();
        Path pathToScreenShot = Paths.get(screenshot.getPath());
        try {
            String screenshotName = screenshotsFolder + "/" + "Screenshot_" +
                    String.format(LocalTime.now().toString().replace(":", "-"), "2018-09-13 00-00")+ ".png";
            Files.copy(pathToScreenShot, Paths.get(screenshotName), StandardCopyOption.COPY_ATTRIBUTES);
        } catch (IOException e) {
            e.printStackTrace();
        }}


            private File captureScreenshot() {
                return ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);}



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


    @AfterMethod



    public void tearDown() { closeWebDriver();}
    }

