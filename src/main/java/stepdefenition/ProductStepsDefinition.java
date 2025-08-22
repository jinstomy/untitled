package stepdefenition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ProductPage;
import static org.junit.Assert.assertTrue;

public class ProductStepsDefinition {


    WebDriver driver = Hook.getDriver();
    ProductPage productPage = new ProductPage(driver);

    @Then("I should see a list of products")
    public void i_should_see_a_list_of_products() {
        assertTrue("No products are visible.", productPage.areProductsVisible());
    }

    @And("I sort the products by {string}")
    public void i_sort_the_products_by(String option) {
        productPage.selectSortOption(option);
    }

    @Then("I should see the products sorted in ascending order of price")
    public void iShouldSeeTheProductsSortedInAscendingOrderOfPrice() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("Products are not sorted by price (low to high).",
                productPage.arePricesSortedLowToHigh());
    }
}




