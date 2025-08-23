package stepdefenition;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import pages.CartPage;

import static stepdefenition.Hook.driver;

public class CartStepsDefinition {
    private static final Logger logger = LogManager.getLogger(CartStepsDefinition.class);
    CartPage cartPage = new CartPage(Hook.getDriver());

    @And("I add two products to the cart")
    public void iAddTwoProductsToTheCart() {
        logger.info("Adding two products to the cart.");
        cartPage.addToCart();
        logger.info("Products added to the cart successfully.");
    }

    @And("I should be on the checkout information page")
    public void iShouldBeOnTheCheckoutInformationPage() {
        logger.info("Navigating to the checkout information page.");
        cartPage.checkout();
        logger.info("Checkout information page loaded.");
    }

    @Then("User fills in checkout information with {string}, {string}, and {string}")
    public void userFillsInCheckoutInformationWithAnd(String finame, String lsname, String pcode) {
        logger.info(String.format("Filling checkout info: First Name = %s, Last Name = %s, Postal Code = %s", finame, lsname, pcode));
        cartPage.checkoutInfo(finame, lsname, pcode);
        logger.info("Checkout information submitted.");
    }

    @And("User completes the purchase")
    public void userCompletesThePurchase() {
        logger.info("Completing the purchase.");
        cartPage.finish();
        logger.info("Purchase completed.");
    }

    @Then("User should see the {string} page")
    public void userShouldSeeThePage(String expectedMessage) {

        logger.info("Verifying completion page with expected message: " + expectedMessage);
        CartPage completePage = new CartPage(driver);
        boolean isDisplayed = completePage.isThankYouMessageDisplayed();
        Assert.assertTrue("Thank You message not displayed", completePage.isThankYouMessageDisplayed());
        logger.info("Thank You message displayed: " + isDisplayed);
    }
}
