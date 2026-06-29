package pages;

import com.microsoft.playwright.Page;
import support.PlaywrightFactory;

public class LatestPageLocators {
    private final Page page = PlaywrightFactory.getPage();
    public static final String PREMIUM_ARTICLE_TITLE_LINK = "//span[@class='premiumBadge']/ancestor::div[@class='latestDetail']//h2";
    public static final String NON_PREMIUM_ARTICLE_TITLE = "//div[@class='latestDetail'][not(.//span[@class='premiumBadge'])]//h2";

    public void clickPremiumArticleTitleLink() {
        page.locator(PREMIUM_ARTICLE_TITLE_LINK).first().click();
    }

    public void clickNonPremiumArticleTitle() {
        page.locator(NON_PREMIUM_ARTICLE_TITLE).first().click();
    }
}
