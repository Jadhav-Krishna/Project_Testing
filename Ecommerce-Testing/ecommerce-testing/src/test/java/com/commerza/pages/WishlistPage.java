package com.commerza.pages;

import com.commerza.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WishlistPage {
    
    private WebDriver driver;
    private ElementUtils elementUtils;
    
    private By wishlistItems = By.cssSelector(".card");
    private By wishlistContainer = By.id("wishlist-container");
    private By removeButtons = By.cssSelector(".btn-remove-wishlist");
    private By addToCartButtons = By.cssSelector(".product-btn-cart");
    private By emptyWishlistMessage = By.cssSelector(".text-center");
    private By wishlistCount = By.id("wishlist-count");
    private By productNames = By.cssSelector(".product-name");
    private By productPrices = By.cssSelector(".product-price");
    private By removalConfirmation = By.id("customAlert");
    
    public WishlistPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
    }
    
    public void navigateToWishlistPage(String baseUrl) {
        driver.get(baseUrl + "wishlist.html");
    }
    
    public boolean hasWishlistItems() {
        return !driver.findElements(wishlistItems).isEmpty();
    }
    
    public int getWishlistItemCount() {
        return driver.findElements(wishlistItems).size();
    }
    
    public List<WebElement> getWishlistItems() {
        return driver.findElements(wishlistItems);
    }
    
    public void clickRemoveButton(int index) {
        List<WebElement> removeButtonsList = driver.findElements(removeButtons);
        if (index < removeButtonsList.size()) {
            removeButtonsList.get(index).click();
        }
    }
    
    public void clickAddToCartButton(int index) {
        List<WebElement> addToCartButtonsList = driver.findElements(addToCartButtons);
        if (index < addToCartButtonsList.size()) {
            addToCartButtonsList.get(index).click();
        }
    }
    
    public boolean isEmptyWishlistMessageDisplayed() {
        return elementUtils.isDisplayed(emptyWishlistMessage);
    }
    
    public String getEmptyWishlistMessage() {
        return elementUtils.getText(emptyWishlistMessage);
    }
    
    public boolean isRemovalConfirmationDisplayed() {
        return elementUtils.isDisplayed(removalConfirmation);
    }
    
    public String getRemovalConfirmationMessage() {
        return elementUtils.getText(removalConfirmation);
    }
}
