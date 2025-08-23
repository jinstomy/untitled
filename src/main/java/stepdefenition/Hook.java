package stepdefenition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class Hook {
    public static WebDriver driver;
    @Before
    public void setUp() {
        System.out.println("Initializing WebDriver...");
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false); // Disables prompt to save passwords
        prefs.put("profile.password_manager_enabled", false); // Disables password manager
        prefs.put("profile.password_manager_leak_detection", false); // Disables "password found in data breach" warning
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--headless"); // Run in headless mode
        driver = new ChromeDriver(options);
    }
    public static WebDriver getDriver() {
        return driver;
    }

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
