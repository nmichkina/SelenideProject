import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.TicketPage;
import utils.WebDriverFactory;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class CreateIssue {

  WebDriver driver = null;
  LoginPage loginPage = null;
  HomePage homePage = null;
  TicketPage ticketPage = null;

  @BeforeMethod
  public void setUp() {
    // любой Java Code
    Configuration.browser = "chrome";
    driver = WebDriverFactory.getDriver();
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
    ticketPage = new TicketPage(driver);
  }


  @Test
  public void createIssue() {
    homePage.navigateTo();
    loginPage.enterUserName("NataliiaMichkina");
    loginPage.enterPassword("NataliiaMichkina");
    loginPage.clickLogin();
    homePage.userFullNameIsDisplayed();

    ticketPage.createButtonClick();

    ticketPage.enterProjectName("Webinar (WEBINAR)");

    ticketPage.enterIssueType("task");

    ticketPage.enterSummary("Some summary");
    ticketPage.enterReporter("NataliiaMichkina");
    ticketPage.clickCreateIssueSubmitButton();

    ticketPage.createIssueSuccessMessagePresent();
    ticketPage.createIssueSuccessMessagePresent();
    ticketPage.popupTitleIsPresent();
    ticketPage.popupTitleIsPresent();
  }

  @AfterMethod

  public void tearDown() { closeWebDriver();
  }
}
