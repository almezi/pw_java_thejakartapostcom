package pages;


import com.microsoft.playwright.Page;
import support.PlaywrightFactory;

public class HomePageLocators {
    private final Page page = PlaywrightFactory.getPage();

    public static final String JAKARTA_POST_LOGO = "//h1[@class='thejakartapost']";
    public static final String LOGIN_BUTTON = "//a[contains(@class,'login btn-login-new')]";
    public String getJakartaPostLogo() {
        return JAKARTA_POST_LOGO;
    }
    public void clickLoginButton() {
        page.locator(LOGIN_BUTTON).first().click();
    }
}
