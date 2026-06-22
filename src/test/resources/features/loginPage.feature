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
