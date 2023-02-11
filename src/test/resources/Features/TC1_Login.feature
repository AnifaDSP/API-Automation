@Login
Feature: Login Module API Automation

  Scenario: Get User Logtoken From Login Endpoint
    Given User add header
    When User add basic authentication for login
    And User sent "POST" request for login endpoint
    Then User Verify the status code is 200
    Then User Verify the Login response body firstname present as "S Mohamed" and get the logtoken saved
