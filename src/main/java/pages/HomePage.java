package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class HomePage {


    WebDriver driver = null;//не передавать какой именно

    // драйвер открывать, это делается в before методе
    private String dashboardLink = "https://jira.hillel.it/secure/Dashboard.jspa";
    private By headerDetailsUserFullname = By.id("header-details-user-fullname");
    private String ticketLink = "https://jira.hillel.it/browse/WEBINAR-9060";

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

   /* public boolean userIconIsPresent(){*/
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds());
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id("header-details-user-fullname"))).isDisplayed();}*/

    public void userFullNameIsDisplayed(){ $(headerDetailsUserFullname).shouldBe(Condition.visible);}


    public void navigateTo(){
        open(dashboardLink);
    }

    public void jiraTicketPath(){

        $(headerDetailsUserFullname).shouldBe(Condition.visible);

        open(ticketLink);
    }



}
