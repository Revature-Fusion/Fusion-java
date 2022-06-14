Feature: Checkout/Cart functionality for an online store

  Scenario: Checkout cart as a Guest
    Given The User is on the Checkout Page
    And There are items in the cart
    When The User types in Email
    And The User clicks checkout
    Then The User successfully checks out

  Scenario: Checkout cart as a User
    Given The User is on the Checkout Page
    And The User is logged in
    And There are items in the cart
    When The User clicks checkout
    Then The User successfully checks out
