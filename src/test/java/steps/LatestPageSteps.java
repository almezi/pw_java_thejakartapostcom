package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LatestPageLocators;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LatestPageSteps {
    LatestPageLocators latestPageLocators = new LatestPageLocators();
    @When("I click the first premium article")
    public void iClickTheFirstPremiumArticle() {
        latestPageLocators.clickPremiumArticleTitleLink();
    }

    @When("I click the first non premium article")
    public void iClickTheFirstNonPremiumArticle() {
        latestPageLocators.clickNonPremiumArticleTitle();
    }


}
