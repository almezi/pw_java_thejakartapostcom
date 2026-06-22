package steps;

import io.cucumber.java.en.Then;
import pages.LoginPageLocators;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPageSteps {
    private final LoginPageLocators loginPageLocators = new LoginPageLocators();
    @Then("user should see login page")
    public void userShouldSeeLoginPage() {
        if (!loginPageLocators.isLoginPageDisplayed()) {
            throw new AssertionError("Login page is not displayed");
        }
    }
}
