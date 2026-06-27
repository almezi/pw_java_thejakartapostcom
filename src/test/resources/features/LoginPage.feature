Feature: Login page

  Background:
    Given I open The Jakarta Post website
    When the page title should contain "The Jakarta Post"

    When I click login button in header of website
    Then I should see login page

  @Regression
  @Negative
  Scenario: Show password required error when user submits login form without password
    When I fill the login email field with "random@email.com"
    And I click the login button on the login page
    Then I should see the password error message "Please enter a password."

  @Regression
  @Negative
  Scenario: Show email required error when user submits login form without email
    When I fill the login password field with "randomPassword"
    And I click the login button on the login page
    Then I should see the email error message "Please enter your email."

  @Regression
  @Negative
  Scenario: Show email and password error when user submit login form without email and password
    When I click the login button on the login page
    Then I should see the password error message "Please enter a password."
    And I should see the email error message "Please enter your email."

  @Regression
  @Negative
  Scenario: Show header message because the email and password is incorrect
    When I fill the login email field with "random@email.com"
    When I fill the login password field with "randomPassword"
    And I click the login button on the login page
    And I Should see the header error message "Your email address or password is incorrect. Please check and try again"

  @Regression
  @Positive
  Scenario: Show redirect page to contact us url after click register for organization
    When I click register as an organization in login page
    Then I should see redirect url to "contactUs"

  @Regression
  @Positive
  Scenario: Show redirect page to subscribe url after click register for organization
    When I click register as an personal in login page
    Then I should see redirect url to "subscribe"

  @Regression
  @Negative
  Scenario: Show the password field have password type and toggle is working fine
    When I fill the login password field with "randomPassword"
    Then I should see the password is have masking
    And I click toggle make sure it working fine
