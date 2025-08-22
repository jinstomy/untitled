package stepdefenition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook {
    public static WebDriver driver;
    @Before
    public void setUp() {
        System.out.println("Initializing WebDriver...");
        WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
    }
    public static WebDriver getDriver() {
        return driver;
    }
  //  @After
  //  public void tearDown() {


   //       driver.quit();
   // }
   @After
    public void tearDown(Scenario scenario) {
       WebDriver driver = Hook.getDriver();

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Screenshot");
        }
       driver.quit();

    }


}
