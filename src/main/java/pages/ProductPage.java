package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class ProductPage {
    private WebDriver driver;

    // Constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElements
    @FindBy(className = "inventory_item")
    private List<WebElement> productList;

    @FindBy(className = "product_sort_container")
    private WebElement sortDropdown;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> productPrices;

    // Actions
    public boolean areProductsVisible() {
        try {
            return productList.size() > 0;
        } catch (Exception e) {
            System.out.println(" Failed to checking if products are visible: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean isOnInventoryPage() {
        try {
            return driver.getCurrentUrl().contains("inventory.html");
        } catch (Exception e) {
            System.out.println(" Failed to checking inventory page URL: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public void selectSortOption(String optionText) {
        try {
            Select select = new Select(sortDropdown);
            select.selectByVisibleText(optionText);
        } catch (Exception e) {
            System.out.println("Failed to selecting sort option: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Double> getProductPrices() {
        List<Double> prices = new ArrayList<>();
        try {
            for (WebElement el : productPrices) {
                String priceText = el.getText().replace("$", "");
                prices.add(Double.parseDouble(priceText));
            }
        } catch (Exception e) {
            System.out.println("Failed to retrieving product prices: " + e.getMessage());
            e.printStackTrace();
        }
        return prices;
    }

    public boolean arePricesSortedLowToHigh() {
        try {
            List<Double> prices = getProductPrices();
            List<Double> sortedPrices = new ArrayList<>(prices);
            Collections.sort(sortedPrices);
            return prices.equals(sortedPrices);
        } catch (Exception e) {
            System.out.println("Failed to comparing sorted prices: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}

