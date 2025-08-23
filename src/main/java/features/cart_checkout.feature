Feature: Cart and Checkout Functionality


  @smoke
  Scenario: User adds two products to the cart and proceeds to checkout
    Given User opens the application
    When I login with "standard_user" and "secret_sauce"
    And I add two products to the cart
    And I should be on the checkout information page

    Then User fills in checkout information with "Jins", "Tomy", and "76864"
    And User completes the purchase
    Then User should see the "Checkout: Complete!" page