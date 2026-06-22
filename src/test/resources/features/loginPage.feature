Feature: Login page

  Scenario: User enter email field but not input the password than click submit
    Given I open The Jakarta Post website
    When the page title should contain "The Jakarta Post"

    When click login button in header of website
    Then user should see login page

    When user fill email field in login page with "random@email.com"
    And click login button in login page
    Then user get error bellow password field with "Please enter a password."
