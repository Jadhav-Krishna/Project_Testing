package com.commerza.pages;

import com.commerza.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    
    private WebDriver driver;
    private ElementUtils elementUtils;
    
    private By checkoutModal = By.id("checkoutModal");
    private By checkoutForm = By.id("checkoutForm");
    private By fullNameField = By.id("customerName");
    private By phoneField = By.id("customerPhone");
    private By addressLine1Field = By.id("customerAddress");
    private By addressLine2Field = By.id("customerAddress");
    private By cityField = By.id("city");
    private By postalCodeField = By.id("postalCode");
    private By countryField = By.id("country");
    private By paymentMethodField = By.id("paymentMethod");
    private By differentBillingCheckbox = By.id("different-billing");
    private By billingFullNameField = By.id("billing-fullName");
    private By billingPhoneField = By.id("billing-phone");
    private By billingAddressField = By.id("billing-address");
    private By billingCityField = By.id("billing-city");
    private By billingPostalCodeField = By.id("billing-postalCode");
    private By paymentMethodCOD = By.id("payment-cod");
    private By paymentMethodCard = By.id("payment-card");
    private By termsCheckbox = By.id("terms-conditions");
    private By placeOrderButton = By.cssSelector("#checkoutForm button[type='submit']");
    private By orderSummary = By.cssSelector(".card-body");
    private By summaryProducts = By.cssSelector("#cart-items-container");
    private By summarySubtotal = By.id("cart-subtotal");
    private By summaryShipping = By.id("cart-shipping");
    private By summaryTotal = By.id("cart-total");
    private By validationError = By.id("customAlert");
    private By loginOption = By.cssSelector("a[href='login.html']");
    private By guestCheckoutOption = By.cssSelector(".guest-checkout");
    private By selectedPaymentMethod = By.id("paymentMethod");
    private By paymentDetails = By.cssSelector(".payment-details");
    
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
    }
    
    public boolean isOnCheckoutPage() {
        return driver.getCurrentUrl().contains("checkout") || 
               elementUtils.isDisplayed(placeOrderButton);
    }
    
    public void enterFullName(String name) {
        elementUtils.sendKeys(fullNameField, name);
    }
    
    public void enterPhone(String phone) {
        elementUtils.sendKeys(phoneField, phone);
    }
    
    public void enterAddressLine1(String address) {
        elementUtils.sendKeys(addressLine1Field, address);
    }
    
    public void enterCity(String city) {
        elementUtils.sendKeys(cityField, city);
    }
    
    public void enterPostalCode(String postalCode) {
        elementUtils.sendKeys(postalCodeField, postalCode);
    }
    
    public void enterCountry(String country) {
        elementUtils.sendKeys(countryField, country);
    }
    
    public void checkDifferentBillingAddress() {
        if (!driver.findElement(differentBillingCheckbox).isSelected()) {
            elementUtils.click(differentBillingCheckbox);
        }
    }
    
    public void enterBillingFullName(String name) {
        elementUtils.sendKeys(billingFullNameField, name);
    }
    
    public void enterBillingPhone(String phone) {
        elementUtils.sendKeys(billingPhoneField, phone);
    }
    
    public void enterBillingAddress(String address) {
        elementUtils.sendKeys(billingAddressField, address);
    }
    
    public void enterBillingCity(String city) {
        elementUtils.sendKeys(billingCityField, city);
    }
    
    public void enterBillingPostalCode(String postalCode) {
        elementUtils.sendKeys(billingPostalCodeField, postalCode);
    }
    
    public void selectPaymentMethod(String method) {
        if (method.equalsIgnoreCase("Cash on Delivery") || method.equalsIgnoreCase("COD")) {
            elementUtils.click(paymentMethodCOD);
        } else if (method.equalsIgnoreCase("Card") || method.equalsIgnoreCase("Credit Card")) {
            elementUtils.click(paymentMethodCard);
        }
    }
    
    public void agreeToTerms() {
        if (!driver.findElement(termsCheckbox).isSelected()) {
            elementUtils.click(termsCheckbox);
        }
    }
    
    public void clickPlaceOrder() {
        elementUtils.click(placeOrderButton);
    }
    
    public boolean isOrderSummaryDisplayed() {
        return elementUtils.isDisplayed(orderSummary);
    }
    
    public boolean areSummaryProductsDisplayed() {
        return elementUtils.isDisplayed(summaryProducts);
    }
    
    public String getSummarySubtotal() {
        return elementUtils.getText(summarySubtotal);
    }
    
    public String getSummaryShipping() {
        return elementUtils.getText(summaryShipping);
    }
    
    public String getSummaryTotal() {
        return elementUtils.getText(summaryTotal);
    }
    
    public boolean isValidationErrorDisplayed() {
        return elementUtils.isDisplayed(validationError);
    }
    
    public String getValidationError() {
        return elementUtils.getText(validationError);
    }
    
    public boolean isLoginOptionDisplayed() {
        return elementUtils.isDisplayed(loginOption);
    }
    
    public boolean isGuestCheckoutOptionDisplayed() {
        return elementUtils.isDisplayed(guestCheckoutOption);
    }
    
    public boolean isPaymentMethodSelected() {
        return elementUtils.isDisplayed(selectedPaymentMethod);
    }
    
    public boolean isPaymentDetailsDisplayed() {
        return elementUtils.isDisplayed(paymentDetails);
    }
    
    public boolean areFieldsPreFilled() {
        String nameValue = driver.findElement(fullNameField).getAttribute("value");
        return nameValue != null && !nameValue.isEmpty();
    }
}
