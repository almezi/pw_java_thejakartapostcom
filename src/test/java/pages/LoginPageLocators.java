package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import support.PlaywrightFactory;

public class LoginPageLocators {
    private final Page page = PlaywrightFactory.getPage();
    public static final String LOGIN_PAGE_TITLE = "//h1[normalize-space()='WELCOME BACK']";

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
}
