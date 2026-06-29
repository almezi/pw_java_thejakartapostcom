# Playwright Java Automation - The Jakarta Post

This project is an automated test suite designed for verifying the core functionalities of The Jakarta Post website. It utilizes modern automation tools to ensure reliability and consistency across critical user paths. And only can run in the local mechine.

## 1. What the project is

An automated testing framework built with Java and Playwright, following the BDD (Behavior Driven Development) approach with Cucumber. It focuses on UI validation, negative testing, and ensuring key navigation flows work as expected.

## 2. What site it targets

- **Target Site**: [The Jakarta Post](https://www.thejakartapost.com)

## 3. Tech Stack

- **Java Version**: 17
- **Playwright Version**: 1.60.0
- **Test Framework**: JUnit 5 + Cucumber
- **Reporting Tool**: Cucumber HTML Report / JSON Report
- **CI Platform**: GitHub Actions

## 4. Project Structure

```text
.
├── src/test/java
│   ├── pages       # Page Object Model locators and logic
│   ├── runners     # Cucumber test execution entry points (JUnit 5 Suite)
│   ├── steps       # Gherkin step definitions
│   └── support     # Configuration, Hooks, and Playwright Factory
├── src/test/resources
│   └── features    # Gherkin feature files defining test scenarios
├── pom.xml         # Maven project configuration and dependencies
└── target          # Test output, including logs and HTML reports
```

## 5. README Explanation

### How to run locally
1. Clone the repository.
2. Open a terminal in the project root.
3. Run the tests using Maven:
   ```bash
   mvn test
   ```

### How to run headless/headed
By default, tests run in **headless** mode. To toggle this, use the `headless` system property:
* **Headed mode**: `mvn test -Dheadless=false`
* **Headless mode**: `mvn test -Dheadless=true`

### How to run by Cucumber tag
To run tests with a specific tag (e.g., `@Regression`, `@Negative`, `@Positive`):
```bash
mvn test -Dcucumber.filter.tags="@YourTag"
```

### CI/CD behavior
This project uses **GitHub Actions** to run the automated test suite.
* Tests are triggered automatically on:
    * Pushes to the `main` and `develop` branches.
    * Pull requests targeting the `main` branch.
    * Scheduled weekday runs (cron).
* The workflow installs Java 17, installs Playwright Chromium, runs the test suite, and uploads reports.

### Report location
After execution, Cucumber reports are generated at:
* **Local**: `target/cucumber-reports/cucumber.html`
* **CI/CD**: Reports are available as GitHub Action artifacts and published to GitHub Pages.

### Known limitation for third-party protected websites
Some tests target a public third-party website. These tests may be blocked in cloud CI environments because many production websites use CDN/WAF protection such as CloudFront or Cloudflare. For ethical and reliable automation, those scenarios are intended for local/manual execution only and are excluded from CI.

## 6. Test Scope

#### What's Covered:

- **Login Page Validation**: Ensuring correct error messages for empty fields or invalid credentials.
- **UI Integrity**: Verifying password masking and the functionality of the "show password" toggle.
- **Navigation & Redirection**: Validating successful redirection to registration (Personal/Organization) and subscription pages.

#### What's Explicitly Excluded:

- **Successful Authentication**: Full login flow with valid credentials.
- **OTP (One-Time Password) Handling**: Automated extraction or entry of OTPs.
- **Subscription Completion**: End-to-end payment or subscription finalization.

#### Professional OTP & Authentication Decision:

The decision to exclude full authentication and OTP handling is strategic:

1. **TOS Compliance**: Automated interaction with live authentication systems can be flagged as a violation of the site's Terms of Service (TOS).
2. **Environment Control**: The authentication and subscription systems are external and not under the direct control of this test suite. Testing these would lead to high maintenance and potential flakiness.
3. **Security Best Practices**: Avoiding the use of real user data and bypassing security measures like OTP ensures the test suite remains safe and doesn't interfere with real security protocols.

## Note about third-party website testing

* Some tests target a public third-party website. These tests may be blocked in cloud CI environments because many production websites use CDN/WAF protection such as CloudFront or Cloudflare. For ethical and reliable automation, those scenarios are intended for local/manual execution only and are excluded from CI.
