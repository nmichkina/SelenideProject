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

public class ViewJIRATicket {

  WebDriver driver = null;
  HomePage homePage = null;
  LoginPage loginPage = null;
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
  public void successfulLoginTest() {
    homePage.navigateTo();
    loginPage.enterUserName("NataliiaMichkina");
    loginPage.enterPassword("NataliiaMichkina");
    loginPage.clickLogin();

    homePage.jiraTicketPath();
    ticketPage.issueDetailsButtonisDisplayed();
    ticketPage.urlContainsTicketNumber();
    ticketPage.urlContainsTicketNumber();

    /*assertTrue(driver.findElement(By.id("issuedetails")).isDisplayed());
    assertTrue(driver.getCurrentUrl().contains("9060"));*/

  }

  @AfterMethod
  public void tearDown() {
    closeWebDriver();
  }
}
