@State
Feature: State Module API Automation

  Scenario: Verify User Get State List through api
    Given User add header for to StateList
    When User sent "GET" request for StateList endpoint
    Then User Verify the status code is 200
    Then User Verify the StateList response message matches "Tamil Nadu" and saved StateId
