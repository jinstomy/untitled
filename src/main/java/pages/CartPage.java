package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;


    private By firstProd = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    private By secndProd = By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");
    private By shoppingCart =By.cssSelector("a[data-test='shopping-cart-link']");
    //private By shoppingCart =By.id("shopping_cart_container");
    private By checkOut= By.id("checkout");
    private By fName = By.xpath("//input[@id='first-name']");
    private By lName = By.xpath("//input[@id='last-name']");
    private By pCode = By.xpath("//input[@id='postal-code']");
    private By continueBtn =By.id("continue");
    private By finish = By.id("finish");
    private By thankYouMessage = By.xpath("//h2[text()='Thank you for your order!']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    //Action
    public void addToCart() {
        driver.findElement(firstProd).click();
        driver.findElement(secndProd).click();
    }
    public void checkout() {

        System.out.println("Waiting for shopping cart icon to be visible...");
        driver.findElement(shoppingCart).click();
        driver.findElement(checkOut).click();
    }
    public void checkoutInfo(String finame, String lsname, String pcode) {
        driver.findElement(fName).sendKeys(finame);
        driver.findElement(lName).sendKeys(lsname);
        driver.findElement(pCode).sendKeys(pcode);
        driver.findElement(continueBtn).click();
    }
    public void finish(){
        driver.findElement(finish).click();
    }
    public boolean isThankYouMessageDisplayed() {
        return driver.findElement(thankYouMessage).isDisplayed();
    }

}

