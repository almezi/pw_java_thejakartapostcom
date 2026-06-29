Feature: Articles

  Background:
    Given I open The Jakarta Post website
    When the page title should contain "The Jakarta Post"

    When I click view more in the latest news
    Then I should see redirect url to "latest"

  @Regression
  @Positive
  Scenario: Open premium article
    When I click the first premium article
    Then I should see premium badge in the article
    When I Scroll down the page
    Then I should see paywall active

  @Regression
  @Positive
  Scenario: Open non premium article
    When I click the first non premium article
    Then I should not see premium badge in the article
    When I Scroll down the page
    Then i should not see paywall active
