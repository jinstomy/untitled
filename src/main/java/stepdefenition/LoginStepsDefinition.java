package stepdefenition;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductPage;
import utility.ConfigReader;

import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;



import static org.junit.Assert.*;

public class LoginStepsDefinition {
    private static final Logger logger = LogManager.getLogger(LoginStepsDefinition.class);
    WebDriver driver;
    LoginPage loginPage;

   @Given("User opens the application")
   public void userOpensTheApplication() {
       this.driver = Hook.getDriver();

       // Open the URL
       driver.manage().window().maximize();
       String url = ConfigReader.getProperty("base.url");
       logger.info("Opening the application URL: " + url);
       driver.get(url);
       loginPage = new LoginPage(driver);
   }

    // Valid user case
    @When("I login with {string} and {string}")
    public void i_login_with_and(String username, String password) {
        logger.info("Logging in with Username: " + username + " and Password: " + password);
        loginPage.login(username, password);
    }

    @Then("I should be redirected to the inventory page")
    public void i_should_be_redirected_to_the_inventory_page() {
        logger.info("Checking if user is redirected to inventory page...");
        assertTrue(driver.getCurrentUrl().contains("inventory.html"));
        logger.info("Redirection successful.");

    }

    //invalid user name and password
    @Then("I should see  {string}")
    public void iShouldSee(String expectedMessage) {
        logger.info("Validating error message: Expected = " + expectedMessage);
        // Write code here that turns the phrase above into concrete actions
        String actualMessage = loginPage.getErrorMessage();
        assertEquals(expectedMessage, actualMessage);
        logger.info("Error message validated successfully.");

    }

    @Given(": i clicked Login button without enter username and password")
    public void iClickedLoginButtonWithoutEnterUsernameAndPassword() {
        logger.warn("Clicking login button without entering credentials.");
       loginPage.clickLogin();
    }

    @Then(": i should see  {string}")
    public void i_ShouldSee(String message) {
        String actualMessage = loginPage.noLoginErrorMessage();
        assertEquals(message, actualMessage);
    }
    //valid username and invalid password



}







