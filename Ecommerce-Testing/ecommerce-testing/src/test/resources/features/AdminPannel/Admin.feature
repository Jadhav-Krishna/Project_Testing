@AdminTest
Feature: Admin Panel and Order Management
  As an admin
  I want to manage products, orders, and website content
  So that I can operate the e-commerce platform effectively

  Background:
    Given the admin navigates to admin login page

  @AdminLogin @Smoke @Regression
  Scenario: Successful admin login with valid credentials
    When the admin enters valid admin email
    And the admin enters valid admin password
    And the admin clicks on admin login button
    Then the admin should be logged in successfully
    And the admin should see the admin dashboard
    And the driver clears local storage

  @AdminLogin @NegativeTesting
  Scenario: Admin login with invalid credentials
    When the admin enters invalid admin email
    And the admin enters invalid admin password
    And the admin clicks on admin login button
    Then the admin should see admin login error message
    And the admin should not be able to access dashboard
    And the driver clears local storage

  @AdminLogin @Regression
  Scenario: Admin forgot password
    When the admin clicks on admin forgot password link
    And the admin clicks on send admin reset link
    Then the admin should see password reset email confirmation
    And the driver clears local storage

  @ProductManagement @Smoke @Regression
  Scenario: Add new product
    Given the admin is logged in to admin panel
    When the admin navigates to products management section
    And the admin clicks on add new product button
    And the admin enters product details
      | Field            | Value                          |
      | Product Name     | Premium Automatic Watch        |
      | Section          | Automatic                      |
      | Price            | 4500                           |
      | SalePrice        | 2500                           |
      | Stock Quantity   | 50                             |
      | Movement Type    | Quartz                         |
      | Image Path       | Image placeholder              |
      | Description      | Elegant automatic watch        |
    And the admin uploads product images
    And the admin clicks save product button
    Then the product should be added successfully
    And the admin should see success message "Product added"
    And the driver clears local storage

  @ProductManagement @Regression
  Scenario: Edit existing product
    Given the admin is logged in to admin panel
    When the admin navigates to products management section
    And the admin clicks on edit button for a product
    And the admin updates product name to "Updated Watch Name"
    And the admin updates product price to "5000"
    And the admin clicks update product button
    Then the product should be updated successfully
    And the updated details should be saved
    And the driver clears local storage

  @ProductManagement @Regression
  Scenario: Delete product
    Given the admin is logged in to admin panel
    And there are existing products in the system
    When the admin navigates to products management section
    And the admin clicks on delete button for a product
    And the admin confirms deletion
    Then the product should be deleted successfully
    And the product should no longer appear in product list
    And the driver clears local storage

  @ProductManagement @Regression
  Scenario: Update product stock
    Given the admin is logged in to admin panel
    When the admin navigates to products management section
    And the admin clicks on a product to edit
    And the admin updates stock quantity to "100"
    And the admin clicks save changes
    Then the stock quantity should be updated
    And the updated stock should be reflected
    And the driver clears local storage

  @ProductManagement @Regression
  Scenario: Set product as featured
    Given the admin is logged in to admin panel
    When the admin navigates to products management section
    And the admin selects a product
    And the admin marks product as featured
    And the admin saves changes
    Then the product should appear in featured section
    And the driver clears local storage

  @ProductManagement @NegativeTesting
  Scenario Outline: Add product with missing required fields
    Given the admin is logged in to admin panel
    When the admin navigates to products management section
    And the admin clicks on add new product button
    And the admin leaves "<field>" empty
    And the admin clicks save product button
    Then the admin should see validation error for "<field>"
    And the driver clears local storage

    Examples:
      | field           |
      | Product Name    |
      | Price           |
      | Category        |
      | Stock Quantity  |

  @OrderManagement @Smoke @Regression
  Scenario: View all orders
    Given the admin is logged in to admin panel
    When the admin navigates to orders management section
    Then the admin should see list of all orders
    And each order should display order number
    And each order should display customer name
    And each order should display order date
    And each order should display order status
    And each order should display total amount
    And the driver clears local storage

  @OrderManagement @Regression
  Scenario: View order details
    Given the admin is logged in to admin panel
    And there are orders in the system
    When the admin navigates to orders management section
    And the admin clicks on an order to view details
    Then the admin should see complete order information
    And order details should include customer information
    And order details should include shipping address
    And order details should include order items
    And order details should include payment method
    And the driver clears local storage

  @OrderManagement @Regression
  Scenario: Update order status
    Given the admin is logged in to admin panel
    And there are pending orders
    When the admin navigates to orders management section
    And the admin clicks on an order
    And the admin changes order status to "Processing"
    And the admin saves the changes
    Then the order status should be updated to "Processing"
    And the customer should receive status update notification
    And the driver clears local storage

  @OrderManagement @Regression
  Scenario Outline: Change order status through workflow
    Given the admin is logged in to admin panel
    And there is an order with status "<currentStatus>"
    When the admin updates the order status to "<newStatus>"
    Then the order status should change to "<newStatus>"
    And the status timeline should be updated
    And the driver clears local storage

    Examples:
      | currentStatus | newStatus   |
      | Pending       | Processing  |
      | Processing    | Shipped     |
      | Shipped       | Delivered   |

  @OrderManagement @Regression
  Scenario: Search orders by order number
    Given the admin is logged in to admin panel
    When the admin navigates to orders management section
    And the admin enters order number "ORD123456" in search
    And the admin clicks search button
    Then the admin should see the matching order
    And the driver clears local storage

  @OrderManagement @Regression
  Scenario: Filter orders by status
    Given the admin is logged in to admin panel
    When the admin navigates to orders management section
    And the admin selects filter by status "Pending"
    Then only orders with "Pending" status should be displayed
    And the driver clears local storage

  @OrderManagement @Regression
  Scenario: Filter orders by date range
    Given the admin is logged in to admin panel
    When the admin navigates to orders management section
    And the admin sets date range from "2024-01-01" to "2024-12-31"
    And the admin applies filter
    Then orders within the date range should be displayed
    And the driver clears local storage

  @OrderManagement @Regression
  Scenario: Cancel order
    Given the admin is logged in to admin panel
    And there is a pending order
    When the admin navigates to orders management section
    And the admin clicks on the order
    And the admin clicks cancel order button
    And the admin enters cancellation reason "Out of stock"
    And the admin confirms cancellation
    Then the order should be cancelled
    And the customer should be notified
    And the driver clears local storage

  @OrderManagement @Regression
  Scenario: Process refund for returned order
    Given the admin is logged in to admin panel
    And there is a return request
    When the admin navigates to returns section
    And the admin approves the return
    And the admin processes refund
    Then the refund should be processed
    And the order status should update to "Refunded"
    And the driver clears local storage

  @CustomerManagement @Regression
  Scenario: View all customers
    Given the admin is logged in to admin panel
    When the admin navigates to customers section
    Then the admin should see list of all customers
    And each customer should display name
    And each customer should display email
    And each customer should display registration date
    And each customer should display total orders
    And the driver clears local storage

  @CustomerManagement @Regression
  Scenario: View customer details
    Given the admin is logged in to admin panel
    When the admin navigates to customers section
    And the admin clicks on a customer
    Then the admin should see customer profile
    And profile should show customer orders history
    And profile should show customer addresses
    And profile should show total spent
    And the driver clears local storage

  @CustomerManagement @Regression
  Scenario: Search customers
    Given the admin is logged in to admin panel
    When the admin navigates to customers section
    And the admin enters customer email in search
    And the admin clicks search
    Then the matching customer should be displayed
    And the driver clears local storage

  @CustomerManagement @Regression
  Scenario: Deactivate customer account
    Given the admin is logged in to admin panel
    When the admin navigates to customers section
    And the admin clicks on a customer
    And the admin clicks deactivate account button
    And the admin confirms deactivation
    Then the customer account should be deactivated
    And the customer should not be able to login
    And the driver clears local storage

  @ContentManagement @Regression
  Scenario: Update homepage banner
    Given the admin is logged in to admin panel
    When the admin navigates to content management
    And the admin clicks on homepage settings
    And the admin uploads new banner image
    And the admin enters banner text "Special Offer"
    And the admin clicks save changes
    Then the homepage banner should be updated
    And the driver clears local storage

  @ContentManagement @Regression
  Scenario: Update featured products section
    Given the admin is logged in to admin panel
    When the admin navigates to content management
    And the admin clicks on featured products settings
    And the admin selects products for featured section
    And the admin saves the selection
    Then the featured products should be updated on homepage
    And the driver clears local storage

  @ContentManagement @Regression
  Scenario: Update website information
    Given the admin is logged in to admin panel
    When the admin navigates to website settings
    And the admin updates company phone number
    And the admin updates company email
    And the admin updates company address
    And the admin clicks save settings
    Then the website information should be updated
    And the driver clears local storage

  @CategoryManagement @Regression
  Scenario: Add new category
    Given the admin is logged in to admin panel
    When the admin navigates to categories section
    And the admin clicks add new category
    And the admin enters category name "Luxury Watches"
    And the admin enters category description
    And the admin clicks save category
    Then the category should be created successfully
    And the driver clears local storage

  @CategoryManagement @Regression
  Scenario: Edit category
    Given the admin is logged in to admin panel
    And there are existing categories
    When the admin navigates to categories section
    And the admin clicks edit on a category
    And the admin updates category name
    And the admin saves changes
    Then the category should be updated
    And the driver clears local storage

  @CategoryManagement @Regression
  Scenario: Delete category
    Given the admin is logged in to admin panel
    And there is a category with no products
    When the admin navigates to categories section
    And the admin clicks delete on the category
    And the admin confirms deletion
    Then the category should be deleted
    And the driver clears local storage

  @Dashboard @Smoke @Regression
  Scenario: View dashboard statistics
    Given the admin is logged in to admin panel
    When the admin is on the dashboard
    Then the admin should see total orders count
    And the admin should see total revenue
    And the admin should see total customers
    And the admin should see pending orders count
    And the admin should see recent orders list
    And the driver clears local storage

  @Dashboard @Regression
  Scenario: View sales chart
    Given the admin is logged in to admin panel
    When the admin is on the dashboard
    Then the admin should see sales chart
    And the chart should display sales data
    And the admin can select different time periods
    And the driver clears local storage

  @Reports @Regression
  Scenario: Generate sales report
    Given the admin is logged in to admin panel
    When the admin navigates to reports section
    And the admin selects sales report
    And the admin sets date range
    And the admin clicks generate report
    Then the sales report should be generated
    And the report should show total sales
    And the report should show order count
    And the driver clears local storage

  @Reports @Regression
  Scenario: Export orders to CSV
    Given the admin is logged in to admin panel
    When the admin navigates to orders section
    And the admin clicks export button
    And the admin selects CSV format
    Then the orders should be exported to CSV file
    And the driver clears local storage
