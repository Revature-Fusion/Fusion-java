Feature: View Previous Orders

  Scenario: User successfully gets previous orders
    Given User is logged in
    And The User clicks on view orders page
    When User clicks on refresh table
    Then The previous orders table is displayed