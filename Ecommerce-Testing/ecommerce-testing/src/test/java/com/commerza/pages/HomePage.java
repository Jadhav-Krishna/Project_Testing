package com.commerza.pages;

import com.commerza.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    
    private WebDriver driver;
    private ElementUtils elementUtils;
    
    private By logo = By.cssSelector(".navbar-logo");
    private By searchBox = By.cssSelector(".search-input");
    private By loginLink = By.cssSelector("a[href='login.html']");
    private By signupLink = By.cssSelector("a[href='signup.html']");
    private By cartIcon = By.id("cart-icon");
    private By cartCount = By.id("cart-count");
    private By wishlistIcon = By.cssSelector("a[href='wishlist.html'] i");
    private By wishlistCount = By.id("wishlist-count");
    private By productCategories = By.cssSelector(".dropdown-menu");
    private By featuredProducts = By.id("featured-products-container");
    private By bannerSlider = By.id("carouselExampleIndicators");
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
    }
    
    public void navigateToHomePage(String baseUrl) {
        driver.get(baseUrl + "index.html");
    }
    
    public boolean isLogoDisplayed() {
        return elementUtils.isDisplayed(logo);
    }
    
    public void clickLogo() {
        elementUtils.click(logo);
    }
    
    public void enterSearchText(String searchText) {
        elementUtils.sendKeys(searchBox, searchText);
    }
    
    public void clickLoginLink() {
        elementUtils.click(loginLink);
    }
    
    public void clickSignupLink() {
        elementUtils.click(signupLink);
    }
    
    public void clickCartIcon() {
        elementUtils.click(cartIcon);
    }
    
    public void clickWishlistIcon() {
        elementUtils.click(wishlistIcon);
    }
    
    public boolean isFeaturedProductsDisplayed() {
        return elementUtils.isDisplayed(featuredProducts);
    }
    
    public boolean isBannerSliderDisplayed() {
        return elementUtils.isDisplayed(bannerSlider);
    }
    
    public boolean isCategoryMenuDisplayed() {
        return elementUtils.isDisplayed(productCategories);
    }
    
    public String getPageTitle() {
        return driver.getTitle();
    }
}
