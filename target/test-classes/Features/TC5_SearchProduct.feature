@SearchProduct
Feature: Search Product Module API Automation

  Scenario Outline: Verify User Search Product through API
    Given User add header for to Search Product
    When User add requestbody for get SearchProduct "<product_Name>"
    And User sent "POST" request for SearchProduct endpoint
    Then User Verify the status code is 200
    Then User Verify the SearchProduct response message matches "OK"

    Examples: 
      | product_Name |
      | nuts         |
