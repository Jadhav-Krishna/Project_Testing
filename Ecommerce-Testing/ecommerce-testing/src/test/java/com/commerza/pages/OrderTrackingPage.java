package com.commerza.pages;

import com.commerza.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderTrackingPage {
    
    private WebDriver driver;
    private ElementUtils elementUtils;
    
    private By orderNumberField = By.id("orderIdInput");
    private By emailField = By.id("orderEmailInput");
    private By trackOrderButton = By.cssSelector("#orderTrackingForm button[type='submit']");
    private By orderStatus = By.cssSelector(".tracking-step");
    private By orderTimeline = By.cssSelector(".tracking-steps");
    private By deliveryInfo = By.cssSelector(".tracking-form-card");
    private By orderConfirmation = By.id("orderTrackingForm");
    private By confirmationOrderNumber = By.id("orderIdInput");
    private By confirmationOrderDate = By.cssSelector(".tracking-subtitle");
    private By deliveryEstimate = By.cssSelector(".tracking-step");
    private By trackOrderLink = By.cssSelector("a[href='order-tracking.html']");
    private By errorMessage = By.id("customAlert");
    private By orderNotFoundMessage = By.id("customAlert");
    
    public OrderTrackingPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
    }
    
    public void navigateToOrderTrackingPage(String baseUrl) {
        driver.get(baseUrl + "order-tracking.html");
    }
    
    public void enterOrderNumber(String orderNumber) {
        elementUtils.sendKeys(orderNumberField, orderNumber);
    }
    
    public void enterEmail(String email) {
        elementUtils.sendKeys(emailField, email);
    }
    
    public void clickTrackOrder() {
        elementUtils.click(trackOrderButton);
    }
    
    public boolean isOrderStatusDisplayed() {
        return elementUtils.isDisplayed(orderStatus);
    }
    
    public String getOrderStatus() {
        return elementUtils.getText(orderStatus);
    }
    
    public boolean isOrderTimelineDisplayed() {
        return elementUtils.isDisplayed(orderTimeline);
    }
    
    public boolean isDeliveryInfoDisplayed() {
        return elementUtils.isDisplayed(deliveryInfo);
    }
    
    public boolean isOrderConfirmationDisplayed() {
        return elementUtils.isDisplayed(orderConfirmation);
    }
    
    public String getConfirmationOrderNumber() {
        return elementUtils.getText(confirmationOrderNumber);
    }
    
    public String getConfirmationOrderDate() {
        return elementUtils.getText(confirmationOrderDate);
    }
    
    public boolean isDeliveryEstimateDisplayed() {
        return elementUtils.isDisplayed(deliveryEstimate);
    }
    
    public boolean isTrackOrderLinkDisplayed() {
        return elementUtils.isDisplayed(trackOrderLink);
    }
    
    public String getErrorMessage() {
        return elementUtils.getText(errorMessage);
    }
    
    public boolean isOrderNotFoundMessageDisplayed() {
        return elementUtils.isDisplayed(orderNotFoundMessage);
    }
    
    public void trackOrder(String orderNumber, String email) {
        enterOrderNumber(orderNumber);
        enterEmail(email);
        clickTrackOrder();
    }
}
