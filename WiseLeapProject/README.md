**Project Overview**

This project automates the following test scenario:

**Login as a Tutor**: Log in to the WiseLeap application using a mobile number.

**Navigate to Classroom**: Go to the classroom section from the homepage.

**Schedule a Session**: Click and schedule a session in the classroom.

**Verify the Session**: Verify that the session is successfully scheduled.

**The project is built using:**
Selenium WebDriver: For browser automation.

TestNG: For test management and execution.

WebDriverManager: For managing browser drivers.

Page Object Model (POM): For better maintainability and readability of the code.

Project Structure
The project is organized as follows:


**Prerequisites**

Before setting up the project, ensure you have the following installed on your system:

Java Development Kit (JDK): Version 11 or higher.

Maven: For building and managing dependencies.

Git: For version control and cloning the repository.

IDE: Vs code

Setup and Installation



**Set Up WebDriverManager:**
The project uses WebDriverManager to automatically manage browser drivers. No manual driver setup is required.

**Running the Tests**
To run the tests, follow these steps:

**Run the Test Suite:**
Use the following command to execute the TestNG suite:


**How It Works**

1. Page Object Model (POM)
The project follows the Page Object Model design pattern:

Page Classes: Each page of the application (e.g., login.java, homepage.java, classroompage.java) has a corresponding class that encapsulates its elements and actions.

Test Classes: Test classes (e.g., testSuite.java) use these page classes to perform actions and assertions.

2. TestNG Annotations
@BeforeTest: Initializes the page objects before running the tests.

@Test: Contains the test logic for logging in, navigating, and scheduling a session.

3. Driver Management
driverManager.java: Manages the WebDriver instance for different browsers (Chrome, Firefox, Edge).

It uses WebDriverManager to automatically download and set up the required browser drivers.

The setBrowser() method sets up the browser based on the provided browserType.

The setDriver() method configures the WebDriver instance with implicit waits and maximizes the browser window.

4. Test Execution Flow
Initialize WebDriver: The driverManager class sets up the WebDriver instance.

Perform Login: The loginobj.performLoginAsATutor() method logs in as a tutor.

Navigate to Classroom: The homepageobj.GoToTheClassroom() method navigates to the classroom section.

Schedule a Session: The classroompageobj.clickandScheduleSession() method schedules a session.

Verify the Session: The classroompageobj.verifySession() method verifies that the session is successfully scheduled.
