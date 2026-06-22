Feature: Login page

  Background:
    Given I open The Jakarta Post website
    When the page title should contain "The Jakarta Post"

    When I click login button in header of website
    Then I should see login page

  Scenario: Show password required error when user submits login form without password
    When I fill the login email field with "random@email.com"
    And I click the login button on the login page
    Then I should see the password error message "Please enter a password."

  Scenario: Show email required error when user submits login form without email
    When I fill the login password field with "random@email.com"
    And I click the login button on the login page
    Then I should see the email error message "Please enter your email."

  Scenario: Show email and password error when user submit login form without email and password
    And I click the login button on the login page
    Then I should see the password error message "Please enter a password."
    Then I should see the email error message "Please enter your email."

