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

### 5. Test Scope

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

### 6. How to Run Locally

#### Prerequisites

- **Java JDK 17**
- **Apache Maven**

#### Execution Steps

1. Clone the repository.
2. Open a terminal in the project root.
3. Run the tests using Maven:
   ```bash
   mvn test
   ```
4. To run specific tags (if configured):
   ```bash
   mvn test -Dcucumber.filter.tags="@Regression"
   ```

### Viewing Reports Locally

After the tests complete, Cucumber reports are generated at:
target/cucumber-reports/cucumber.html and target/cucumber-reports/cucumber.json

### 7. CI/CD
Note: Cannot run in github actions due to limitation on cloudflare checking on the websitte
This project uses **GitHub Actions** to run the automated test suite.

Tests are triggered automatically on:

- Pushes to the `main` branch
- Pushes to the `develop` branch
- Pull requests targeting the `main` branch
- Scheduled weekday runs using cron

The CI workflow installs Java 17, installs Playwright Chromium browser dependencies, runs the Cucumber test suite with Maven, uploads the Cucumber report as an artifact, and publishes the report to GitHub Pages.

GitHub Actions workflow file(deprecated):

[`.github/workflows/ci.yml`](.github/workflows/ci.yml)

### 8. Test Reports(Deprecated)

Cucumber reports are generated after each test run in the following directory:
📊 [Latest Test Report](https://almezi.github.io/pw_java_thejakartapostcom/reports/cucumber.html)

### 9. Known Limitations

- **External Dependencies**: The project does not have control over the target site's backend or live environment changes.
- **Authentication Restrictions**: Due to security and TOS considerations, full authentication and subscription flows are not automated to avoid potential account blocking or TOS violations.
