# Homzmart Mobile App Automation Framework

This project is an automation testing framework for the Homzmart mobile app, using the Page Object Model (POM) architecture. The project is built using **Maven** and **TestNG** to structure the tests and manage dependencies.

## Project Structure

- **Main/pages**: Page classes following the Page Object Model (POM), encapsulating elements and actions.
- **Test**/Base**: Contains the BaseTests class for driver initialization and pre comditions required for running tests.
- **Test**: Test classes where each test case is written and organized.

### Key Dependencies

- **Appium Java Client (8.6.0)**: Used for interacting with the mobile application under test.
- **TestNG (6.14.3)**: Testing framework for managing and executing test cases.
- **Selenium (4.23.0)**: WebDriver library to control the mobile app via Appium.



## Getting Started

### Prerequisites

Ensure you have the following tools installed:

- **Java JDK 8+**
- **IntelliJ**
- **Maven**
- **Appium Server**
- **Android Studio** (for Android SDKs)
- **TestNG plugin** (if using an IDE like Eclipse or IntelliJ)

### Running the Tests

1. Clone the repository:

    ```bash
    git clone https://github.com/Mohammed-Nabil99/HomzmartApp-TestAutomation.git
    ```

2. Navigate to the project directory using IntelliJ and open file: SmokeTest.xml then run the file and you will see the test cases begin to run 

3. After execution, the report will be generated under the `/test-output` 
