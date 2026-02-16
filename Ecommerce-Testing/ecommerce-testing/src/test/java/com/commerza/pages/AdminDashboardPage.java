package com.commerza.pages;

import com.commerza.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminDashboardPage {
    
    private WebDriver driver;
    private ElementUtils elementUtils;
    
    private By dashboard = By.id("dashboardSection");
    private By totalOrders = By.id("totalOrdersValue");
    private By totalRevenue = By.id("totalRevenueValue");
    private By totalCustomers = By.id("totalCustomersValue");
    private By pendingOrders = By.id("pendingOrdersValue");
    private By recentOrdersList = By.cssSelector(".table");
    private By salesChart = By.id("salesChart");
    private By productsLink = By.id("products-tab");
    private By ordersLink = By.id("orders-tab");
    private By customersLink = By.id("customers-tab");
    private By contentLink = By.id("website-tab");
    private By categoriesLink = By.id("dashboard-tab");
    private By reportsLink = By.id("analytics-tab");
    private By settingsLink = By.id("homepage-tab");
    private By logoutButton = By.id("logoutBtn");
    
    public AdminDashboardPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
    }
    
    public boolean isDashboardDisplayed() {
        return elementUtils.isDisplayed(dashboard);
    }
    
    public boolean isTotalOrdersDisplayed() {
        return elementUtils.isDisplayed(totalOrders);
    }
    
    public String getTotalOrders() {
        return elementUtils.getText(totalOrders);
    }
    
    public boolean isTotalRevenueDisplayed() {
        return elementUtils.isDisplayed(totalRevenue);
    }
    
    public String getTotalRevenue() {
        return elementUtils.getText(totalRevenue);
    }
    
    public boolean isTotalCustomersDisplayed() {
        return elementUtils.isDisplayed(totalCustomers);
    }
    
    public boolean isPendingOrdersDisplayed() {
        return elementUtils.isDisplayed(pendingOrders);
    }
    
    public boolean isRecentOrdersListDisplayed() {
        return elementUtils.isDisplayed(recentOrdersList);
    }
    
    public boolean isSalesChartDisplayed() {
        return elementUtils.isDisplayed(salesChart);
    }
    
    public void clickProductsLink() {
        elementUtils.click(productsLink);
    }
    
    public void clickOrdersLink() {
        elementUtils.click(ordersLink);
    }
    
    public void clickCustomersLink() {
        elementUtils.click(customersLink);
    }
    
    public void clickContentLink() {
        elementUtils.click(contentLink);
    }
    
    public void clickCategoriesLink() {
        elementUtils.click(categoriesLink);
    }
    
    public void clickReportsLink() {
        elementUtils.click(reportsLink);
    }
    
    public void clickSettingsLink() {
        elementUtils.click(settingsLink);
    }
    
    public void clickLogout() {
        elementUtils.click(logoutButton);
    }
    
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
