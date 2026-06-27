# Playwright Java Automation - The Jakarta Post

This project is an automated test suite designed for verifying the core functionalities of The Jakarta Post website. It utilizes modern automation tools to ensure reliability and consistency across critical user paths.

### 1. What the project is
An automated testing framework built with Java and Playwright, following the BDD (Behavior Driven Development) approach with Cucumber. It focuses on UI validation, negative testing, and ensuring key navigation flows work as expected.

### 2. What site it targets
- **Target Site**: [The Jakarta Post](https://www.thejakartapost.com)

### 3. Tech Stack
- **Java Version**: 17
- **Playwright Version**: 1.60.0
- **Test Framework**: JUnit 5 + Cucumber
- **Reporting Tool**: Cucumber HTML Report / JSON Report
- **CI Platform**: Configurable for integration with CI/CD platforms like GitHub Actions or Jenkins.

### 4. Project Structure
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

#### Viewing Reports
After the tests complete, you can find the HTML report at:
`target/cucumber-report.html`

### 9. Known Limitations
- **External Dependencies**: The project does not have control over the target site's backend or live environment changes.
- **Authentication Restrictions**: Due to security and TOS considerations, full authentication and subscription flows are not automated to avoid potential account blocking or TOS violations.
