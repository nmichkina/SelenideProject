package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {

  @Override
  public void onTestStart(ITestResult result) {
    String browserName = result.getTestContext().getCurrentXmlTest().getParameter("browserName");
    System.out.println("Browser name is: " + browserName);
    //System.out.println("OnTestStart");
  }

 /* @Override
  public void onTestStart(ITestResult iTestResult) {

  }*/

  @Override
  public void onTestSuccess(ITestResult result) {
    //System.out.println("OnTestSuccess");

  }

  @Override
  public void onTestFailure(ITestResult result) {
    /*File screenshotsFolder = new File(System.getProperty("user.dir") + "/screenshots");

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
    }*/
    //System.out.println("OnTestFailure");
  }

  @Override
  public void onTestSkipped(ITestResult result) {

  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

  }

  @Override
  public void onStart(ITestContext context) {
    //System.out.println("OnStart");
  }

  @Override
  public void onFinish(ITestContext context) {
    //System.out.println("OnTestFinish");
  }

  /*private File captureScreenshot() {
    return ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);*/

  //}
}
