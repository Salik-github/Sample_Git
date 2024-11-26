Prerequisites

Java & Maven: Ensure Java 8+ and Maven are installed.
WebDriver: Add browser-specific WebDriver executables (e.g., chromedriver, geckodriver) to your system PATH.
IDE: Use IntelliJ IDEA or Eclipse for efficient test development.

Project Setup


Install Dependencies:

mvn clean install

Configure WebDriver Paths: Ensure drivers are accessible via PATH or explicitly set in the project.

Running Tests

Run All Tests:

mvn test

With Specific TestNG XML:

mvn clean test -DsuiteXmlFile=testng.xml

Run for Specific Browser:


mvn test -Dbrowser=chrome


Viewing Results

Console Output: 
Real-time test status during execution.

Reports:
Check detailed TestNG ExtentReports (e.g., src/main/resources/TestReports.html).


Test Execution Flow

Test Execution Flow Explained

1. Test Setup and Initialization
Objective: Prepare the test environment and initialize the browser.

Process:
Test execution begins as per TestNG annotations (@BeforeSuite, @BeforeTest) or the TestNG XML configuration.

Driver Initialization:
The DriverManager creates a WebDriver instance based on the specified browser type (e.g., ChromeDriver, FirefoxDriver).

Browser Setup:
Timeouts (e.g., implicit waits) are configured for smooth interaction with web elements.

Flow:
Test Start -> Initialize WebDriver -> Browser Setup


3. Interaction with the Home Page
Objective: Navigate and interact with the home page elements.

Process:
Navigation: The HomePage class is used for clicking buttons and verifying the redirection (e.g., navigating to the Revenue Calculator page).

Scroll & Click: Use methods like scrollDownToParticularElement() from BasePage to scroll and interact with buttons or clickable items.

Flow:
Navigate -> Scroll to Elements -> Click & Verify


5. Interaction with the Revenue Calculator Page
   
Objective: Perform user actions like entering data, manipulating sliders, and verifying calculations.

Process:
Adjust Slider: The selectSlider() method drags the slider to a specific value.

Enter Patient Count:
The checkPatientsCount() method handles manual input, clears existing values, and enters data from a configuration file.

checkAttributeAreSame() verifies the entered count matches the expected value.

Select CPT Codes:
collectLengthOfCPTValue() clicks on all available CPT checkboxes, ensuring no mismatch in data or selections.

Revenue Calculation:
The revenueCalculate() method computes revenue based on patient counts and reimbursement values, comparing calculated results with displayed ones for validation.
Flow:

Navigate to Page -> Adjust Slider -> Input Data -> Validate Results


7. Reporting and Logging
   
Objective: Capture test execution details in real-time and generate HTML reports.

Process:
ExtentReports:
Initializes at test start with configuration settings.
Logs test status (pass/fail/skip) and relevant details like errors and screenshots.

HTML Report:
After execution, the final report is generated (e.g., src/main/resources/TestReports.html), summarizing test cases and statuses.

Flow:
Log Test Start -> Capture Test Status -> Generate HTML Report


9. Test Teardown and Cleanup
    
Objective: Release resources and close browser sessions.

WebDriver is closed using DriverManager.quitDriver() to terminate sessions and free resources.

Post-test tasks, such as releasing environment configurations or additional cleanup, are handled in @AfterTest or @AfterSuite.

Flow:
Quit WebDriver -> Perform Cleanup -> End Execution

Key Commands

Action Command

Build Project
mvn clean install

Run Tests
mvn test

Run with TestNG XML
mvn clean test -DsuiteXmlFile=testng.xml

Run with TestCase Class and Method name
         mvn -Dtest=TestRunner#calculateRevenuePerMonth test
         
Run with TestCase Class
  mvn -Dtest=TestRunner test



