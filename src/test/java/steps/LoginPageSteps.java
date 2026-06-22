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
    @Then("I should see login page")
    public void userShouldSeeLoginPage() {
        if (!loginPageLocators.isLoginPageDisplayed()) {
            throw new AssertionError("Login page is not displayed");
        }
    }

    @When("I fill the login email field with {string}")
    public void userFillEmailFieldInLoginPageWith(String inputEmail) {
        loginPageLocators.inputEmail(inputEmail);
    }

    @And("I click the login button on the login page")
    public void clickLoginButtonInLoginPage() {
        loginPageLocators.clickLoginButton();
    }

    @Then("I should see the password error message {string}")
    public void userGetErrorBellowPasswordFieldWith(String errorMessage) {
        assertThat(page.locator(LoginPageLocators.ERROR_MESSAGE_PASSWORD)).containsText(errorMessage);
    }

    @When("I fill the login password field with {string}")
    public void iFillTheLoginPasswordFieldWith(String inputPassword) {
        loginPageLocators.inputPassword(inputPassword);
    }

    @Then("I should see the email error message {string}")
    public void iShouldSeeTheEmailErrorMessage(String errorMessage) {
        assertThat(page.locator(LoginPageLocators.ERROR_MESSAGE_EMAIL)).containsText(errorMessage);
    }
}
