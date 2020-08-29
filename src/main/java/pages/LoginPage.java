package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;


public class LoginPage {


    private WebDriver driver = null;//не передавать какой именно
    // драйвер открывать, это делается в before методе

    private By userNameInput = By.id("login-form-username");
    private By passwordInput = By.id("login-form-password");
    private By loginButton = By.id("login");
    private By headerUserFullname = By.id("header-details-user-fullname");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterUserName(String name){
        $(userNameInput).setValue(name);
    }
    public void enterPassword(String password){
        $(passwordInput).setValue(password);
    }
    public void clickLogin(){
        $(loginButton).click();
    }
    /*public boolean errorMessageIsPresent(String message){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds());
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'"+message+"')]"))).isDisplayed();
        //return driver.findElement(By.xpath("//p[contains(text(),'"+message+"')]")).isDisplayed();*/
    public void userFullNameIsDisplayed(){ $(headerUserFullname).shouldBe(Condition.exist);}


    }


