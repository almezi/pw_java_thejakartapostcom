package steps;

import com.microsoft.playwright.Page;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ArticlePageLocators;
import support.PlaywrightFactory;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ArticlePageSteps {
    private final Page page = PlaywrightFactory.getPage();
    private final ArticlePageLocators articlePageLocators = new ArticlePageLocators();
    @Then("i should not see paywall active")
    public void iShouldNotSeePaywallActive() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("I should see premium badge in the article")
    public void iShouldSeePremiumBadgeInTheArticle() {
        assertThat(articlePageLocators.premiumArticleBadge()).isVisible();
    }

    @When("I Scroll down the page")
    public void iScrollDownThePage() {
        page.mouse().wheel(0, 1000);
    }


    @Then("I should see paywall active")
    public void iShouldSeePaywallActive() {


    }
}
