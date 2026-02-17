@authentication @Authentication
Feature: User Authentication and Account Management
  As a customer
  I want to be able to register, login, and manage my account
  So that I can access personalized features

  Background:
    Given the user is on the Commerza homepage

  @Signup @Regression
  Scenario: Successful user registration with valid credentials
    When the user navigates to the signup page
    And the user enters first name "John"
    And the user enters last name "Doe"
    And the user enters email "john.doe@example.com"
    And the user enters password "Test@123456"
    And the user enters confirm password "Test@123456"
    And the user agrees to terms and conditions
    And the user clicks on the signup button
    Then the user should see a successful registration message
    And the user should be redirected to the account page

  @Signup @NegativeTesting
  Scenario: User registration with existing email
    When the user navigates to the signup page
    And the user enters first name "Jane"
    And the user enters last name "Smith"
    And the user enters email "testuser@commerza.com"
    And the user enters password "Test@123456"
    And the user enters confirm password "Test@123456"
    And the user agrees to terms and conditions
    And the user clicks on the signup button
    Then the user should see an error message "Email already registered"

  @Signup @NegativeTesting
  Scenario Outline: User registration with invalid data
    When the user navigates to the signup page
    And the user enters first name "<firstName>"
    And the user enters last name "<lastName>"
    And the user enters email "<email>"
    And the user enters password "<password>"
    And the user enters confirm password "<confirmPassword>"
    And the user clicks on the signup button
    Then the user should see validation error for "<errorField>"

    Examples:
      | firstName | lastName | email              | password    | confirmPassword | errorField         |
      |           | Doe      | test@example.com   | Test@123    | Test@123        | firstName          |
      | John      |          | test@example.com   | Test@123    | Test@123        | lastName           |
      | John      | Doe      | invalidemail       | Test@123    | Test@123        | email              |
      | John      | Doe      | test@example.com   | 123         | 123             | password           |
      | John      | Doe      | test@example.com   | Test@123    | Test@456        | confirmPassword    |

  @Login @Smoke @Regression
  Scenario: Successful login with valid credentials
    When the user navigates to the login page
    And the user enters login email "testuser@commerza.com"
    And the user enters login password "Test@123"
    And the user clicks on the login button
    Then the user should be successfully logged in
    And the user should see their account dashboard

  @Login @NegativeTesting
  Scenario: Login with invalid credentials
    When the user navigates to the login page
    And the user enters login email "invalid@example.com"
    And the user enters login password "WrongPassword"
    And the user clicks on the login button
    Then the user should see login error message "Invalid email or password"

  @Login @NegativeTesting
  Scenario Outline: Login with missing credentials
    When the user navigates to the login page
    And the user enters login email "<email>"
    And the user enters login password "<password>"
    And the user clicks on the login button
    Then the user should see validation error for login "<field>"

    Examples:
      | email                  | password  | field    |
      |                        | Test@123  | email    |
      | test@example.com       |           | password |

  @ForgotPassword @Regression
  Scenario: Request password reset with valid email
    When the user navigates to the login page
    And the user clicks on forgot password link
    And the user enters reset email "testuser@commerza.com"
    And the user clicks on send reset link button
    Then the user should see password reset confirmation message

  @ForgotPassword @NegativeTesting
  Scenario: Request password reset with invalid email
    When the user navigates to the login page
    And the user clicks on forgot password link
    And the user enters reset email "nonexistent@example.com"
    And the user clicks on send reset link button
    Then the user should see error message "No account found"

  @AccountManagement @Regression
  Scenario: View account details
    Given the user is logged in with email "testuser@commerza.com" and password "Test@123"
    When the user navigates to account page
    Then the user should see their profile information
    And the user should see account navigation menu

  @AccountManagement @Regression
  Scenario: Update profile information
    Given the user is logged in with email "testuser@commerza.com" and password "Test@123"
    When the user navigates to account page
    And the user clicks on edit profile
    And the user updates first name to "Updated"
    And the user updates phone number to "+923001234567"
    And the user clicks on save changes
    Then the user should see profile update success message
    And the updated information should be displayed

  @AccountManagement @Regression
  Scenario: Change password successfully
    Given the user is logged in with email "testuser@commerza.com" and password "Test@123"
    When the user navigates to account page
    And the user clicks on change password
    And the user enters current password "Test@123"
    And the user enters new password "NewTest@123"
    And the user enters confirm new password "NewTest@123"
    And the user clicks on update password button
    Then the user should see password change success message

  @Logout @Smoke
  Scenario: User logout
    Given the user is logged in with email "testuser@commerza.com" and password "Test@123"
    When the user clicks on logout button
    Then the user should be logged out successfully
    And the user should be redirected to the homepage
