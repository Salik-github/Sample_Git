**Automation Framework with TestNG**
**Overview**
This project automates the execution of test cases based on data from an Excel sheet. It integrates dynamic test execution with TestNG's features, including retry logic, listeners, and Extent Reports, along with additional functionalities like email notifications and externalized configurations.

**Features**

Dynamic XML Generation: 
                      Reads test case data (status: yes or no, retry count) from an Excel file to create TestNG XML dynamically.
Retry Mechanism:
                      Implements a global retry logic for failed test cases using a custom RetryAnalyzer.
ITestListener: 
                      Enhances test execution monitoring with custom ITestListener for tracking test case status.
Extent Reports: 
                      Generates comprehensive, visually appealing reports for test execution results.
Email Integration:
                      Sends test execution result report  to HTMLEmail via email.
Configuration Management:
                      Uses a data.properties file for managing configurable parameters like file paths, retry counts, and email settings.

**Technologies Used **
Java
TestNG
Apache POI (for Excel handling)
Extent Reports
HTMLEmail

**Project Structure**
src/test/java: Contains all core logic, including Excel handling, dynamic XML generation, TestNG test cases, listener implementations, and utility classes.
src/test/resources: Configuration files (e.g., data.properties).
src/test/reports: Generated Extent Reports.
src/test/logs: Execution logs.

**Prerequisites**
Java Development Kit (JDK)
Maven
TestNG Plugin
SMTP server access for email functionality
