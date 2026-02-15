package com.commerza.pages;

import com.commerza.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ComparePage {
    
    private WebDriver driver;
    private ElementUtils elementUtils;
    
    private By comparisonTable = By.cssSelector(".table");
    private By compareItems = By.cssSelector(".card");
    private By compareContainer = By.id("compare-container");
    private By productSpecs = By.cssSelector(".table tbody tr");
    private By addToCartButtons = By.cssSelector(".product-btn-cart");
    private By removeButtons = By.cssSelector(".btn-remove-compare");
    private By emptyCompareMessage = By.cssSelector(".text-center");
    private By compareCount = By.id("compare-count");
    private By maxLimitMessage = By.id("customAlert");
    
    public ComparePage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
    }
    
    public void navigateToComparePage(String baseUrl) {
        driver.get(baseUrl + "compare.html");
    }
    
    public boolean isComparisonTableDisplayed() {
        return elementUtils.isDisplayed(comparisonTable);
    }
    
    public int getCompareItemCount() {
        return driver.findElements(compareItems).size();
    }
    
    public boolean areProductSpecsDisplayed() {
        return !driver.findElements(productSpecs).isEmpty();
    }
    
    public List<WebElement> getAddToCartButtons() {
        return driver.findElements(addToCartButtons);
    }
    
    public List<WebElement> getRemoveButtons() {
        return driver.findElements(removeButtons);
    }
    
    public void removeProduct(int index) {
        List<WebElement> removeButtonsList = getRemoveButtons();
        if (index < removeButtonsList.size()) {
            removeButtonsList.get(index).click();
        }
    }
    
    public boolean isEmptyCompareMessageDisplayed() {
        return elementUtils.isDisplayed(emptyCompareMessage);
    }
    
    public String getCompareCount() {
        return elementUtils.getText(compareCount);
    }
    
    public boolean isMaxLimitMessageDisplayed() {
        return elementUtils.isDisplayed(maxLimitMessage);
    }
    
    public String getMaxLimitMessage() {
        return elementUtils.getText(maxLimitMessage);
    }
}
