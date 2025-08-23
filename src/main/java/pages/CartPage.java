package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElements using @FindBy
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement firstProd;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement secondProd;

    @FindBy(css = "a[data-test='shopping-cart-link']")
    private WebElement shoppingCart;

    @FindBy(id = "checkout")
    private WebElement checkOut;

    @FindBy(id = "first-name")
    private WebElement fName;

    @FindBy(id = "last-name")
    private WebElement lName;

    @FindBy(id = "postal-code")
    private WebElement pCode;

    @FindBy(id = "continue")
    private WebElement continueBtn;

    @FindBy(id = "finish")
    private WebElement finishBtn;

    @FindBy(xpath = "//h2[text()='Thank you for your order!']")
    private WebElement thankYouMessage;

    // Actions with try-catch
    public void addToCart() {
        try {
            firstProd.click();
            secondProd.click();
        } catch (Exception e) {
            System.out.println("Failed to add products to cart: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void checkout() {
        try {
            System.out.println("Clicking shopping cart icon...");
            shoppingCart.click();

            // wait for the checkout button to be clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(checkOut));

            checkOut.click();
        } catch (Exception e) {
            System.out.println("Failed during checkout: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void checkoutInfo(String finame, String lsname, String postalCode) {
        try {
            fName.sendKeys(finame);
            lName.sendKeys(lsname);
            pCode.sendKeys(postalCode);
            continueBtn.click();
        } catch (Exception e) {
            System.out.println("Failed to enter checkout info: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void finish() {
        try {
            finishBtn.click();
        } catch (Exception e) {
            System.out.println("Failed to complete the order: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean isThankYouMessageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(thankYouMessage));
            return thankYouMessage.isDisplayed();
        } catch (Exception e) {
            System.out.println("Thank you message not displayed: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
