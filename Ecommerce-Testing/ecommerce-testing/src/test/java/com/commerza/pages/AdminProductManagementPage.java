package com.commerza.pages;

import com.commerza.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminProductManagementPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By addProductButton = By.id("addBtn");
	private By productsList = By.id("productsSection");
	private By productsTable = By.cssSelector("#productsTableBody");
	private By productItems = By.cssSelector(".product-row");
	private By productNameField = By.id("productName");
	private By productSKUField = By.id("productSKU");
	private By productPriceField = By.id("productPrice");
	private By productCategorySelect = By.id("productCategory");
	private By productDescriptionField = By.id("productDescription");
	private By stockQuantityField = By.id("productStock");
	private By productImageUpload = By.id("productImage");
	private By saveProductButton = By.cssSelector(".btn-save-product");
	private By updateProductButton = By.cssSelector(".btn-update-product");
	private By editButtons = By.cssSelector(".btn-edit");
	private By deleteButtons = By.cssSelector(".btn-delete");
	private By confirmDeleteButton = By.cssSelector(".btn-confirm-delete");
	private By successMessage = By.id("adminAlert");
	private By validationError = By.id("adminAlert");
	private By featuredCheckbox = By.id("productFeatured");
	private By saveChangesButton = By.cssSelector(".btn-primary");

	public AdminProductManagementPage(WebDriver driver) {
		this.driver = driver;
		this.elementUtils = new ElementUtils(driver);
	}

	public void clickAddProduct() {
		elementUtils.click(addProductButton);
	}

	public void enterProductName(String name) {
		elementUtils.sendKeys(productNameField, name);
	}

	public void enterSKU(String sku) {
		elementUtils.sendKeys(productSKUField, sku);
	}

	public void enterPrice(String price) {
		elementUtils.sendKeys(productPriceField, price);
	}

	public void selectCategory(String category) {
		driver.findElement(By.xpath("//select[@id='product-category']/option[contains(text(),'" + category + "')]")).click();
	}

	public void enterDescription(String description) {
		elementUtils.sendKeys(productDescriptionField, description);
	}

	public void enterStockQuantity(String quantity) {
		elementUtils.sendKeys(stockQuantityField, quantity);
	}

	public void uploadImage(String imagePath) {
		driver.findElement(productImageUpload).sendKeys(imagePath);
	}

	public void clickSaveProduct() {
		elementUtils.click(saveProductButton);
	}

	public void clickUpdateProduct() {
		elementUtils.click(updateProductButton);
	}

	public boolean isSuccessMessageDisplayed() {
		return elementUtils.isDisplayed(successMessage);
	}

	public String getSuccessMessage() {
		return elementUtils.getText(successMessage);
	}

	public boolean areProductsDisplayed() {
		return !driver.findElements(productItems).isEmpty();
	}

	public void clickEditProduct(int index) {
		List<WebElement> editButtonsList = driver.findElements(editButtons);
		if (index < editButtonsList.size()) {
			editButtonsList.get(index).click();
		}
	}

	public void clickDeleteProduct(int index) {
		List<WebElement> deleteButtonsList = driver.findElements(deleteButtons);
		if (index < deleteButtonsList.size()) {
			deleteButtonsList.get(index).click();
		}
	}

	public void confirmDeletion() {
		elementUtils.click(confirmDeleteButton);
	}

	public boolean isValidationErrorDisplayed() {
		return elementUtils.isDisplayed(validationError);
	}

	public void markAsFeatured() {
		if (!driver.findElement(featuredCheckbox).isSelected()) {
			elementUtils.click(featuredCheckbox);
		}
	}

	public void clickSaveChanges() {
		elementUtils.click(saveChangesButton);
	}

	public int getProductCount() {
		return driver.findElements(productItems).size();
	}
}
