package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;


public class TicketPage {


    private WebDriver driver = null;//не передавать какой именно
    // драйвер открывать, это делается в before методе
    public TicketPage(WebDriver driver) {

        this.driver = driver;
    }

    private By commentFooterButton = By.id("footer-comment-button");
    private By commentField = By.id("comment");
    private By commentSubmitButton = By.id("issue-comment-add-submit");
    private By deleteCommentButton = By.xpath("//span[@class='icon-default aui-icon aui-icon-small aui-iconfont-delete']");
    private By createButton = By.id("create_link");
    private By projectField = By.id("project-field");
    private By issueTypeField = By.id("issuetype-field");
    private By summaryField = By.id("summary");
    private By reporterField = By.id("reporter-field");
    private By createTicketSubmitButton = By.id("create-issue-submit");
    private By createTicketSuccessPopup = By.className("aui-message-success");
    private By createTicketSuccessPopupTitle = By.xpath("//*[contains(text(), 'WEBINAR')]");
    private String ticketLink12148 = "https://jira.hillel.it/browse/WEBINAR-12148";
    private By commentDeleteSubmitButton = By.id("comment-delete-submit");
    private By successMessageDeleteComment = By.xpath("//div[@class='aui-message closeable aui-message-success aui-will-close']");
    private By issueDetailsButton = By.id("issuedetails");
    private String testedTicketNumber = "9060";





    public void navigateTo(){
        open(ticketLink12148);
    }
    public void clickFooterCommentButton(){
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5).getSeconds());
        wait.until(ExpectedConditions.presenceOfElementLocated(commentFooterButton)).isDisplayed();
        driver.findElement(commentFooterButton).click();*/
        $(commentFooterButton).shouldBe(Condition.visible);
        $(commentFooterButton).click();
    }
    public void enterComment(String comment){
        $(commentField).sendKeys(comment);
    }
    public void clickCommentSubmit(){
        $(commentSubmitButton).click();
    }
    public void newCommentPresent() {
        $(By.xpath("//*[contains(text(), 'My_comment')]")).shouldBe(Condition.visible);
    }
    public void clickDeleteCommentButton(){
        $(deleteCommentButton).click();
    }
    public void deleteCommentSubmitClick(){
        $(commentDeleteSubmitButton).shouldBe(Condition.visible);
        $(commentDeleteSubmitButton).click();
    }
    public void successMessageDeleteCommentPresent(){
        $(successMessageDeleteComment).shouldBe(Condition.visible);
    }
    public void createButtonClick(){
        $(createButton).click();
   // clickOnElementWithRetry(createButton, projectField, 3, 3);

    }
    private void clickOnElementWithRetry(By elementToBeClicked, By successCriteriaElement, int attempts, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds).getSeconds());

        for (int i = 0; i<attempts; i++){
            //driver.findElement(elementToBeClicked).click();
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(successCriteriaElement));
                break;

            } catch(TimeoutException e){
                wait.until(ExpectedConditions.elementToBeClickable(elementToBeClicked));
                driver.findElement(elementToBeClicked).click();
            }

        }

    }

    public void enterProjectName(String project){
        $(projectField).shouldBe(Condition.visible);
        $(projectField).clear();
        $(projectField).sendKeys(project);
        $(projectField).sendKeys(Keys.TAB);
    }
    public void enterIssueType(String issuetype){
        $(issueTypeField).shouldBe(Condition.visible);
        $(issueTypeField).clear();
        $(issueTypeField).sendKeys(issuetype);
        $(issueTypeField).sendKeys(Keys.TAB);
    }
    public void enterSummary(String summary){
        $(summaryField).shouldBe(Condition.visible);
        $(summaryField).sendKeys(summary);
    }
    public void enterReporter(String reporter){
        $(reporterField).shouldBe(Condition.visible);
        $(reporterField).clear();
        $(reporterField).sendKeys(reporter);
        $(reporterField).sendKeys(Keys.TAB);
    }
    public void clickCreateIssueSubmitButton(){
        $(createTicketSubmitButton).click();
    }
    public void createIssueSuccessMessagePresent(){
        $(createTicketSuccessPopup).shouldBe(Condition.visible);
    }
    public void popupTitleIsPresent(){
        $(createTicketSuccessPopupTitle).shouldBe(Condition.visible);
    }

    public void issueDetailsButtonisDisplayed(){
        $(issueDetailsButton).shouldBe(Condition.visible);
    }

    public void urlContainsTicketNumber(){
        url().contains(testedTicketNumber);
    }

}
