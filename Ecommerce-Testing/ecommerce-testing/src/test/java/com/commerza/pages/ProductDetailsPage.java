package com.commerza.pages;

import com.commerza.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductDetailsPage {
    
    private WebDriver driver;
    private ElementUtils elementUtils;
    
    private By productName = By.cssSelector(".product-name");
    private By productPrice = By.cssSelector(".product-price");
    private By productDescription = By.cssSelector(".product-desc");
    private By productMainImage = By.cssSelector(".product-image");
    private By productImages = By.cssSelector(".card-img-top");
    private By imageThumbnails = By.cssSelector(".thumbnail");
    private By addToCartButton = By.cssSelector(".product-btn-cart");
    private By addToWishlistButton = By.cssSelector(".btn-wishlist");
    private By addToCompareButton = By.cssSelector(".btn-compare");
    private By quantityInput = By.cssSelector("input[type='number']");
    private By incrementQuantity = By.cssSelector(".btn-increment");
    private By decrementQuantity = By.cssSelector(".btn-decrement");
    private By productSpecifications = By.cssSelector(".product-specs");
    private By stockStatus = By.cssSelector(".stock-status");
    private By notifyMeButton = By.cssSelector(".btn-notify");
    private By wishlistIconFilled = By.cssSelector(".bi-heart-fill");
    private By relatedProducts = By.id("related-products-container");
    
    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
    }
    
    public boolean isProductNameDisplayed() {
        return elementUtils.isDisplayed(productName);
    }
    
    public String getProductName() {
        return elementUtils.getText(productName);
    }
    
    public boolean isProductPriceDisplayed() {
        return elementUtils.isDisplayed(productPrice);
    }
    
    public String getProductPrice() {
        return elementUtils.getText(productPrice);
    }
    
    public boolean isProductDescriptionDisplayed() {
        return elementUtils.isDisplayed(productDescription);
    }
    
    public String getProductDescription() {
        return elementUtils.getText(productDescription);
    }
    
    public boolean isProductMainImageDisplayed() {
        return elementUtils.isDisplayed(productMainImage);
    }
    
    public boolean hasMultipleImages() {
        return driver.findElements(productImages).size() > 1;
    }
    
    public boolean areImageThumbnailsDisplayed() {
        return !driver.findElements(imageThumbnails).isEmpty();
    }
    
    public void clickImageThumbnail(int index) {
        List<WebElement> thumbnails = driver.findElements(imageThumbnails);
        if (index < thumbnails.size()) {
            thumbnails.get(index).click();
        }
    }
    
    public boolean isAddToCartButtonDisplayed() {
        return elementUtils.isDisplayed(addToCartButton);
    }
    
    public void clickAddToCart() {
        elementUtils.click(addToCartButton);
    }
    
    public boolean isAddToWishlistButtonDisplayed() {
        return elementUtils.isDisplayed(addToWishlistButton);
    }
    
    public void clickAddToWishlist() {
        elementUtils.click(addToWishlistButton);
    }
    
    public void clickAddToCompare() {
        elementUtils.click(addToCompareButton);
    }
    
    public void setQuantity(String quantity) {
        elementUtils.sendKeys(quantityInput, quantity);
    }
    
    public void incrementQuantity() {
        elementUtils.click(incrementQuantity);
    }
    
    public void decrementQuantity() {
        elementUtils.click(decrementQuantity);
    }
    
    public String getQuantity() {
        return driver.findElement(quantityInput).getAttribute("value");
    }
    
    public boolean isProductSpecificationsDisplayed() {
        return elementUtils.isDisplayed(productSpecifications);
    }
    
    public String getStockStatus() {
        return elementUtils.getText(stockStatus);
    }
    
    public boolean isAddToCartButtonEnabled() {
        return elementUtils.isEnabled(addToCartButton);
    }
    
    public boolean isNotifyMeButtonDisplayed() {
        return elementUtils.isDisplayed(notifyMeButton);
    }
    
    public boolean isWishlistIconFilled() {
        return elementUtils.isDisplayed(wishlistIconFilled);
    }
    
    public boolean isRelatedProductsDisplayed() {
        return elementUtils.isDisplayed(relatedProducts);
    }
}
