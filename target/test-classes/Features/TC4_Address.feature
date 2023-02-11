@Address
Feature: Address Module API Automation

  @reg
  Scenario Outline: Verify Add User Address to the application through API
    Given User add header and Bearrer Authorizarion for accessing address endpoint
    When User add requestbody for add new address "<First_name>","<Last_name>","<Mobile>","<Appartment>","<State>","<City>","<Country>","<Zipcode>","<Address>","<Address_type>"
    And User sent "POST" request for addUserAddress endpoint
    Then User Verify the status code is 200
    Then User Verify the addUserAddress response message matches "Address added successfully"

    Examples: 
      | First_name | Last_name | Mobile     | Appartment | Country | Zipcode | Address     | Address_type |
      | SMohamed   | Anifa     | 9600926142 | AJ         |     101 |  603112 | BillalNagar | home         |

  @reg
  Scenario Outline: Verify Uptate User Address to the application through API
    Given User add header and Bearrer Authorizarion for accessing address endpoint
    When User add requestbody for Uptate new address "<First_name>","<Last_name>","<Mobile>","<Appartment>","<State>","<City>","<Country>","<Zipcode>","<Address>","<Address_type>"
    And User sent "PUT" request for UptateUserAddress endpoint
    Then User Verify the status code is 200
    Then User Verify the UpdateUserAddress response message matches "Address updated successfully"

    Examples: 
      | First_name | Last_name | Mobile     | Appartment | Country | Zipcode | Address     | Address_type |
      | SNoor      | Nabesha   | 9362162193 | AP         |     101 |  624003 | Nagal Nagar | home         |

  Scenario: Verify Get User Address to the application through API
    Given User add header and Bearrer Authorizarion for accessing get address endpoint
    When User sent "GET" request for GetUserAddress endpoint
    Then User Verify the status code is 200
    Then User Verify the GetUserAddress response message matches "OK"

  Scenario: Verify Delete User Address to the application through API
    Given User add header and Bearrer Authorizarion for accessing delete address endpoint
    When User add requestbody for Delete user address add address_id
    And User sent "DELETE" request for DeleteUserAddress endpoint
    Then User Verify the status code is 200
    Then User Verify the DeleteUserAddress response message matches "Address deleted successfully"
