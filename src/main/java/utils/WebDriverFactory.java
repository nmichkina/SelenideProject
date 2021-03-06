package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {

  private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

  public static WebDriver getDriver() {
    return webDriver.get();
  }

  public void setWebDriver(WebDriver driver) {
    webDriver.set(driver);
  }

  public void closeDriver() {
    webDriver.get().quit();
  }

  public static void createInstance(String browserName) {

    //DesiredCapabilities capability = null;
    WebDriver driver = null;//

    if (browserName.toLowerCase().contains("firefox")) {
      WebDriverManager.firefoxdriver().setup(); // Аналог - System.setProperty("webdriver.chrome.driver","D:\List_of_Jar\chromedriver.exe"); и руками не кладем фафлик в папку
      driver = new FirefoxDriver();
    } else if (browserName.toLowerCase().contains("internet")) {
      WebDriverManager.iedriver().setup();
      driver = new InternetExplorerDriver();
    } else if (browserName.toLowerCase().contains("chrome")) {
      WebDriverManager.chromedriver().browserVersion("84.0.4147.125").setup();
      //WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
    } else {
      driver = new ChromeDriver();
    }


    driver.manage().window().maximize();

   /* // Simulate slow network speed - network throttle

    Map<String, String> map = new HashMap<>();
    map.put("offline", "false");
    map.put("latency", "10");
    map.put("download_throughput", "1024");
    map.put("upload_throughput", "1024");
    CommandExecutor executor = ((ChromeDriver) driver).getCommandExecutor();
    try {
      Response response = executor.execute(
          new Command(((ChromeDriver) driver).getSessionId(), "setNetworkConditions", ImmutableMap.of("network_conditions", ImmutableMap.copyOf(map)))
      );
    } catch (IOException e) {
      e.printStackTrace();
    }*/

    webDriver.set(driver);
  }

}
