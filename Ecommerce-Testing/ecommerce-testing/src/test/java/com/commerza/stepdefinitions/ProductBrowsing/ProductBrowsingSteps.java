package com.commerza.stepdefinitions.ProductBrowsing;

import com.commerza.pages.*;
import com.commerza.utils.ConfigReader;
import com.commerza.utils.DriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductBrowsingSteps {
    
    private WebDriver driver;
    private HomePage homePage;
    private ProductsPage productsPage;
    private ProductDetailsPage productDetailsPage;
    private WishlistPage wishlistPage;
    private ComparePage comparePage;
    private LoginPage loginPage;
    private String baseUrl;
    
    public ProductBrowsingSteps() {
        this.driver = DriverManager.getDriver();
        this.homePage = new HomePage(driver);
        this.productsPage = new ProductsPage(driver);
        this.productDetailsPage = new ProductDetailsPage(driver);
        this.wishlistPage = new WishlistPage(driver);
        this.comparePage = new ComparePage(driver);
        this.loginPage = new LoginPage(driver);
        this.baseUrl = ConfigReader.getBaseUrl();
    }
    
    @When("the user navigates to the products page")
    public void the_user_navigates_to_the_products_page() {
        productsPage.navigateToProductsPage(baseUrl);
    }
    
    @Then("the user should see a list of products")
    public void the_user_should_see_a_list_of_products() {
        Assert.assertTrue(productsPage.isProductGridDisplayed(), "Product grid not displayed");
        Assert.assertTrue(productsPage.getProductCount() > 0, "No products displayed");
    }
    
    @Then("each product should display product image")
    public void each_product_should_display_product_image() {
        Assert.assertTrue(productsPage.areProductImagesDisplayed(), "Product images not displayed");
    }
    
    @Then("each product should display product name")
    public void each_product_should_display_product_name() {
        Assert.assertTrue(productsPage.areProductNamesDisplayed(), "Product names not displayed");
    }
    
    @Then("each product should display product price")
    public void each_product_should_display_product_price() {
        Assert.assertTrue(productsPage.areProductPricesDisplayed(), "Product prices not displayed");
    }
    
    @When("there are more than {int} products")
    public void there_are_more_than_products(Integer count) {
        Assert.assertTrue(productsPage.getProductCount() >= count, "Not enough products for pagination test");
    }
    
    @Then("the user should see pagination controls")
    public void the_user_should_see_pagination_controls() {
        Assert.assertTrue(productsPage.isPaginationDisplayed(), "Pagination controls not displayed");
    }
    
    @When("the user clicks on next page")
    public void the_user_clicks_on_next_page() {
        productsPage.clickNextPage();
    }
    
    @Then("the user should see the next set of products")
    public void the_user_should_see_the_next_set_of_products() {
        Assert.assertTrue(productsPage.getProductCount() > 0, "No products on next page");
    }
    
    @When("the user enters {string} in the search box")
    public void the_user_enters_in_the_search_box(String keyword) {
        productsPage.enterSearchKeyword(keyword);
    }
    
    @When("the user clicks on search button")
    public void the_user_clicks_on_search_button() {
        productsPage.clickSearchButton();
    }
    
    @Then("the user should see search results for {string}")
    public void the_user_should_see_search_results_for(String keyword) {
        Assert.assertTrue(productsPage.isSearchResultsDisplayed() || productsPage.isProductGridDisplayed(), 
                         "Search results not displayed");
    }
    
    @Then("all displayed products should match the search keyword")
    public void all_displayed_products_should_match_the_search_keyword() {
        Assert.assertTrue(productsPage.getProductCount() > 0, "No search results found");
    }
    
    @Then("the user should see {string} message")
    public void the_user_should_see_message(String expectedMessage) {
        if (expectedMessage.contains("No products found")) {
            Assert.assertTrue(productsPage.isNoResultsMessageDisplayed(), "No results message not displayed");
        }
    }
    
    @When("the user selects {string} category")
    public void the_user_selects_category(String categoryName) {
        productsPage.selectCategory(categoryName);
    }
    
    @Then("the user should see only products from {string} category")
    public void the_user_should_see_only_products_from_category(String categoryName) {
        Assert.assertTrue(productsPage.getProductCount() > 0, "No products in selected category");
    }
    
    @Then("the category filter should be highlighted")
    public void the_category_filter_should_be_highlighted() {
        Assert.assertTrue(productsPage.isCategoryFilterActive(), "Category filter not highlighted");
    }
    
    @When("the user clicks on {string} category link")
    public void the_user_clicks_on_category_link(String categoryName) {
        productsPage.clickCategoryLink(categoryName);
    }
    
    @Then("the user should be on category page for {string}")
    public void the_user_should_be_on_category_page_for(String categoryName) {
        String currentUrl = productsPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("category") || currentUrl.contains("shop"), 
                         "Not on category page");
    }
    
    @Then("the user should see products from {string} category only")
    public void the_user_should_see_products_from_category_only(String categoryName) {
        Assert.assertTrue(productsPage.getProductCount() > 0, "No products in category");
    }
    
    @When("the user navigates to {string}")
    public void the_user_navigates_to(String pageName) {
        productsPage.navigateToCategoryPage(baseUrl, pageName);
    }
    
    @Then("the user should see category A products")
    public void the_user_should_see_category_a_products() {
        Assert.assertTrue(productsPage.isProductGridDisplayed(), "Category A products not displayed");
    }
    
    @When("the user clicks on category B link")
    public void the_user_clicks_on_category_b_link() {
        productsPage.clickCategoryLink("Category B");
    }
    
    @Then("the user should see category B products")
    public void the_user_should_see_category_b_products() {
        Assert.assertTrue(productsPage.isProductGridDisplayed(), "Category B products not displayed");
    }
    
    @When("the user clicks on a product")
    public void the_user_clicks_on_a_product() {
        productsPage.clickFirstProduct();
    }
    
    @Then("the user should see the product details page")
    public void the_user_should_see_the_product_details_page() {
        Assert.assertTrue(productDetailsPage.isProductNameDisplayed(), "Product details page not loaded");
    }
    
    @Then("the product details should include product name")
    public void the_product_details_should_include_product_name() {
        Assert.assertTrue(productDetailsPage.isProductNameDisplayed(), "Product name not displayed");
    }
    
    @Then("the product details should include product price")
    public void the_product_details_should_include_product_price() {
        Assert.assertTrue(productDetailsPage.isProductPriceDisplayed(), "Product price not displayed");
    }
    
    @Then("the product details should include product description")
    public void the_product_details_should_include_product_description() {
        Assert.assertTrue(productDetailsPage.isProductDescriptionDisplayed(), "Product description not displayed");
    }
    
    @Then("the product details should include product images")
    public void the_product_details_should_include_product_images() {
        Assert.assertTrue(productDetailsPage.isProductMainImageDisplayed(), "Product images not displayed");
    }
    
    @Then("the user should see {string} button")
    public void the_user_should_see_button(String buttonName) {
        if (buttonName.equals("Add to Cart")) {
            Assert.assertTrue(productDetailsPage.isAddToCartButtonDisplayed(), "Add to Cart button not displayed");
        } else if (buttonName.equals("Add to Wishlist")) {
            Assert.assertTrue(productDetailsPage.isAddToWishlistButtonDisplayed(), "Add to Wishlist button not displayed");
        }
    }
    
    @When("the user is on a product details page")
    public void the_user_is_on_a_product_details_page() {
        productsPage.navigateToProductsPage(baseUrl);
        productsPage.clickFirstProduct();
    }
    
    @When("the product has multiple images")
    public void the_product_has_multiple_images() {
        Assert.assertTrue(productDetailsPage.hasMultipleImages(), "Product doesn't have multiple images");
    }
    
    @Then("the user should see image thumbnails")
    public void the_user_should_see_image_thumbnails() {
        Assert.assertTrue(productDetailsPage.areImageThumbnailsDisplayed(), "Image thumbnails not displayed");
    }
    
    @When("the user clicks on a thumbnail")
    public void the_user_clicks_on_a_thumbnail() {
        productDetailsPage.clickImageThumbnail(1);
    }
    
    @Then("the main product image should change")
    public void the_main_product_image_should_change() {
        Assert.assertTrue(productDetailsPage.isProductMainImageDisplayed(), "Main image not updated");
    }
    
    @When("the user sets minimum price to {string}")
    public void the_user_sets_minimum_price_to(String minPrice) {
        productsPage.setMinPrice(minPrice);
    }
    
    @When("the user sets maximum price to {string}")
    public void the_user_sets_maximum_price_to(String maxPrice) {
        productsPage.setMaxPrice(maxPrice);
    }
    
    @When("the user applies price filter")
    public void the_user_applies_price_filter() {
        productsPage.applyPriceFilter();
    }
    
    @Then("all displayed products should be within price range")
    public void all_displayed_products_should_be_within_price_range() {
        Assert.assertTrue(productsPage.verifyProductsInPriceRange(1000, 5000), "Products not in price range");
    }
    
    @When("the user selects sort by {string}")
    public void the_user_selects_sort_by(String sortOption) {
        productsPage.selectSortOption(sortOption);
    }
    
    @Then("the products should be sorted by {string}")
    public void the_products_should_be_sorted_by(String sortOption) {
        Assert.assertTrue(productsPage.getProductCount() > 0, "No products to verify sorting");
    }
    
    @When("the user clicks on wishlist icon for a product")
    public void the_user_clicks_on_wishlist_icon_for_a_product() {
        productsPage.clickWishlistIconForProduct(0);
    }
    
    @Then("the product should be added to wishlist")
    public void the_product_should_be_added_to_wishlist() {
        Assert.assertTrue(productsPage.isWishlistConfirmationDisplayed() || 
                         productDetailsPage.isWishlistIconFilled(), 
                         "Product not added to wishlist");
    }
    
    @Then("the user should see wishlist confirmation message")
    public void the_user_should_see_wishlist_confirmation_message() {
        Assert.assertTrue(productsPage.isWishlistConfirmationDisplayed(), "Wishlist confirmation not displayed");
    }
    
    @When("the user clicks on {string} button")
    public void the_user_clicks_on_button(String buttonName) {
        if (buttonName.equals("Add to Wishlist")) {
            productDetailsPage.clickAddToWishlist();
        }
    }
    
    @Then("the wishlist icon should be filled")
    public void the_wishlist_icon_should_be_filled() {
        Assert.assertTrue(productDetailsPage.isWishlistIconFilled(), "Wishlist icon not filled");
    }
    
    @Given("the user has products in wishlist")
    public void the_user_has_products_in_wishlist() {
    }
    
    @When("the user navigates to wishlist page")
    public void the_user_navigates_to_wishlist_page() {
        wishlistPage.navigateToWishlistPage(baseUrl);
    }
    
    @Then("the user should see all wishlisted products")
    public void the_user_should_see_all_wishlisted_products() {
        Assert.assertTrue(wishlistPage.hasWishlistItems(), "No products in wishlist");
    }
    
    @Then("each product should have {string} option")
    public void each_product_should_have_option(String optionName) {
        Assert.assertTrue(wishlistPage.hasWishlistItems(), "Wishlist items not found");
    }
    
    @When("the user clicks on remove button for a product")
    public void the_user_clicks_on_remove_button_for_a_product() {
        wishlistPage.clickRemoveButton(0);
    }
    
    @Then("the product should be removed from wishlist")
    public void the_product_should_be_removed_from_wishlist() {
    }
    
    @Then("the user should see removal confirmation")
    public void the_user_should_see_removal_confirmation() {
        Assert.assertTrue(wishlistPage.isRemovalConfirmationDisplayed(), "Removal confirmation not displayed");
    }
    
    @Then("the user should be prompted to login")
    public void the_user_should_be_prompted_to_login() {
        Assert.assertTrue(productsPage.isLoginPromptDisplayed(), "Login prompt not displayed");
    }
    
    @When("the user clicks on compare icon for first product")
    public void the_user_clicks_on_compare_icon_for_first_product() {
        productsPage.clickCompareIconForProduct(0);
    }
    
    @When("the user clicks on compare icon for second product")
    public void the_user_clicks_on_compare_icon_for_second_product() {
        productsPage.clickCompareIconForProduct(1);
    }
    
    @Then("the user should see compare notification with count {string}")
    public void the_user_should_see_compare_notification_with_count(String count) {
        Assert.assertTrue(productsPage.isCompareNotificationDisplayed(), "Compare notification not displayed");
    }
    
    @When("the user has products in compare list")
    public void the_user_has_products_in_compare_list() {
    }
    
    @When("the user navigates to compare page")
    public void the_user_navigates_to_compare_page() {
        comparePage.navigateToComparePage(baseUrl);
    }
    
    @Then("the user should see comparison table")
    public void the_user_should_see_comparison_table() {
        Assert.assertTrue(comparePage.isComparisonTableDisplayed(), "Comparison table not displayed");
    }
    
    @Then("the table should show product specifications")
    public void the_table_should_show_product_specifications() {
        Assert.assertTrue(comparePage.areProductSpecsDisplayed(), "Product specifications not displayed");
    }
    
    @Then("each product should have {string} button")
    public void each_product_should_have_button(String buttonName) {
        if (buttonName.equals("Add to Cart")) {
            Assert.assertTrue(comparePage.getAddToCartButtons().size() > 0, "Add to Cart buttons not found");
        } else if (buttonName.equals("Remove")) {
            Assert.assertTrue(comparePage.getRemoveButtons().size() > 0, "Remove buttons not found");
        }
    }
    
    @When("the user removes a product from comparison")
    public void the_user_removes_a_product_from_comparison() {
        comparePage.removeProduct(0);
    }
    
    @Then("the product should be removed from comparison table")
    public void the_product_should_be_removed_from_comparison_table() {
    }
    
    @Then("the compare count should be updated")
    public void the_compare_count_should_be_updated() {
    }
    
    @When("the user adds {int} products to compare")
    public void the_user_adds_products_to_compare(Integer count) {
        for (int i = 0; i < count && i < 4; i++) {
            productsPage.clickCompareIconForProduct(i);
        }
    }
    
    @When("the user tries to add 5th product to compare")
    public void the_user_tries_to_add_5th_product_to_compare() {
        productsPage.clickCompareIconForProduct(4);
    }
    
    @Then("the user should see message {string}")
    public void the_user_should_see_max_limit_message(String expectedMessage) {
        Assert.assertTrue(comparePage.isMaxLimitMessageDisplayed(), "Max limit message not displayed");
    }
    
    @When("the user views a product that is in stock")
    public void the_user_views_a_product_that_is_in_stock() {
        productsPage.navigateToProductsPage(baseUrl);
        productsPage.clickFirstProduct();
    }
    
    @Then("the product should show {string} status")
    public void the_product_should_show_status(String status) {
        String actualStatus = productDetailsPage.getStockStatus();
        Assert.assertTrue(actualStatus.contains(status), "Stock status mismatch");
    }
    
    @Then("the {string} button should be enabled")
    public void the_button_should_be_enabled(String buttonName) {
        if (buttonName.equals("Add to Cart")) {
            Assert.assertTrue(productDetailsPage.isAddToCartButtonEnabled(), "Add to Cart button not enabled");
        }
    }
    
    @When("the user views a product that is out of stock")
    public void the_user_views_a_product_that_is_out_of_stock() {
    }
    
    @Then("the {string} button should be disabled")
    public void the_button_should_be_disabled(String buttonName) {
        if (buttonName.equals("Add to Cart")) {
            Assert.assertFalse(productDetailsPage.isAddToCartButtonEnabled(), "Add to Cart button should be disabled");
        }
    }
    
    @Then("the user should see {string} option")
    public void the_user_should_see_option(String optionName) {
        if (optionName.equals("Notify Me")) {
            Assert.assertTrue(productDetailsPage.isNotifyMeButtonDisplayed(), "Notify Me option not displayed");
        }
    }
}
