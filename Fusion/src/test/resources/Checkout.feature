Feature: Checkout/Cart functionality for an online store

  Scenario: Checkout cart
    Given The User is on the Checkout Page
    When The User types in First Name
    When The User types in Last Name
    When The User types in Email
    When The User types in Address
    When The User types in City
    When The User types in Postal Code
    When The User types in Country
    Then The User can click Checkout

  Scenario: Remove product from cart
    Given The User is on the Checkout Page
    When The User clicks on Remove Item
    Then The Item Quantity should be reflected inside the Cart