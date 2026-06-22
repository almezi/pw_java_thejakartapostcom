Feature: Login page

  Scenario: User enter email field but not input the password than click submit
    Given I open The Jakarta Post website
    When the page title should contain "The Jakarta Post"

    When click login button in header of website
    Then user should see login page