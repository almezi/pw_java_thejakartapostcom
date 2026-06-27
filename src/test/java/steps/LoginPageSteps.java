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

    @And("I Should see the header error message {string}")
    public void iShouldSeeTheHeaderErrorMessage(String message) {
        assertThat(page.locator(LoginPageLocators.ERROR_MESSAGE_HEADER)).containsText(message);
    }

    @When("I click register as an organization in login page")
    public void iClickRegisterAsAnOrganizationInLoginPage() {
        loginPageLocators.clickRegisterAsAnOrganization();
    }

    @Then("I should see redirect url to {string}")
    public void iShouldSeeRedirectUrlTo(String url) {
        if (url.equals("contactUs")) {
            url = "https://www.thejakartapost.com/contact-us";
        }else if (url.equals("subscribe")) {
            url = "https://www.thejakartapost.com/subscribe?layout=new";
        }
        assertThat(page).hasURL(url);
    }

    @When("I click register as an personal in login page")
    public void iClickRegisterAsAnPersonalInLoginPage() {
        loginPageLocators.clickRegisterAsAnPersonal();
    }

    @Then("I should see the password is have masking")
    public void iShouldSeeThePasswordIsHaveMasking() {
        assertThat(page.locator(LoginPageLocators.PASSWORD_FIELD))
                .hasAttribute("type", "password");
    }

    @And("I click toggle make sure it working fine")
    public void iClickToggleMakeSureItWorkingFine() {
        loginPageLocators.clickTogglePassword();
        assertThat(page.locator(LoginPageLocators.PASSWORD_FIELD))
                .hasAttribute("type", "text");
    }
}
