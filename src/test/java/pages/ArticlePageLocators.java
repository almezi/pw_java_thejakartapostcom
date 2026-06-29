package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import support.PlaywrightFactory;

public class ArticlePageLocators {
    private final Page page = PlaywrightFactory.getPage();
    public static final String PREMIUM_ARTICLE_BADGE = " //div[@class='tjp-meta__content-premium']";
    public static final String PAYWALL_ACTIVE_MESSAGE = "//h1[@class='tjp-paywall__title']";

    public Locator premiumArticleBadge() {
        return page.locator(PREMIUM_ARTICLE_BADGE);
    }
    public Locator paywallActiveMessage() {
        return page.locator(PAYWALL_ACTIVE_MESSAGE);
    }
}
