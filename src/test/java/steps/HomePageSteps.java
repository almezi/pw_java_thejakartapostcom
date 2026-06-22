package steps;

import com.microsoft.playwright.Page;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePageLocators;
import support.PlaywrightFactory;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePageSteps {
    private final Page page = PlaywrightFactory.getPage();
    private final HomePageLocators homePageLocators = new HomePageLocators();
    @Given("I open The Jakarta Post website")
    public void iOpenTheJakartaPostWebsite() {
        page.navigate("https://thejakartapost.com/");
    }

    @When("the page title should contain {string}")
    public void thePageTitleShouldContain(String expectedText) {
        assertThat(page.locator(homePageLocators.getJakartaPostLogo()).first())
                .containsText(expectedText);
    }

    @When("I click login button in header of website")
    public void clickLoginButtonInHeaderOfWebsite() {
        homePageLocators.clickLoginButton();
    }
}
