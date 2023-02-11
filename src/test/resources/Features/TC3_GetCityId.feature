@City
Feature: City Module API Automation

  Scenario: Verify User Get City List through api
    Given User add header for to CityList
    When User add requestbody for get CityList enter State_Id
    And User sent "POST" request for CityList endpoint
    Then User Verify the status code is 200
    Then User Verify the CityList response message matches "Chengalpattu" and saved CityId

