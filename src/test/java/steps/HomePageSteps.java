package steps;

import com.microsoft.playwright.Page;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePageLocators;
import support.PlaywrightFactory;

//import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageSteps {
    private final Page page = PlaywrightFactory.getPage();
    private HomePageLocators homePageLocators = new HomePageLocators();
    @Given("I open The Jakarta Post website")
    public void iOpenTheJakartaPostWebsite() {
        page.navigate("https://thejakartapost.com/");
        throw new PendingException();
    }

    @Then("the page title should contain {string}")
    public void thePageTitleShouldContain(String expectedText) {
        String actualText = homePageLocators.getJakartaPostLogo();

//        assertEquals(
//                expectedText,
//                actualText,
//                "Jakarta Post logo text is not correct"
//        );
        throw new PendingException();
    }
}
