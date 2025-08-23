package stepdefenition;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;

import static stepdefenition.Hook.driver;

public class CartStepsDefinition {
    CartPage cartPage = new CartPage(Hook.getDriver());

    @And("I add two products to the cart")
    public void iAddTwoProductsToTheCart() {
        // Write code here that turns the phrase above into concrete actions
        cartPage.addToCart();
       // throw new PendingException();
    }

    @And("I should be on the checkout information page")
    public void iShouldBeOnTheCheckoutInformationPage() {
        // Write code here that turns the phrase above into concrete actions
        cartPage.checkout();
        //throw new PendingException();
    }

    @Then("User fills in checkout information with {string}, {string}, and {string}")
    public void userFillsInCheckoutInformationWithAnd(String finame, String lsname, String pcode) {
        cartPage.checkoutInfo(finame, lsname, pcode);
       // throw new PendingException();
    }

    @And("User completes the purchase")
    public void userCompletesThePurchase() {
        // Write code here that turns the phrase above into concrete actions
        cartPage.finish();
        //throw new PendingException();
    }

    @Then("User should see the {string} page")
    public void userShouldSeeThePage(String expectedMessage) {
        // Write code here that turns the phrase above into concrete actions

        CartPage completePage = new CartPage(driver);
        Assert.assertTrue("Thank You message not displayed", completePage.isThankYouMessageDisplayed());
        //throw new PendingException();
    }
}
