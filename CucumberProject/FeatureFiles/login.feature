Feature: book login Testcase

  Scenario: Login should be success
    Given User should navigate to the application URL
    And User click on the login link
    And User enter the usernaem as salik
    And User enter the password as password
    When User click the login button
    Then Login should be success

    Scenario: Login should be fail
    Given User should navigate to the application URL
    And User click on the login link
    And User enter the usernaem as wrongpasword
    And User enter the password as password1
    When User click the login button
    Then Login should be fail
