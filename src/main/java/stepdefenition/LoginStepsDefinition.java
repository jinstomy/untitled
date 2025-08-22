package stepdefenition;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductPage;

import java.util.List;

import static org.junit.Assert.*;

public class LoginStepsDefinition {
    WebDriver driver;
    LoginPage loginPage;

    @Given("User opens the website {string}")
    public void userOpensTheWebsite(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        this.driver = Hook.getDriver();

        // Open the URL
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
    }

    // Valid user case
    @When("I login with {string} and {string}")
    public void i_login_with_and(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("I should be redirected to the inventory page")
    public void i_should_be_redirected_to_the_inventory_page() {
        assertTrue(driver.getCurrentUrl().contains("inventory.html"));

    }

    //invalid user case
    @Then("I should see  {string}")
    public void iShouldSee(String expectedMessage) {
        // Write code here that turns the phrase above into concrete actions
        String actualMessage = loginPage.getErrorMessage();
        assertEquals(expectedMessage, actualMessage);

    }

}







