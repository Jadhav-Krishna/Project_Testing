package com.commerza.pages;

import com.commerza.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    
    private WebDriver driver;
    private ElementUtils elementUtils;
    
    private By cartItems = By.cssSelector(".cart-item");
    private By cartIcon = By.id("cart-icon");
    private By cartCount = By.id("cart-count");
    private By confirmationMessage = By.id("customAlert");
    private By cartItemsContainer = By.id("cart-items-container");
    private By productNames = By.cssSelector(".product-name");
    private By productPrices = By.cssSelector(".product-price");
    private By quantityInputs = By.cssSelector("input[type='number']");
    private By subtotals = By.cssSelector(".subtotal");
    private By cartSummary = By.cssSelector(".card-body");
    private By updateCartButton = By.cssSelector(".btn-update");
    private By incrementButtons = By.cssSelector(".btn-increment");
    private By decrementButtons = By.cssSelector(".btn-decrement");
    private By removeButtons = By.cssSelector(".btn-remove");
    private By clearCartButton = By.cssSelector(".btn-clear");
    private By emptyCartMessage = By.cssSelector(".text-center");
    private By continueShoppingButton = By.cssSelector("a[href='index.html']");
    private By cartSubtotal = By.id("cart-subtotal");
    private By totalItemsQty = By.id("total-items-qty");
    private By couponInput = By.id("coupon-code");
    private By applyCouponButton = By.cssSelector(".btn-coupon");
    private By discountAmount = By.cssSelector(".discount-amount");
    private By shippingCost = By.id("cart-shipping");
    private By cartTotal = By.id("cart-total");
    private By errorMessage = By.id("customAlert");
    private By couponSuccessMessage = By.id("customAlert");
    private By proceedToCheckoutButton = By.cssSelector("button[data-bs-target='#checkoutModal']");
    private By itemRemovalConfirmation = By.id("customAlert");
    
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
    }
    
    public void navigateToCartPage(String baseUrl) {
        driver.get(baseUrl + "cart.html");
    }
    
    public boolean hasCartItems() {
        return !driver.findElements(cartItems).isEmpty();
    }
    
    public int getCartItemCount() {
        return driver.findElements(cartItems).size();
    }
    
    public String getCartCount() {
        return elementUtils.getText(cartCount);
    }
    
    public boolean isConfirmationMessageDisplayed() {
        return elementUtils.isDisplayed(confirmationMessage);
    }
    
    public String getConfirmationMessage() {
        return elementUtils.getText(confirmationMessage);
    }
    
    public boolean areProductNamesDisplayed() {
        return !driver.findElements(productNames).isEmpty();
    }
    
    public boolean areProductPricesDisplayed() {
        return !driver.findElements(productPrices).isEmpty();
    }
    
    public boolean areQuantitiesDisplayed() {
        return !driver.findElements(quantityInputs).isEmpty();
    }
    
    public boolean areSubtotalsDisplayed() {
        return !driver.findElements(subtotals).isEmpty();
    }
    
    public boolean isCartSummaryDisplayed() {
        return elementUtils.isDisplayed(cartSummary);
    }
    
    public void updateQuantity(int itemIndex, String quantity) {
        List<WebElement> quantityFields = driver.findElements(quantityInputs);
        if (itemIndex < quantityFields.size()) {
            quantityFields.get(itemIndex).clear();
            quantityFields.get(itemIndex).sendKeys(quantity);
        }
    }
    
    public void clickUpdateCart() {
        elementUtils.click(updateCartButton);
    }
    
    public String getItemQuantity(int itemIndex) {
        List<WebElement> quantityFields = driver.findElements(quantityInputs);
        if (itemIndex < quantityFields.size()) {
            return quantityFields.get(itemIndex).getAttribute("value");
        }
        return "0";
    }
    
    public String getItemSubtotal(int itemIndex) {
        List<WebElement> subtotalElements = driver.findElements(subtotals);
        if (itemIndex < subtotalElements.size()) {
            return subtotalElements.get(itemIndex).getText();
        }
        return "0";
    }
    
    public void clickIncrementButton(int itemIndex) {
        List<WebElement> incrementButtonsList = driver.findElements(incrementButtons);
        if (itemIndex < incrementButtonsList.size()) {
            incrementButtonsList.get(itemIndex).click();
        }
    }
    
    public void clickDecrementButton(int itemIndex) {
        List<WebElement> decrementButtonsList = driver.findElements(decrementButtons);
        if (itemIndex < decrementButtonsList.size()) {
            decrementButtonsList.get(itemIndex).click();
        }
    }
    
    public void clickRemoveButton(int itemIndex) {
        List<WebElement> removeButtonsList = driver.findElements(removeButtons);
        if (itemIndex < removeButtonsList.size()) {
            removeButtonsList.get(itemIndex).click();
        }
    }
    
    public void clickClearCart() {
        elementUtils.click(clearCartButton);
    }
    
    public boolean isEmptyCartMessageDisplayed() {
        return elementUtils.isDisplayed(emptyCartMessage);
    }
    
    public String getEmptyCartMessage() {
        return elementUtils.getText(emptyCartMessage);
    }
    
    public boolean isContinueShoppingButtonDisplayed() {
        return elementUtils.isDisplayed(continueShoppingButton);
    }
    
    public String getCartSubtotal() {
        return elementUtils.getText(cartSubtotal);
    }
    
    public void enterCouponCode(String couponCode) {
        elementUtils.sendKeys(couponInput, couponCode);
    }
    
    public void clickApplyCoupon() {
        elementUtils.click(applyCouponButton);
    }
    
    public boolean isDiscountDisplayed() {
        return elementUtils.isDisplayed(discountAmount);
    }
    
    public String getDiscountAmount() {
        return elementUtils.getText(discountAmount);
    }
    
    public String getShippingCost() {
        return elementUtils.getText(shippingCost);
    }
    
    public String getCartTotal() {
        return elementUtils.getText(cartTotal);
    }
    
    public String getErrorMessage() {
        return elementUtils.getText(errorMessage);
    }
    
    public boolean isCouponSuccessMessageDisplayed() {
        return elementUtils.isDisplayed(couponSuccessMessage);
    }
    
    public void clickProceedToCheckout() {
        elementUtils.click(proceedToCheckoutButton);
    }
    
    public boolean isItemRemovalConfirmationDisplayed() {
        return elementUtils.isDisplayed(itemRemovalConfirmation);
    }
    
    public void clickCartIcon() {
        elementUtils.click(cartIcon);
    }
}
