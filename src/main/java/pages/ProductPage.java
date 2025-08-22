package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ProductPage {
    private WebDriver driver;
    private By productList = By.className("inventory_item");
    private By sortDropdown = By.className("product_sort_container");
    private By productPrices = By.className("inventory_item_price");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean areProductsVisible() {
        return driver.findElements(productList).size() > 0;
    }

    public boolean isOnInventoryPage() {
        return driver.getCurrentUrl().contains("inventory.html");
    }

    public void selectSortOption(String optionText) {
        WebElement dropdown = driver.findElement(sortDropdown);
        Select select = new Select(dropdown);
        select.selectByVisibleText(optionText);
    }
    public List<Double> getProductPrices() {
        List<WebElement> priceElements = driver.findElements(productPrices);
        List<Double> prices = new ArrayList<>();
        for (WebElement el : priceElements) {
            String priceText = el.getText().replace("$", "");
            prices.add(Double.parseDouble(priceText));
        }
        return prices;
    }
    public boolean arePricesSortedLowToHigh() {
        List<Double> prices = getProductPrices();
        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);
        return prices.equals(sortedPrices);
    }

   /* public boolean arePricesSortedHighToLow(){
        List<Double> sortedPrices = getProductPrices();
        List<Double> highPrices = new ArrayList<>(sortedPrices);
        Collections.sort(highPrices);
        return sortedPrices.equals(highPrices);
    }*/
}
