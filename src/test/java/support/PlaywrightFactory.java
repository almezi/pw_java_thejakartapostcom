package support;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {
    private static Playwright playwright;
    private static Browser browser;
    private static Page page;

    public static Page getPage() {
        if (page == null) {
            playwright = Playwright.create();
            boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(headless)
            );

            page = browser.newPage();
        }

        return page;
    }

    public static void close() {
        if (page != null) {
            page.close();
            page = null;
        }

        if (browser != null) {
            browser.close();
            browser = null;
        }

        if (playwright != null) {
            playwright.close();
            playwright = null;
        }
    }
}
