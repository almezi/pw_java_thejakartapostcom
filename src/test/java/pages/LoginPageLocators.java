package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import support.PlaywrightFactory;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPageLocators {
    private final Page page = PlaywrightFactory.getPage();
    public static final String LOGIN_PAGE_TITLE = "//h1[normalize-space()='WELCOME BACK']";
    public static final String INPUT_EMAIL = "//input[@id='email']";
    public static final String INPUT_PASSWORD = "//input[@id='password']";
    public static final String LOGIN_BUTTON = "//div[@class='form__action']//button";
    public static final String ERROR_MESSAGE = "//span[contains(@class,'jp-msg-password')]";
    public Locator loginPageTitle() {
        return page.locator(LOGIN_PAGE_TITLE);
    }
    public boolean isLoginPageDisplayed() {
        try {
            loginPageTitle().waitFor(new Locator.WaitForOptions()
                    .setState(WaitForSelectorState.VISIBLE)
                    .setTimeout(10000));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void inputEmail(String email){
        page.locator(INPUT_EMAIL).first().fill(email);
    }

    public void clickLoginButton(){
        page.locator(LOGIN_BUTTON).first().click();
    }
}