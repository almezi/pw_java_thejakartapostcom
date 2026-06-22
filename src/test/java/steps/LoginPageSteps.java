package steps;

import com.microsoft.playwright.Page;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPageLocators;
import support.PlaywrightFactory;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPageSteps {
    private final Page page = PlaywrightFactory.getPage();
    private final LoginPageLocators loginPageLocators = new LoginPageLocators();
    @Then("user should see login page")
    public void userShouldSeeLoginPage() {
        if (!loginPageLocators.isLoginPageDisplayed()) {
            throw new AssertionError("Login page is not displayed");
        }
    }

    @When("user fill email field in login page with {string}")
    public void userFillEmailFieldInLoginPageWith(String inputEmail) {
        loginPageLocators.inputEmail(inputEmail);
    }

    @And("click login button in login page")
    public void clickLoginButtonInLoginPage() {
        loginPageLocators.clickLoginButton();
    }

    @Then("user get error bellow password field with {string}")
    public void userGetErrorBellowPasswordFieldWith(String errorMessage) {
        assertThat(page.locator(LoginPageLocators.ERROR_MESSAGE)).containsText(errorMessage);
    }
}
