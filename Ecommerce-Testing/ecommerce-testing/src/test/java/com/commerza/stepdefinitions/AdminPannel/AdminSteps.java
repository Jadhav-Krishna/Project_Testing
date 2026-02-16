package com.commerza.stepdefinitions.AdminPannel;

import org.openqa.selenium.WebDriver;

import com.commerza.pages.AdminLoginPage;
import com.commerza.utils.ConfigReader;
import com.commerza.utils.DriverManager;
import com.commerza.utils.ElementUtils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class AdminSteps {
	private WebDriver driver;
	private AdminLoginPage adminPage;

	public AdminSteps() {
		this.driver = DriverManager.getDriver();

		this.adminPage = new AdminLoginPage(this.driver);
	}

	@Given("the admin navigates to admin login page")
	public void the_admin_navigates_to_admin_login_page() {
		adminPage.navigateToAdminLoginPage(ConfigReader.getAdminUrl());
	}

	@Given("the admin is logged in to admin panel")
	public void the_admin_is_logged_in_to_admin_panel() {
		adminPage.login(ConfigReader.getAdminEmail(), ConfigReader.getAdminPassword());
	}

	@When("the admin navigates to categories section")
	public void the_admin_navigates_to_categories_section() {
	}

	@When("the admin clicks add new category")
	public void the_admin_clicks_add_new_category() {
	}

	@When("the admin enters category name {string}")
	public void the_admin_enters_category_name(String string) {
	}

	@When("the admin enters category description")
	public void the_admin_enters_category_description() {
	}

	@When("the admin clicks save category")
	public void the_admin_clicks_save_category() {
	}

	@Then("the category should be created successfully")
	public void the_category_should_be_created_successfully() {
	}

	@When("the admin navigates to products management section")
	public void the_admin_navigates_to_products_management_section() {
	}

	@When("the admin clicks on add new product button")
	public void the_admin_clicks_on_add_new_product_button() {
	}

	@When("the admin enters product details")
	public void the_admin_enters_product_details(DataTable dataTable) {
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
	}

	@When("the admin uploads product images")
	public void the_admin_uploads_product_images() {
	}

	@When("the admin clicks save product button")
	public void the_admin_clicks_save_product_button() {
	}

	@Then("the product should be added successfully")
	public void the_product_should_be_added_successfully() {
	}

	@Then("the admin should see success message {string}")
	public void the_admin_should_see_success_message(String string) {
	}

	@When("the admin leaves {string} empty")
	public void the_admin_leaves_empty(String string) {
	}

	@Then("the admin should see validation error for {string}")
	public void the_admin_should_see_validation_error_for(String string) {
	}

	@When("the admin clicks on admin forgot password link")
	public void the_admin_clicks_on_admin_forgot_password_link() {
	}

	@When("the admin enters admin email for reset {string}")
	public void the_admin_enters_admin_email_for_reset(String string) {
		adminPage.enterEmail(string);
	}

	@When("the admin clicks on send admin reset link")
	public void the_admin_clicks_on_send_admin_reset_link() {
	}

	@Then("the admin should see password reset email confirmation")
	public void the_admin_should_see_password_reset_email_confirmation() {
	}

	@When("the admin enters admin email {string}")
	public void the_admin_enters_admin_email(String string) {
		adminPage.enterEmail(string);
	}

	@When("the admin enters admin password {string}")
	public void the_admin_enters_admin_password(String string) {
		adminPage.enterPassword(string);
	}

	@When("the admin clicks on admin login button")
	public void the_admin_clicks_on_admin_login_button() {
		adminPage.clickLoginButton();
	}

	@Then("the admin should see admin login error message")
	public void the_admin_should_see_admin_login_error_message() {
	}

	@Then("the admin should not be able to access dashboard")
	public void the_admin_should_not_be_able_to_access_dashboard() {
	}

	@When("the admin clicks on logout button")
	public void the_admin_clicks_on_logout_button() {
	}

	@Then("the admin should be logged out")
	public void the_admin_should_be_logged_out() {
	}

	@Then("the admin should be redirected to login page")
	public void the_admin_should_be_redirected_to_login_page() {
	}

	@Given("there is a pending order")
	public void there_is_a_pending_order() {
	}

	@When("the admin navigates to orders management section")
	public void the_admin_navigates_to_orders_management_section() {
	}

	@When("the admin clicks on the order")
	public void the_admin_clicks_on_the_order() {
	}

	@When("the admin clicks cancel order button")
	public void the_admin_clicks_cancel_order_button() {
	}

	@When("the admin enters cancellation reason {string}")
	public void the_admin_enters_cancellation_reason(String string) {
	}

	@When("the admin confirms cancellation")
	public void the_admin_confirms_cancellation() {
	}

	@Then("the order should be cancelled")
	public void the_order_should_be_cancelled() {
	}

	@Then("the customer should be notified")
	public void the_customer_should_be_notified() {
	}

	@Given("there is an order with status {string}")
	public void there_is_an_order_with_status(String string) {
	}

	@When("the admin updates the order status to {string}")
	public void the_admin_updates_the_order_status_to(String string) {
	}

	@Then("the order status should change to {string}")
	public void the_order_status_should_change_to(String string) {
	}

	@Then("the status timeline should be updated")
	public void the_status_timeline_should_be_updated() {
	}

	@When("the admin navigates to customers section")
	public void the_admin_navigates_to_customers_section() {
	}

	@When("the admin clicks on a customer")
	public void the_admin_clicks_on_a_customer() {
	}

	@When("the admin clicks deactivate account button")
	public void the_admin_clicks_deactivate_account_button() {
	}

	@When("the admin confirms deactivation")
	public void the_admin_confirms_deactivation() {
	}

	@Then("the customer account should be deactivated")
	public void the_customer_account_should_be_deactivated() {
	}

	@Then("the customer should not be able to login")
	public void the_customer_should_not_be_able_to_login() {
	}

	@Given("there is a category with no products")
	public void there_is_a_category_with_no_products() {
	}

		@When("the admin clicks delete on the category")
	public void the_admin_clicks_delete_on_the_category() {
	}

	@When("the admin confirms deletion")
	public void the_admin_confirms_deletion() {
	}

	@Then("the category should be deleted")
	public void the_category_should_be_deleted() {
	}

	@Given("there are existing products in the system")
	public void there_are_existing_products_in_the_system() {
	}

	@When("the admin clicks on delete button for a product")
	public void the_admin_clicks_on_delete_button_for_a_product() {
	}

	@Then("the product should be deleted successfully")
	public void the_product_should_be_deleted_successfully() {
	}

	@Then("the product should no longer appear in product list")
	public void the_product_should_no_longer_appear_in_product_list() {
	}

	@Given("there are existing categories")
	public void there_are_existing_categories() {
	}

		@When("the admin clicks edit on a category")
	public void the_admin_clicks_edit_on_a_category() {
	}

	@When("the admin updates category name")
	public void the_admin_updates_category_name() {
	}

	@When("the admin saves changes")
	public void the_admin_saves_changes() {
	}

	@Then("the category should be updated")
	public void the_category_should_be_updated() {
	}

	@When("the admin clicks on edit button for a product")
	public void the_admin_clicks_on_edit_button_for_a_product() {
	}

	@When("the admin updates product name to {string}")
	public void the_admin_updates_product_name_to(String string) {
	}

	@When("the admin updates product price to {string}")
	public void the_admin_updates_product_price_to(String string) {
	}

	@When("the admin clicks update product button")
	public void the_admin_clicks_update_product_button() {
	}

	@Then("the product should be updated successfully")
	public void the_product_should_be_updated_successfully() {
	}

	@Then("the updated details should be saved")
	public void the_updated_details_should_be_saved() {
	}

	@When("the admin navigates to orders section")
	public void the_admin_navigates_to_orders_section() {
	}

	@When("the admin clicks export button")
	public void the_admin_clicks_export_button() {
	}

	@When("the admin selects CSV format")
	public void the_admin_selects_csv_format() {
	}

	@Then("the orders should be exported to CSV file")
	public void the_orders_should_be_exported_to_csv_file() {
	}

	@When("the admin sets date range from {string} to {string}")
	public void the_admin_sets_date_range_from_to(String string, String string2) {
	}

	@When("the admin applies filter")
	public void the_admin_applies_filter() {
	}

	@Then("orders within the date range should be displayed")
	public void orders_within_the_date_range_should_be_displayed() {
	}

	@When("the admin selects filter by status {string}")
	public void the_admin_selects_filter_by_status(String string) {
	}

	@Then("only orders with {string} status should be displayed")
	public void only_orders_with_status_should_be_displayed(String string) {
	}

	@When("the admin navigates to reports section")
	public void the_admin_navigates_to_reports_section() {
	}

	@When("the admin selects sales report")
	public void the_admin_selects_sales_report() {
	}

	@When("the admin sets date range")
	public void the_admin_sets_date_range() {
	}

	@When("the admin clicks generate report")
	public void the_admin_clicks_generate_report() {
	}

	@Then("the sales report should be generated")
	public void the_sales_report_should_be_generated() {
	}

	@Then("the report should show total sales")
	public void the_report_should_show_total_sales() {
	}

	@Then("the report should show order count")
	public void the_report_should_show_order_count() {
	}

	@Given("there is a return request")
	public void there_is_a_return_request() {
	}

	@When("the admin navigates to returns section")
	public void the_admin_navigates_to_returns_section() {
	}

	@When("the admin approves the return")
	public void the_admin_approves_the_return() {
	}

	@When("the admin processes refund")
	public void the_admin_processes_refund() {
	}

	@Then("the refund should be processed")
	public void the_refund_should_be_processed() {
	}

	@Then("the order status should update to {string}")
	public void the_order_status_should_update_to(String string) {
	}

	@When("the admin enters customer email in search")
	public void the_admin_enters_customer_email_in_search() {
	}

	@When("the admin clicks search")
	public void the_admin_clicks_search() {
	}

	@Then("the matching customer should be displayed")
	public void the_matching_customer_should_be_displayed() {
	}

	@When("the admin enters order number {string} in search")
	public void the_admin_enters_order_number_in_search(String string) {
	}

	@When("the admin clicks search button")
	public void the_admin_clicks_search_button() {
	}

	@Then("the admin should see the matching order")
	public void the_admin_should_see_the_matching_order() {
	}

	@When("the admin selects a product")
	public void the_admin_selects_a_product() {
	}

	@When("the admin marks product as featured")
	public void the_admin_marks_product_as_featured() {
	}

	@Then("the product should appear in featured section")
	public void the_product_should_appear_in_featured_section() {
	}

	@Then("the admin should be logged in successfully")
	public void the_admin_should_be_logged_in_successfully() {
	}

	@Then("the admin should see the admin dashboard")
	public void the_admin_should_see_the_admin_dashboard() {
	}

	@When("the admin navigates to content management")
	public void the_admin_navigates_to_content_management() {
	}

	@When("the admin clicks on featured products settings")
	public void the_admin_clicks_on_featured_products_settings() {
	}

	@When("the admin selects products for featured section")
	public void the_admin_selects_products_for_featured_section() {
	}

	@When("the admin saves the selection")
	public void the_admin_saves_the_selection() {
	}

	@Then("the featured products should be updated on homepage")
	public void the_featured_products_should_be_updated_on_homepage() {
	}

	@When("the admin clicks on homepage settings")
	public void the_admin_clicks_on_homepage_settings() {
	}

	@When("the admin uploads new banner image")
	public void the_admin_uploads_new_banner_image() {
	}

	@When("the admin enters banner text {string}")
	public void the_admin_enters_banner_text(String string) {
	}

	@When("the admin clicks save changes")
	public void the_admin_clicks_save_changes() {
	}

	@Then("the homepage banner should be updated")
	public void the_homepage_banner_should_be_updated() {
	}

	@Given("there are pending orders")
	public void there_are_pending_orders() {
	}

	@When("the admin clicks on an order")
	public void the_admin_clicks_on_an_order() {
	}

	@When("the admin changes order status to {string}")
	public void the_admin_changes_order_status_to(String string) {
	}

	@When("the admin saves the changes")
	public void the_admin_saves_the_changes() {
	}

	@Then("the order status should be updated to {string}")
	public void the_order_status_should_be_updated_to(String string) {
	}

	@Then("the customer should receive status update notification")
	public void the_customer_should_receive_status_update_notification() {
	}

	@When("the admin clicks on a product to edit")
	public void the_admin_clicks_on_a_product_to_edit() {
	}

	@When("the admin updates stock quantity to {string}")
	public void the_admin_updates_stock_quantity_to(String string) {
	}

	@Then("the stock quantity should be updated")
	public void the_stock_quantity_should_be_updated() {
	}

	@Then("the updated stock should be reflected")
	public void the_updated_stock_should_be_reflected() {
	}

	@When("the admin navigates to website settings")
	public void the_admin_navigates_to_website_settings() {
	}

	@When("the admin updates company phone number")
	public void the_admin_updates_company_phone_number() {
	}

	@When("the admin updates company email")
	public void the_admin_updates_company_email() {
	}

	@When("the admin updates company address")
	public void the_admin_updates_company_address() {
	}

	@When("the admin clicks save settings")
	public void the_admin_clicks_save_settings() {
	}

	@Then("the website information should be updated")
	public void the_website_information_should_be_updated() {
	}

	@Then("the admin should see list of all customers")
	public void the_admin_should_see_list_of_all_customers() {
	}

	@Then("each customer should display name")
	public void each_customer_should_display_name() {
	}

	@Then("each customer should display email")
	public void each_customer_should_display_email() {
	}

	@Then("each customer should display registration date")
	public void each_customer_should_display_registration_date() {
	}

	@Then("each customer should display total orders")
	public void each_customer_should_display_total_orders() {
	}

	@Then("the admin should see list of all orders")
	public void the_admin_should_see_list_of_all_orders() {
	}

	@Then("each order should display order number")
	public void each_order_should_display_order_number() {
	}

	@Then("each order should display customer name")
	public void each_order_should_display_customer_name() {
	}

	@Then("each order should display order date")
	public void each_order_should_display_order_date() {
	}

	@Then("each order should display order status")
	public void each_order_should_display_order_status() {
	}

	@Then("each order should display total amount")
	public void each_order_should_display_total_amount() {
	}

	@Then("the admin should see customer profile")
	public void the_admin_should_see_customer_profile() {
	}

	@Then("profile should show customer orders history")
	public void profile_should_show_customer_orders_history() {
	}

	@Then("profile should show customer addresses")
	public void profile_should_show_customer_addresses() {
	}

	@Then("profile should show total spent")
	public void profile_should_show_total_spent() {
	}

	@When("the admin is on the dashboard")
	public void the_admin_is_on_the_dashboard() {
	}

	@Then("the admin should see total orders count")
	public void the_admin_should_see_total_orders_count() {
	}

	@Then("the admin should see total revenue")
	public void the_admin_should_see_total_revenue() {
	}

	@Then("the admin should see total customers")
	public void the_admin_should_see_total_customers() {
	}

	@Then("the admin should see pending orders count")
	public void the_admin_should_see_pending_orders_count() {
	}

	@Then("the admin should see recent orders list")
	public void the_admin_should_see_recent_orders_list() {
	}

	@Given("there are orders in the system")
	public void there_are_orders_in_the_system() {
	}

	@When("the admin clicks on an order to view details")
	public void the_admin_clicks_on_an_order_to_view_details() {
	}

	@Then("the admin should see complete order information")
	public void the_admin_should_see_complete_order_information() {
	}

	@Then("order details should include customer information")
	public void order_details_should_include_customer_information() {
	}

	@Then("order details should include shipping address")
	public void order_details_should_include_shipping_address() {
	}

	@Then("order details should include order items")
	public void order_details_should_include_order_items() {
	}

	@Then("order details should include payment method")
	public void order_details_should_include_payment_method() {
	}

	@Then("the admin should see sales chart")
	public void the_admin_should_see_sales_chart() {
	}

	@Then("the chart should display sales data")
	public void the_chart_should_display_sales_data() {
	}

	@Then("the admin can select different time periods")
	public void the_admin_can_select_different_time_periods() {
	}
}
